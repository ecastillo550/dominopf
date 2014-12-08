package com.moviles.equipo.dominopf;

/**
 * Created by ecast_000 on 07-Dec-14.
 */
public class Jugador {
    byte[] mano = new byte[10];
    public byte cantidadfichas = 0;

    public Jugador(int numJugador) {
        if (numJugador == 1) {
            for (int n = 0; n < 10; n++) {
                if (n < 7) {
                    mano[n] = (byte) n;
                } else {
                    mano[n] = -1;
                }
            }
        }
        if (numJugador == 2) {
            for (int n = 0; n < 10; n++) {
                if (n < 7) {
                    mano[n] = (byte) (n+7);
                } else{
                    mano[n] = -1;
                }
            }
        }

        cantidadfichas = 7;
    }

    public byte[] getMano(){
        return mano;
    }

    public boolean comer(byte deckPosicion){
        boolean flag = true;
        int n = 0;

        while(flag) {
            if (n < 10) {
                if (mano[n] == -1) {
                    mano[n] = deckPosicion;
                    flag = false;
                    cantidadfichas++;
                    return true;
                }
                n++;
            }
            else {
                flag = false;
            }
        }
        return false;
    }

}