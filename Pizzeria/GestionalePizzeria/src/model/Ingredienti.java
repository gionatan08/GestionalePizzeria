/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sespo
 */
public class Ingredienti {

    private int idPizza;

    private String ingrediente;

    public Ingredienti(int idPizza, String ingrediente) {

        this.idPizza = idPizza;

        this.ingrediente = ingrediente;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public String getIngrediente() {
        return ingrediente;
    }
}
