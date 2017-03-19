package model;

/**
 * Created by personale on 14/03/2017.
 */
public class Partecipante implements Observer {
    private final Asta asta;
    private double offertaCorrente;
    private String nome;
    private double offerta;

    public Partecipante(String nome, Asta asta){
        this.asta = asta;
        this.nome = nome;
    }

    public double getOffertaCorrente() {
        return offertaCorrente;
    }

    public void setOffertaCorrente(double offertaCorrente) {
        this.offertaCorrente = offertaCorrente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getOfferta() {
        return offerta;
    }

    public void setOfferta(double offerta) {
        this.offerta = offerta;
    }

    @Override
    public void update() {
        this.offertaCorrente = asta.getOffertaCorrente();
    }
}
