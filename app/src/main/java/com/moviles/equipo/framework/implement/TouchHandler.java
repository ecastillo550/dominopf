package com.moviles.equipo.framework.implement;

import java.util.List;

import android.view.View.OnTouchListener;

import com.moviles.equipo.framework.Input.TouchEvent;

public interface TouchHandler extends OnTouchListener {
    public boolean isTouchDown(int pointer);
    
    public int getTouchX(int pointer);
    
    public int getTouchY(int pointer);
    
    public List<TouchEvent> getTouchEvents();
}