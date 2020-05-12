package com.smartkent.Elevator.dto;

import com.smartkent.Elevator.enums.Directions;
import com.smartkent.Elevator.enums.LiftStates;

public class Lift {
    private int liftId;
    private LiftStates state;
    private Directions direction;
    private int person;
    private int floor;

    public Lift() {
    }

    public Lift(int liftId, LiftStates state, Directions direction, int person, int floor) {
        this.liftId = liftId;
        this.state = state;
        this.direction = direction;
        this.person = person;
        this.floor = floor;
    }

    public int getLiftId() {
        return liftId;
    }

    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }

    public LiftStates getState() {
        return state;
    }

    public void setState(LiftStates state) {
        this.state = state;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
