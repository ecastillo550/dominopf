package com.moviles.equipo.dominopf;

import com.moviles.equipo.framework.Screen;
import com.moviles.equipo.framework.implement.AndroidGame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class DominoGame extends AndroidGame {
    @Override
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
}
