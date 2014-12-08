package com.moviles.equipo.dominopf;

/**
 * Created by ecast_000 on 07-Dec-14.
 */
public class Ficha {
    int num1;
    int num2;
    int x;
    int y;
    String nombreArchivo;
    float rotacion;

    public Ficha(int num1, int num2, String nombreArchivo){
        this.num1 = num1;
        this.num2 = num2;
        this.nombreArchivo = nombreArchivo;
    }

    public void setRotacion(float rotacion){
        this.rotacion = rotacion;
    }

    public float getRotacion(){
        return rotacion;
    }

    public void setPosicion(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
