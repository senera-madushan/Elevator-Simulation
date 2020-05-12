package com.smartkent.Elevator.controller;

import com.smartkent.Elevator.dto.EtaResponse;
import com.smartkent.Elevator.enums.LiftStates;
import com.smartkent.Elevator.singleton.LiftPositionSingleton;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@RestController
@Slf4j
public class MainController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @GetMapping("/smartkent/liftsimulation")
    public EtaResponse pickAndDrop(@RequestParam(value = "fromFloor") int fromFloor, @RequestParam(value = "toFloor") int toFloor){
        LiftPositionSingleton liftPositionSingleton = LiftPositionSingleton.getInstance();
        log.info("From Floor "+fromFloor+" to "+toFloor);
       // this.messagingTemplate.convertAndSend("/channel/status", "");
        if (liftPositionSingleton.getLift1Position() == fromFloor){
            liftPositionSingleton.setLift1State(LiftStates.TO_PICKUP);
            log.info("From Floor "+fromFloor+" to "+toFloor+"state"+liftPositionSingleton.getLift1State());
            return new EtaResponse(0);
        }else if (liftPositionSingleton.getLift2Position() == fromFloor){
            liftPositionSingleton.setLift2State(LiftStates.TO_PICKUP);
            log.info("From Floor "+fromFloor+" to "+toFloor+"state"+liftPositionSingleton.getLift1State());
            return new EtaResponse(0);
        }else if (liftPositionSingleton.getLift1State() == LiftStates.IDLE){
            liftPositionSingleton.setLift1State(LiftStates.TO_PICKUP);
            log.info("From Floor "+fromFloor+" to "+toFloor+"state"+liftPositionSingleton.getLift1State());
            return new EtaResponse(Math.abs(liftPositionSingleton.getLift1Position()-fromFloor)*3);
        }else if (liftPositionSingleton.getLift2State() == LiftStates.IDLE){
            liftPositionSingleton.setLift1State(LiftStates.TO_PICKUP);
            log.info("From Floor "+fromFloor+" to "+toFloor+"state"+liftPositionSingleton.getLift1State());
            return new EtaResponse(Math.abs(liftPositionSingleton.getLift2Position()-fromFloor)*3);
        }else if (liftPositionSingleton.getLift1State() == LiftStates.TO_PICKUP || liftPositionSingleton.getLift1State() == LiftStates.TO_DROPOFF){
            int lift1Eta = 4 + Math.abs(liftPositionSingleton.getLift1Position()-fromFloor)*3;
            int lift2Eta = 4 + Math.abs(liftPositionSingleton.getLift2Position()-fromFloor)*3;
            log.info("From Floor "+fromFloor+" to "+toFloor+"state"+liftPositionSingleton.getLift1State());
            if (liftPositionSingleton.getLift2State() == LiftStates.TO_PICKUP || liftPositionSingleton.getLift2State() == LiftStates.TO_DROPOFF){
                log.info("From Floor "+fromFloor+" to "+toFloor+"state"+liftPositionSingleton.getLift1State());
                return new EtaResponse(Math.min(lift1Eta, lift2Eta));

            }else {
                log.info("From Floor "+fromFloor+" to "+toFloor+"state"+liftPositionSingleton.getLift1State());
                return new EtaResponse(Math.abs(lift2Eta - 4));
            }
        }else {
            log.info("From Floor "+fromFloor+" to "+toFloor+"state"+liftPositionSingleton.getLift1State());
            return new EtaResponse(Math.abs(liftPositionSingleton.getLift1Position()-fromFloor)*3);
        }
    }

}
