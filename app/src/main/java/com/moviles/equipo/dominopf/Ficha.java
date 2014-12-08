package com.moviles.equipo.dominopf;

/**
 * Created by ecast_000 on 07-Dec-14.
 */
public class Ficha {
    int num1;
    int num2;
    float rotacion;

    public Ficha(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public void setRotacion(float rotacion){
        this.rotacion = rotacion;
    }

    public float getRotacion(){
        return rotacion;
    }
}
