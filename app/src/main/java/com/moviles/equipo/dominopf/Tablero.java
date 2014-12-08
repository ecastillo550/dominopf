package com.moviles.equipo.dominopf;

/**
 * Created by ecast_000 on 07-Dec-14.
 */
public class Tablero {
    public boolean gameOver = false;
    Deck deck = new Deck();
    public Jugador jugador;
    public Jugador oponente;
    boolean turno;
    byte[] deckEnJuego = new byte[28];
    byte posicionDeckEnJuego = 0;

    //posicion del cursor del deck
    byte deckPosicion = 14;

    public Tablero(){
        jugador = new Jugador(1);
        oponente = new Jugador(2);
        turno = false;
        ponerFicha(oponente, 0);
    }

    public void ponerFicha(Jugador player, int fichaEnMano){
        jugador.cantidadfichas--;
        deckEnJuego[posicionDeckEnJuego] = player.getMano()[fichaEnMano];
        posicionDeckEnJuego++;

        if( player == this.jugador){
            turno = false;
        } else {
            turno = true;
        }
    }

    public byte getDeckPosicion(){
        deckPosicion++;
        return (byte) (deckPosicion-1);
    }

    public boolean comeJugador(Jugador player){
        if  (player.comer(deckPosicion)){
            deckPosicion++;
            return true;
        }
        else
            return false;

    }

}
