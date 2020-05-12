package com.smartkent.Elevator.singleton;

import com.smartkent.Elevator.enums.LiftStates;

public class LiftPositionSingleton {
    private static LiftPositionSingleton ourInstance = new LiftPositionSingleton();

    public static LiftPositionSingleton getInstance() {
        return ourInstance;
    }

    private LiftPositionSingleton() {
    }

    private int lift1Position = 0;
    private int lift2Position = 0;
    private LiftStates lift1State = LiftStates.IDLE;
    private LiftStates lift2State = LiftStates.IDLE;

    public int getLift1Position() {
        return lift1Position;
    }

    public void setLift1Position(int lift1Position) {
        this.lift1Position = lift1Position;
    }

    public int getLift2Position() {
        return lift2Position;
    }

    public void setLift2Position(int lift2Position) {
        this.lift2Position = lift2Position;
    }

    public LiftStates getLift1State() {
        return lift1State;
    }

    public void setLift1State(LiftStates lift1State) {
        this.lift1State = lift1State;
    }

    public LiftStates getLift2State() {
        return lift2State;
    }

    public void setLift2State(LiftStates lift2State) {
        this.lift2State = lift2State;
    }
}
