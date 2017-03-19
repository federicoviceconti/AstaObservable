package view;

import controller.HandlerAsta;
import controller.HandlerClient;

import java.util.Scanner;

/**
 * Created by personale on 14/03/2017.
 */
public class MainView {

    public static void main(String[] args) {
        AstaView astaView = new AstaView();
        createAsta();
        managePartecipanti();

        while (HandlerAsta.getAsta().isStato()){
            astaView.start();
        }
    }

    private static void createAsta() {
        HandlerClient.iniziaAsta();
    }

    private static void managePartecipanti() {
        int res = -1;

        while(res != 3){
            System.out.println("****Partecipanti****\n1: Aggiungi - 2: Rimuovi - 3: Inizia asta");
            HandlerClient.chooseMode(res = new Scanner(System.in).nextInt());
        }
    }
}
