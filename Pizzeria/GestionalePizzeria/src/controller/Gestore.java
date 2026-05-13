package controller;

import model.Pizza;
import model.Drink;
import model.Ingredienti;

import java.util.ArrayList;
import java.io.*;

public class Gestore {

    private ArrayList<Pizza> pizze;
    private ArrayList<Drink> drinks;
    private ArrayList<Ingredienti> ingredienti;

    public Gestore() {

        pizze = new ArrayList<>();
        drinks = new ArrayList<>();
        ingredienti = new ArrayList<>();
    }

    // ---------- PIZZE ----------
    public void caricaPizze() {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("pizze.csv"));

            String line;

            br.readLine(); // salta intestazione

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String nome = parts[1];
                double prezzo =
                        Double.parseDouble(parts[2]);

                Pizza pizza =
                        new Pizza(id, nome, prezzo);

                pizze.add(pizza);
            }

            br.close();

        } catch (IOException e) {

            System.out.println(
                    "Errore caricamento pizze");
        }
    }

    // ---------- DRINK ----------
    public void caricaDrink() {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("drink.csv"));

            String line;

            br.readLine(); // salta intestazione

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String nome = parts[1];
                double prezzo =
                        Double.parseDouble(parts[2]);

                Drink drink =
                        new Drink(id, nome, prezzo);

                drinks.add(drink);
            }

            br.close();

        } catch (IOException e) {

            System.out.println(
                    "Errore caricamento drink");
        }
    }

    // ---------- INGREDIENTI ----------
    public void caricaIngredienti() {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("ingredienti.csv"));

            String line;

            br.readLine(); // salta intestazione

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                int idPizza =
                        Integer.parseInt(parts[0].trim());

                String ingrediente =
                        parts[1].trim();

                Ingredienti i =
                        new Ingredienti(idPizza, ingrediente);

                ingredienti.add(i);
            }

            br.close();

        } catch (IOException e) {

            System.out.println(
                    "Errore caricamento ingredienti");
        }
    }

    // ---------- ORDINI ----------
    public ArrayList<String> caricaOrdini() {

        ArrayList<String> ordini =
                new ArrayList<>();

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("ordini.csv"));

            String line;

            // NON salta intestazione

            while ((line = br.readLine()) != null) {

                ordini.add(line);
            }

            br.close();

        } catch (IOException e) {

            System.out.println(
                    "Errore lettura ordini");
        }

        return ordini;
    }

    // ---------- SALVA ORDINE ----------
    public void salvaOrdine(String id,
            String nome,
            String pizza,
            String drink,
            double totale) {

        try {

            FileWriter fw =
                    new FileWriter("ordini.csv", true);

            PrintWriter pw =
                    new PrintWriter(fw);

            pw.println(id + ","
                    + nome + ","
                    + pizza + ","
                    + drink + ", totale "
                    + totale);

            pw.close();

        } catch (IOException e) {

            System.out.println(
                    "Errore salvataggio CSV");
        }
    }

    // ---------- GET ----------
    public ArrayList<Pizza> getPizze() {
        return pizze;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Ingredienti> getIngredienti() {
        return ingredienti;
    }

    // ---------- RIMUOVI PIZZA ----------
    public void rimuoviPizza(int id) {

        for (int i = 0; i < pizze.size(); i++) {

            if (pizze.get(i).getId() == id) {

                pizze.remove(i);
                break;
            }
        }
    }
}