package com.smartkent.Elevator.dto;

public class EtaResponse {
    private int ETA;

    public EtaResponse(int ETA) {
        this.ETA = ETA;
    }

    public int getETA() {
        return ETA;
    }

    public void setETA(int ETA) {
        this.ETA = ETA;
    }
}
