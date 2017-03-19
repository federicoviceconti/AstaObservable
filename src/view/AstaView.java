package view;

import controller.HandlerAsta;
import controller.HandlerClient;

import java.util.Scanner;

/**
 * Created by personale on 14/03/2017.
 */
class AstaView {
    void start() {
        print();
        /* ************** */
        while(!HandlerAsta.isTimeFinished()){
            System.out.println("Inserisci nome partecipante e offerta: ");
            System.out.println(HandlerClient.editOfferta(new Scanner(System.in).next(), new Scanner(System.in).nextDouble()));
        }
        /* ************* */
        winner();
    }

    private void winner() {
        HandlerAsta.getAsta().scegliVincitore();

        if(HandlerAsta.getAsta().getVincitore() != null)
            System.out.println("Vincitore dell'asta: " + HandlerAsta.getAsta().getVincitore().getNome());
        else {
            System.out.println("Nessun vincitore!");
        }
        print();
    }

    private void print() {
        System.out.println(HandlerAsta.print());
    }
}
