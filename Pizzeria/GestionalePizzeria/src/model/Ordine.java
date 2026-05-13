/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;

public class Ordine {
    private int id;
    private ArrayList<Pizza> pizze;
    private double totale;

    public Ordine(int id) {
        this.id = id;
        this.pizze = new ArrayList<>();
        this.totale = 0;
    }

    public void aggiungiPizza(Pizza p) {
        pizze.add(p);
        totale += p.getPrezzo();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Pizza> getPizze() {
        return pizze;
    }

    public double getTotale() {
        return totale;
    }

    @Override
    public String toString() {
        return "Ordine " + id + " - Totale: " + totale + "€";
    }
}
