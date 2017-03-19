package controller;

import model.Asta;
import model.Observer;
import model.Partecipante;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by personale on 14/03/2017.
 */
public class HandlerClient {
    private static HandlerAsta handler;

    public synchronized static void iniziaAsta() {
        if(handler == null){
            handler = new HandlerAsta();
        }
    }

    public static void chooseMode(int i){
        switch (i){
            case 1:
                addPartecipante(new Scanner(System.in).next());
                break;
            case 2:
                removePartecipante(new Scanner(System.in).next());
                break;
            default:
                break;
        }
    }

    private static void addPartecipante(String nome){
        handler.add(new Partecipante(nome, HandlerAsta.getAsta()));
    }

    public static String editOfferta(String nome, double offerta){
        if(HandlerAsta.getAsta().getObservers() != null){
            return checkOfferta(HandlerAsta.getAsta().getObservers(), HandlerAsta.getAsta(), nome, offerta);
        }

        return "Asta non iniziata" + " --> Data corrente: " + LocalDateTime.now();
    }

    private static String checkOfferta(ArrayList<Observer> observer, Asta astaCorrente, String nome, double offerta){
        for(Observer o : observer){
            Partecipante p = ((Partecipante)o);

            if(p.getNome().toLowerCase().contains(nome)){ //Check nome partecipante e offerta successivamente
                if(offerta > astaCorrente.getOffertaCorrente()) {
                    astaCorrente.setOffertaCorrente(offerta); //Set offerta asta
                    p.setOfferta(offerta); //Set offerta partecipante
                    return "Modificato! Offerta più alta: " + offerta + " --> Data corrente: " + LocalDateTime.now();
                }
            }
        }

        return "Non modificato" + " --> Data corrente: " + LocalDateTime.now();
    }

    private static void removePartecipante(String nome){
        handler.remove(new Partecipante(nome, HandlerAsta.getAsta()));
    }
}
