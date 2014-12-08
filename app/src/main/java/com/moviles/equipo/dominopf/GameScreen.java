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
    Graphics g = game.getGraphics();
    enum GameState {
        Running,
        Paused,
        GameOver
    }

    GameState state = GameState.Running;
    Tablero tablero;

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
                    comidaexitosa = tablero.comeJugador(tablero.jugador);
                    //if (!comidaexitosa){}
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                }

                for(int n = 0; n < 10; n++){
                    if (inBounds(event, n*100 , 600, 100, 100)) {
                        tablero.ponerFicha(tablero.jugador, n);
                        //if (!comidaexitosa){}
                        if(Settings.soundEnabled)
                            Assets.click.play(1);
                    }
                }

                if(event.x > 500 && event.y < 100) {
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    Assets.backgroundGame = g.newPixmap("_backback.png", Graphics.PixmapFormat.RGB565);
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
        drawMano(tablero);
        if(state == GameState.GameOver)
            drawGameOverUI();
    }

    private  void drawMano(Tablero tablero) {
        Graphics g = game.getGraphics();

        for(int i = 0; i < 10 ; i++) {
            if(tablero.jugador.getMano()[i] != -1)
            g.drawPixmap(Assets.getPieza(tablero.deck.fichas[tablero.jugador.getMano()[i]].nombreArchivo),
                    tablero.deck.fichas[tablero.jugador.getMano()[i]].getX()*100,
                    tablero.deck.fichas[tablero.jugador.getMano()[i]].getY()*100,
                    tablero.deck.fichas[tablero.jugador.getMano()[i]].getRotacion());
        }

        for(int i = 0; i < 10 ; i++) {
            if(tablero.oponente.getMano()[i] != -1)
                g.drawPixmap(Assets.getPieza("_back"),
                        tablero.deck.fichas[tablero.oponente.getMano()[i]].getX()*100,
                        tablero.deck.fichas[tablero.oponente.getMano()[i]].getY()*100,
                        tablero.deck.fichas[tablero.oponente.getMano()[i]].getRotacion());
        }

    }

    private void drawTablero(Tablero tablero) {
        Graphics g = game.getGraphics();

        for(int i = 0; i < tablero.posicionDeckEnJuego ; i++) {
            g.drawPixmap(Assets.getPieza(tablero.deck.fichas[tablero.deckEnJuego[i]].nombreArchivo),
                    tablero.deck.fichas[tablero.deckEnJuego[i]].getX()*100,
                    tablero.deck.fichas[tablero.deckEnJuego[i]].getY()*100,
                    tablero.deck.fichas[tablero.deckEnJuego[i]].getRotacion());
        }

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