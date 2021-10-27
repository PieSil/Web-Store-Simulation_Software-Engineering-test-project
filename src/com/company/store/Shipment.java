package com.company.store;
import com.company.constants.Constants;

public class Shipment {

    Shipment(String sender, String receiver, String senderAddress, String destinationAddress, String contents, int id) {
        this.sender = sender;
        this.receiver = receiver;
        this.senderAddress = senderAddress;
        this.destinationAddress = destinationAddress;
        this.contents = contents;
        this.id = id;
    }

    public void SetState(String state) {
        this.state = state;
    }

    public String GetSender() {
        return sender;
    }

    public String GetReceiver() {
        return receiver;
    }

    public String GetSenderAddress() {
        return senderAddress;
    }

    public String GetDestinationAddress() {
        return destinationAddress;
    }

    public String GetContents() {
        return contents;
    }

    public int GetId() {
        return id;
    }

    public String GetState() {
        return state;
    }

    private String sender;
    private String receiver;
    private String senderAddress;
    private String destinationAddress;
    private String contents;
    private int id;
    private String state = Constants.INITIAL_STATE;
}
