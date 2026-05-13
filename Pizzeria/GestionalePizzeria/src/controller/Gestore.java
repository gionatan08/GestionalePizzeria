/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Pizza;
import model.Ordine;

import java.util.*;
import java.io.*;
import model.Drink;
import model.Ingredienti;

public class Gestore {

    private ArrayList<Pizza> pizze;
    private ArrayList<Ordine> ordini;
    private ArrayList<Drink> drinks;
    private ArrayList<Ingredienti> ingredienti;

    public Gestore() {
        pizze = new ArrayList<>();
        ordini = new ArrayList<>();
        drinks = new ArrayList<>();
        ingredienti = new ArrayList<>();
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

                Pizza pizza = new Pizza(id, nome, prezzo);

                pizze.add(pizza);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaDrink() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("drink.csv"));
            String line;

            br.readLine(); // salta intestazione

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String nome = parts[1];
                double prezzo = Double.parseDouble(parts[2]);

                Drink drink = new Drink(id, nome, prezzo);

                drinks.add(drink);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvaOrdine(String id, String nome,
            String pizza, String drink, double totale) {

        try {

            FileWriter fw = new FileWriter("ordini.csv", true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(id + ","
                    + nome + ","
                    + pizza + ","
                    + drink + ","
                    + totale);

            pw.close();

        } catch (IOException e) {

            System.out.println("Errore salvataggio CSV");
        }
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
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

    // ---------- INGREDIENTI ----------
    public void caricaIngredienti() {

        try {

            BufferedReader br
                    = new BufferedReader(
                            new FileReader("ingredienti.csv"));

            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                int idPizza
                        = Integer.parseInt(parts[0].trim());

                String ingrediente
                        = parts[1].trim();

                Ingredienti i = new Ingredienti(idPizza, ingrediente);

                ingredienti.add(i);
            }

            br.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public ArrayList<Ingredienti> getIngredienti() {
        return ingredienti;
    }
}
