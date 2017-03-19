package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by personale on 14/03/2017.
 */
public class Asta implements Subject{
    private ArrayList<Observer> observers = new ArrayList<>();
    private int id;
    private static int counterId;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
    private Partecipante vincitore;
    private boolean stato;
    private double offertaCorrente = -1d;
    private final int DURATION_MAX = 1;

    public Asta(){
        this.id = ++counterId;
        this.dataInizio = LocalDateTime.now();
        this.dataFine = dataInizio.plus(Duration.ofMinutes(DURATION_MAX));
        this.stato = true;
    }

    @Override
    public String toString() {
        return "Id: " + id
                + "\nOfferta corrente: " + offertaCorrente
                + "\nData inizio: " + dataInizio.format(DateTimeFormatter.ISO_DATE_TIME)
                + "\nData chiusura: " + dataFine.format(DateTimeFormatter.ISO_DATE_TIME)
                + "\nStato: " + (stato ? "Aperta" : "Chiusa")
                + "\nPartecipanti: " + printObserver();
    }

    private String printObserver(){
        String s = "\n";

        for(Observer o : observers){
            s += "- " + ((Partecipante)o).getNome() + "\n";
        }

        return s;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer o : observers){
            o.update();
        }
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public LocalDateTime getDataFine() {
        return dataFine;
    }

    public Partecipante getVincitore() {
        if(vincitore != null){
            return vincitore;
        }

        return null;
    }
    public boolean isStato() {
        return stato;
    }

    public void setDataFine(LocalDateTime dataFine) {
        this.dataFine = dataFine;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }

    public double getOffertaCorrente() {
        return offertaCorrente;
    }

    public void setOffertaCorrente(double offertaCorrente) {
        this.offertaCorrente = offertaCorrente;
        notifyObserver();
    }

    private void setVincitore(Partecipante vincitore) {
        this.vincitore = vincitore;
    }

    public void scegliVincitore() {
        double max = 0;

        for(Observer o : observers){
            if(((Partecipante)o).getOfferta() > max){
                setVincitore((Partecipante)o);
            }
        }

        fineAsta();
    }

    private void fineAsta(){
        dataFine = LocalDateTime.now();
        setStato(false);
    }
}
