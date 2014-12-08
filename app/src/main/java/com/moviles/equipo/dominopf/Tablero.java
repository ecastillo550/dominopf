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
    int num1;
    int num2;
    int x1;
    int y1;
    int x2;
    int y2;

    //posicion del cursor del deck
    byte deckPosicion = 14;

    public Tablero(){
        jugador = new Jugador(1);
        //se etablece el lugar de las fichas
        for(int n = 0; n < 7; n++){
            deck.fichas[n].setPosicion(n,6);
            deck.fichas[n].setRotacion(90);
        }

        oponente = new Jugador(2);
        turno = false;
        num1 = -1;
        num2 = -1;
        ponerFicha(oponente, 0);
    }

    public int ponerFicha(Jugador player, int fichaEnMano){
        if(player.getMano()[fichaEnMano] == -1){
            return 0;
        }
        player.cantidadfichas--;
        deckEnJuego[posicionDeckEnJuego] = player.getMano()[fichaEnMano];

        //si el numero 1 es igual al de la ficha
        if(num1 == deck.fichas[player.getMano()[fichaEnMano]].num1 || num1 == deck.fichas[player.getMano()[fichaEnMano]].num2){
            if (x1 <= 0){
                y1 = 4;
            } else {
                x1--;
            }
            if(deck.fichas[player.getMano()[fichaEnMano]].num1 == num1){
                deck.fichas[player.getMano()[fichaEnMano]].setRotacion(180);
                num1 = deck.fichas[player.getMano()[fichaEnMano]].num2;
            } else{
                num1 = deck.fichas[player.getMano()[fichaEnMano]].num1;
                deck.fichas[player.getMano()[fichaEnMano]].setRotacion(0);
            }
            if (deck.fichas[player.getMano()[fichaEnMano]].num1 == deck.fichas[player.getMano()[fichaEnMano]].num2){
                deck.fichas[player.getMano()[fichaEnMano]].setRotacion(90);
            }
            deck.fichas[player.getMano()[fichaEnMano]].setPosicion(x1, y1);
        }

        if(num2 == deck.fichas[player.getMano()[fichaEnMano]].num1 || num2 == deck.fichas[player.getMano()[fichaEnMano]].num2){
            if (x2 >= 10){
                y2 = 2;
            } else {
                x2++;
            }
            if(deck.fichas[player.getMano()[fichaEnMano]].num2 == num2){
                deck.fichas[player.getMano()[fichaEnMano]].setRotacion(180);
                num2 = deck.fichas[player.getMano()[fichaEnMano]].num1;
            } else{
                num2 = deck.fichas[player.getMano()[fichaEnMano]].num2;
                deck.fichas[player.getMano()[fichaEnMano]].setRotacion(0);
            }
            if (deck.fichas[player.getMano()[fichaEnMano]].num1 == deck.fichas[player.getMano()[fichaEnMano]].num2){
                deck.fichas[player.getMano()[fichaEnMano]].setRotacion(90);
            }
            deck.fichas[player.getMano()[fichaEnMano]].setPosicion(x2, y2);
        }

        // si primera jugada
        if(posicionDeckEnJuego == 0){
            num1 = deck.fichas[deckEnJuego[posicionDeckEnJuego]].num1;
            num2 = deck.fichas[deckEnJuego[posicionDeckEnJuego]].num2;
            deck.fichas[deckEnJuego[posicionDeckEnJuego]].setPosicion(6,3);
            x1 = x2 = 6;
            y1 = y2 = 3;
        }
        posicionDeckEnJuego++;

        //Quitar ficha del jugador
        player.getMano()[fichaEnMano] = -1;

        if( player == this.jugador){
            turno = false;
        } else {
            turno = true;
        }
        return 0;
    }

    public byte getDeckPosicion(){
        deckPosicion++;
        return (byte) (deckPosicion-1);
    }

    public boolean comeJugador(Jugador player){
        if  (player.getLugarMano() != -1){
            if( player == this.jugador){
                deck.fichas[deckPosicion].setPosicion(player.getLugarMano(),6);
                player.comer(deckPosicion);
            }
            deckPosicion++;
            return true;
        }
        else
            return false;

    }

}
