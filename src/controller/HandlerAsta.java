package controller;

import model.Asta;
import model.Observer;

import java.time.LocalTime;

/**
 * Created by personale on 14/03/2017.
 */
public class HandlerAsta {
    private static Asta asta;

    HandlerAsta() {
        startAsta();
    }

    public static boolean isTimeFinished() {
        return asta.getDataFine().toLocalTime().isBefore(LocalTime.now());
    }

    private synchronized void startAsta() {
        if(asta == null) {
            asta = new Asta();
        }
    }

    public static Asta getAsta() {
        if(asta != null)
            return asta;

        return null;
    }

    void add(Observer o) {
        asta.addObserver(o);
    }

    void remove(Observer o) {
        asta.removeObserver(o);
    }

    public static String print(){
        return asta.toString();
    }

}
