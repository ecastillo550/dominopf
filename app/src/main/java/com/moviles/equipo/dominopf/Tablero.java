package com.moviles.equipo.dominopf;

/**
 * Created by ecast_000 on 07-Dec-14.
 */
public class Tablero {
    public boolean gameOver = false;
    Deck deck = new Deck();
    public Jugador jugador;
    public Jugador oponente;
    //posicion del cursor del deck
    byte deckPosicion = 14;

    public Tablero(){
        jugador = new Jugador(1);
        oponente = new Jugador(2);
    }

    public byte getDeckPosicion(){
        deckPosicion++;
        return (byte) (deckPosicion-1);
    }

}
