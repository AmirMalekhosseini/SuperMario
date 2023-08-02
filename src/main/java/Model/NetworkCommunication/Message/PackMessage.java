package Model.NetworkCommunication.Message;

import Model.OnlineStorePack.Pack;

import java.util.ArrayList;

public class PackMessage extends Message {

    private ArrayList<Pack> packs;

    public PackMessage() {

    }

    public ArrayList<Pack> getPacks() {
        return packs;
    }

    public void setPacks(ArrayList<Pack> packs) {
        this.packs = packs;
    }
}
