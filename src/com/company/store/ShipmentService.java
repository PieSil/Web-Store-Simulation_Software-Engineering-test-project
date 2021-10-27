package com.company.store;

public abstract class ShipmentService {

    ShipmentService(int priority, Shipment shipment) {
        this.priority = priority;
        this.shipment = shipment;
    }

    public void UpdateShipmentState() {

    }

    void ChangeAddress() {

    }

    void CreateReturn() {

    }

    void RequestCourier() {

    }

    private int priority;
    private Shipment shipment;
}
