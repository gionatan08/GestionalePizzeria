/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Pizza;
import model.Ordine;

import java.util.*;
import java.io.*;

public class Gestore {

    private ArrayList<Pizza> pizze;
    private ArrayList<Ordine> ordini;

    public Gestore() {
        pizze = new ArrayList<>();
        ordini = new ArrayList<>();
    }

    // ---------- PIZZE ----------
   public void caricaPizze() {
       

    try {
        BufferedReader br = new BufferedReader(new FileReader("pizze.csv"));
        String line;

        br.readLine(); // salta intestazione

        while ((line = br.readLine()) != null) {

            String[] parts = line.split(",");
            
            int id = Integer.parseInt(parts[0]);
            String nome = parts[1];
            double prezzo = Double.parseDouble(parts[2]);

            Pizza pizza = new Pizza(id,nome, prezzo);

            pizze.add(pizza);
        }

        br.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void rimuoviPizza(int id) {
    for (int i = 0; i < pizze.size(); i++) {
        if (pizze.get(i).getId() == id) {
            pizze.remove(i);
            break; // esce dopo aver trovato la pizza
        }
    }
}

    public ArrayList<Pizza> getPizze() {
        return pizze;
    }

    // ---------- ORDINI ----------
    public void aggiungiOrdine(Ordine o) {
        ordini.add(o);
    }

    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }

    // ---------- RICERCA ----------
    public ArrayList<Pizza> cercaPerNome(String nome) {
        ArrayList<Pizza> risultato = new ArrayList<>();
        for (Pizza p : pizze) {
            if (p.getNome().toLowerCase().contains(nome.toLowerCase())) {//equals
                risultato.add(p);
            }
        }
        return risultato;
    }

    public ArrayList<Pizza> cercaPerPrezzo(double prezzo) {
        ArrayList<Pizza> risultato = new ArrayList<>();
        for (Pizza p : pizze) {
            if (p.getPrezzo() <= prezzo) {
                risultato.add(p);
            }
        }
        return risultato;
    }

   

 
}