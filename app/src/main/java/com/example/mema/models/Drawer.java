package com.example.mema.models;

import android.util.Log;

import java.util.ArrayList;

public class Drawer {
    private final static int POSITIONS_LIMIT = 2;
    private String flavour;
    private ArrayList<Product> produtos;
    private int quantityAvailable;

    public Drawer(String flavour){
        this.flavour = flavour;
        this.produtos = new ArrayList<>();
        this.quantityAvailable = 0;
    }
    public Drawer(String flavour, ArrayList<Product> produtos, int quantityAvailable) {
        this.flavour = flavour;
        this.produtos = produtos;
        this.quantityAvailable = quantityAvailable;
    }

    public String getFlavour() {

        return flavour;
    }

    public void setFlavour(String flavour) {

        this.flavour = flavour;
    }

    public ArrayList<Product> getProdutos() {

        return produtos;
    }

    public void setProdutos(ArrayList<Product> produtos) {

        this.produtos = produtos;
    }

    public int getQuantityAvailable() {

        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public int productsQuantity(){

        return produtos.size();
    }
    public boolean addProduct(Product p) {
        if(this.produtos.size() < POSITIONS_LIMIT) {
            this.produtos.add(p);
            return true;
        }else{
            return false;
        }
    }
    /*
    * O nome do metodo é getFirstProduct
    * Este metodo retorma o produto que esta na posição 0 da gaveta
    */
    public Product getFirstProduct() {
        Product p1 = this.produtos.get(0);
        return p1;
    }
     /*
     * Este metodo simula o pacote das pringels a cair da maquina
      */
    public boolean downloadProducts() {
        if( ! this.isEmpty()){
            this.produtos.remove(0);
            return true;
        }else{
            return false;
        }
    }
    /*
    * Este metodo verifica se a gaveta esta vazia
     */
    public boolean isEmpty () {
        if(this.produtos.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    /*
    *Este metodo verifica se a gaveta tem produtos
     */
    public boolean isFull() {
        if(this.produtos.size() == POSITIONS_LIMIT ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Drawer{" +
                "flavour='" + flavour + '\'' +
                ", produtos=" + produtos +
                ", quantityAvailable=" + quantityAvailable +
                '}';
    }
}
