package com.moviles.equipo.dominopf;

import java.util.Random;

/**
 * Created by ecast_000 on 07-Dec-14.
 */
public class Deck {
    Ficha[] fichas = new Ficha[28];

    public Deck(){
        byte[] deck = new byte[28];
        byte num1 = 0;
        byte num2 = 0;

        //inicializacion de numeros random
        for (byte n = 0; n < 28 ; n++){
            deck[n] = -1;
        }

        Random random = new Random();
        byte range = 27 + 1;
        byte randomnumber = -1;
        boolean esta = false;

        for (byte n = 0; n < 28 ; n++){
            do{
                esta = false;
                randomnumber = (byte)random.nextInt(range);
                for (byte i = 0; i < 28 ; i++) {
                    if (deck[i] == randomnumber) {
                        esta = true;
                    }
                }
                if (!esta){
                    deck[n] = randomnumber;
                }
            } while(esta);
        }

        //inicializacion de las fichas
        for(byte n = 0; n<28; n++){
            fichas[deck[n]] = new Ficha(num1,num2);
            if (num2 >= 6 ){
                num2 = num1;
                num1++;
            }
            num2++;
        }


    }
}

/*
id: 0 nums: 0 0
id: 1 nums: 0 1
id: 2 nums: 0 2
id: 3 nums: 0 3
id: 4 nums: 0 4
id: 5 nums: 0 5
id: 6 nums: 0 6
id: 7 nums: 1 1
id: 8 nums: 1 2
id: 9 nums: 1 3
id: 10 nums: 1 4
id: 11 nums: 1 5
id: 12 nums: 1 6
id: 13 nums: 2 2
id: 14 nums: 2 3
id: 15 nums: 2 4
id: 16 nums: 2 5
id: 17 nums: 2 6
id: 18 nums: 3 3
id: 19 nums: 3 4
id: 20 nums: 3 5
id: 21 nums: 3 6
id: 22 nums: 4 4
id: 23 nums: 4 5
id: 24 nums: 4 6
id: 25 nums: 5 5
id: 26 nums: 5 6
id: 27 nums: 6 6
 */

