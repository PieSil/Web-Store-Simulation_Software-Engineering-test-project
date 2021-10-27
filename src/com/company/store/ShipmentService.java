package com.company.store;

public abstract class ShipmentService {

    ShipmentService(int priority, Shipment shipment) {
        this.priority = priority;
        this.shipment = shipment;
    }

    public void updateShipmentState() {

    }

    void changeAddress() {

    }

    void createReturn() {

    }

    void requestCourier() {

    }

    private final int priority;
    private final Shipment shipment;
}
