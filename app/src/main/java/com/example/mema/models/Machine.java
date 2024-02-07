package com.example.mema.models;

import java.util.ArrayList;

public class Machine {
    private final static int DISCOUNT = 10;
    private final static int DAYS_TO_DISCOUNT = 4;
    private ArrayList<Drawer> drawers;
    private int selectDrawerNumber;

    public Machine(String flavour1, String flavour2, String flavour3, String flavour4){
        this.drawers = new ArrayList<>();

        this.drawers.add(new Drawer(flavour1));
        this.drawers.add(new Drawer(flavour2));
        this.drawers.add(new Drawer(flavour3));
        this.drawers.add(new Drawer(flavour4));
    }

    public ArrayList<Drawer> getDrawers() {
        return this.drawers;
    }

    public void setDrawers(ArrayList<Drawer> drawers) {
        this.drawers = drawers;
    }

    public int getSelectDrawerNumber() {
        return this.selectDrawerNumber;
    }

    public void setSelectDrawerNumber(int selectDrawerNumber) {
        this.selectDrawerNumber = selectDrawerNumber;
    }
    public void addProductToDrawer(int i, Product productAdd){
        this.drawers.get(i).addProduct(productAdd);
    }

    public int verifyQuantityAvailable(int n){
        return this.drawers.get(n).productsQuantity();
    }

    @Override
    public String toString() {
        return "Machine{" +
                "drawers=" + drawers +
                ", selectDrawerNumber=" + selectDrawerNumber +
                '}';
    }
}
