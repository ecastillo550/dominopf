package com.moviles.equipo.dominopf;

/**
 * Created by ecast_000 on 07-Dec-14.
*/
import java.lang.reflect.*;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import com.moviles.equipo.framework.Game;
import com.moviles.equipo.framework.Graphics;
import com.moviles.equipo.framework.Input.TouchEvent;
import com.moviles.equipo.framework.Pixmap;
import com.moviles.equipo.framework.Screen;
import com.moviles.equipo.framework.implement.AndroidGame;

public class GameScreen extends Screen {
    enum GameState {
        Running,
        Paused,
        GameOver
    }


    GameState state = GameState.Running;
    int oldScore = 0;
    Tablero tablero;
    String score = "0";

    public GameScreen(Game game) {
        super(game);
        tablero = new Tablero();
    }

    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        if(state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if(state == GameState.Paused)
            updatePaused(touchEvents);
        if(state == GameState.GameOver)
            updateGameOver(touchEvents);
    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
        int len = touchEvents.size();
        boolean comidaexitosa;

        int duration = Toast.LENGTH_SHORT;
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x < 150 && event.y < 150) {
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    state = GameState.Paused;
                    return;
                }
                if (inBounds(event, 990 , 570, 230, 150)) {
                    comidaexitosa = tablero.jugador.comer(tablero.deckPosicion);
                    if (!comidaexitosa){

                    }
                    //if(Settings.soundEnabled)
                        Assets.click.play(1);
                }
            }
        }

        //world.update(deltaTime);
        if(tablero.gameOver) {
            if(Settings.soundEnabled)
                Assets.click.play(1);
            state = GameState.GameOver;
        }
    }

    private void updatePaused(List<TouchEvent> touchEvents) {
        game.setScreen(new MainMenuScreen(game));
        return;
    }

    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x >= 128 && event.x <= 192 &&
                        event.y >= 200 && event.y <= 264) {
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
            }
        }
    }


    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.backgroundGame, 0, 0);
        drawTablero(tablero);
        if(state == GameState.GameOver)
            drawGameOverUI();
    }

    private void drawTablero(Tablero tablero) {
        Graphics g = game.getGraphics();
        int x = 0 * 100;
        int y = 6 * 100;

        for(int i = 0; i <= tablero.jugador.cantidadfichas-1 ; i++) {
            g.drawPixmap(Assets.getPieza(tablero.deck.fichas[tablero.jugador.getMano()[i]].nombreArchivo), x, y, 90);
            x += 100;
        }



        //logica del dibujado tablero

//        int len = snake.parts.size();
//        for(int i = 1; i < len; i++) {
//            SnakePart part = snake.parts.get(i);
//            x = part.x * 32;
//            y = part.y * 32;
//            g.drawPixmap(Assets.tail, x, y);
//        }


    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}