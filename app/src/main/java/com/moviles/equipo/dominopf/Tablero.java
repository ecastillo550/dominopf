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
    char direccion1 = 'i';
    char direccion2 = 'd';

    //posicion del cursor del deck
    byte deckPosicion = 14;

    public Tablero(){
        jugador = new Jugador(1);
        //se etablece el lugar de las fichas
        for(int n = 0; n < 7; n++){
            deck.fichas[n].setPosicion(n,6);
            deck.fichas[n].setRotacion(90);
        }

        for(int n = 7; n < 14; n++){
            deck.fichas[n].setPosicion(n-5,0);
            deck.fichas[n].setRotacion(0);
        }

        oponente = new Jugador(2);
        turno = false;
        num1 = -1;
        num2 = -1;
        ponerFicha(oponente, 0);
    }

    public int jugar(int fichaEnMano){
        ponerFicha(jugador, fichaEnMano);
        int resp = oponente.getOpcion();
        if (resp != -1){
            ponerFicha(oponente, resp);
        } else {
            this.comeJugador(oponente);
        }
        return 0;
    }

    public int ponerFicha(Jugador player, int fichaEnMano){
        boolean trans1 = false, trans2 = false;

        //validaciones para saber si vale la pena lo demas
        if(player.getMano()[fichaEnMano] == -1){
            return -1;
        }
        if (num2 != deck.fichas[player.getMano()[fichaEnMano]].num1 &&
                num2 != deck.fichas[player.getMano()[fichaEnMano]].num2 &&
                num1 != deck.fichas[player.getMano()[fichaEnMano]].num1 &&
                num1 != deck.fichas[player.getMano()[fichaEnMano]].num2
                && posicionDeckEnJuego != 0) {
            return -1;
        }

        player.cantidadfichas--;
        deckEnJuego[posicionDeckEnJuego] = player.getMano()[fichaEnMano];

    //IZQUIERDAA
        if (num1 == deck.fichas[player.getMano()[fichaEnMano]].num1 || num1 == deck.fichas[player.getMano()[fichaEnMano]].num2) {
            if (direccion1 == 'i') {
                x1--;
            } else {
                trans1 = false;
                x1++;
            }
            if (x1 <= 1) {
                direccion1 = 'd';
                y1 = 4;
                x1++;
                trans1 = true;
            }
            if (deck.fichas[player.getMano()[fichaEnMano]].num1 == num1) {
                if (direccion1 == 'i') {
                    deck.fichas[player.getMano()[fichaEnMano]].setRotacion(180);
                } else {
                    deck.fichas[player.getMano()[fichaEnMano]].setRotacion(0);
                }
                if(trans1){
                    deck.fichas[player.getMano()[fichaEnMano]].setRotacion(90);
                }
                num1 = deck.fichas[player.getMano()[fichaEnMano]].num2;
            } else {
                if (direccion1 == 'i') {
                    deck.fichas[player.getMano()[fichaEnMano]].setRotacion(0);
                } else {
                    deck.fichas[player.getMano()[fichaEnMano]].setRotacion(180);
                }
                num1 = deck.fichas[player.getMano()[fichaEnMano]].num1;
                if(trans1){
                    deck.fichas[player.getMano()[fichaEnMano]].setRotacion(270);
                }
            }
            if (deck.fichas[player.getMano()[fichaEnMano]].num1 == deck.fichas[player.getMano()[fichaEnMano]].num2) {
                deck.fichas[player.getMano()[fichaEnMano]].setRotacion(90);
            }
            deck.fichas[player.getMano()[fichaEnMano]].setPosicion(x1, y1);
        }

    //DERECHA
        if (num2 == deck.fichas[player.getMano()[fichaEnMano]].num1 || num2 == deck.fichas[player.getMano()[fichaEnMano]].num2) {
            if (direccion2 == 'd') {
                x2++;
            } else {
                trans2 = false;
                x2--;
            }
            if (x2 >= 10) {
                direccion2 = 'i';
                y2 = 2;
                x2--;
                trans2 = true;
            }
            if (deck.fichas[player.getMano()[fichaEnMano]].num2 == num2) {
                if (direccion2 == 'd'){
                    deck.fichas[player.getMano()[fichaEnMano]].setRotacion(180);
                } else {
                    deck.fichas[player.getMano()[fichaEnMano]].setRotacion(0);
                }
                num2 = deck.fichas[player.getMano()[fichaEnMano]].num1;
                if(trans2){
                    deck.fichas[player.getMano()[fichaEnMano]].setRotacion(90);
                }
            } else {
                if (direccion2 == 'd'){
                    deck.fichas[player.getMano()[fichaEnMano]].setRotacion(0);
                } else {
                    deck.fichas[player.getMano()[fichaEnMano]].setRotacion(180);
                }
                num2 = deck.fichas[player.getMano()[fichaEnMano]].num2;
                if(trans2){
                    deck.fichas[player.getMano()[fichaEnMano]].setRotacion(270);
                }
            }
            if (deck.fichas[player.getMano()[fichaEnMano]].num1 == deck.fichas[player.getMano()[fichaEnMano]].num2) {
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
            if( player == this.oponente){
                deck.fichas[deckPosicion].setPosicion(player.getLugarMano(),0);
                player.comer(deckPosicion);
            }
            deckPosicion++;
            return true;
        }
        else
            return false;

    }

}
