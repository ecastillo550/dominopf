package com.moviles.equipo.dominopf;

/**
 * Created by ecast_000 on 07-Dec-14.
 */

import com.moviles.equipo.framework.Pixmap;
import com.moviles.equipo.framework.Sound;

public class Assets {
    volatile public static Pixmap _00;
    volatile public static Pixmap _01;
    volatile public static Pixmap _02;
    volatile public static Pixmap _03;
    volatile public static Pixmap _11;
    volatile public static Pixmap _12;
    volatile public static Pixmap _13;
    volatile public static Pixmap _14;
    volatile public static Pixmap _22;
    volatile public static Pixmap _23;
    volatile public static Pixmap _24;
    volatile public static Pixmap _25;
    volatile public static Pixmap _33;
    volatile public static Pixmap _34;
    volatile public static Pixmap _35;
    volatile public static Pixmap _36;
    volatile public static Pixmap _04;
    volatile public static Pixmap _44;
    volatile public static Pixmap _45;
    volatile public static Pixmap _46;
    volatile public static Pixmap _05;
    volatile public static Pixmap _15;
    volatile public static Pixmap _55;
    volatile public static Pixmap _56;
    volatile public static Pixmap _06;
    volatile public static Pixmap _16;
    volatile public static Pixmap _26;
    volatile public static Pixmap _66;
    volatile public static Pixmap _back;
    volatile public static Pixmap background;
    volatile public static Pixmap botonjugar;
    volatile public static Pixmap creditos;
    volatile public static Pixmap backgroundGame;
    volatile public static Pixmap creditosback;
    volatile public static Pixmap ganaste;
    volatile public static Pixmap perdiste;

    volatile public static Sound click;
    public static Pixmap getPieza(String nombre) {
        if (nombre.equals("_00")) {
            return _00;
        }
        if (nombre.equals("_01")) {
            return _01;
        }
        if (nombre.equals("_02")) {
            return _02;
        }
        if (nombre.equals("_03")) {
            return _03;
        }
        if (nombre.equals("_04")) {
            return _04;
        }
        if (nombre.equals("_05")) {
            return _05;
        }
        if (nombre.equals("_06")) {
            return _06;
        }
        if (nombre.equals("_11")) {
            return _11;
        }
        if (nombre.equals("_12")) {
            return _12;
        }
        if (nombre.equals("_13")) {
            return _13;
        }
        if (nombre.equals("_14")) {
            return _14;
        }
        if (nombre.equals("_15")) {
            return _15;
        }
        if (nombre.equals("_16")) {
            return _16;
        }
        if (nombre.equals("_22")) {
            return _22;
        }
        if (nombre.equals("_23")) {
            return _23;
        }
        if (nombre.equals("_24")) {
            return _24;
        }
        if (nombre.equals("_25")) {
            return _25;
        }
        if (nombre.equals("_26")) {
            return _26;
        }
        if (nombre.equals("_33")) {
            return _33;
        }
        if (nombre.equals("_34")) {
            return _34;
        }
        if (nombre.equals("_35")) {
            return _35;
        }
        if (nombre.equals("_36")) {
            return _36;
        }
        if (nombre.equals("_44")) {
            return _44;
        }
        if (nombre.equals("_45")) {
            return _45;
        }
        if (nombre.equals("_46")) {
            return _46;
        }
        if (nombre.equals("_55")) {
            return _55;
        }
        if (nombre.equals("56")) {
            return _56;
        }
        if (nombre.equals("_66")) {
            return _66;
        }
        if (nombre.equals("_back")) {
            return _back;
        }
        return _back;
    }

}
