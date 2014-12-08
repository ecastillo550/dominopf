package com.moviles.equipo.dominopf;

import com.moviles.equipo.framework.Game;
import com.moviles.equipo.framework.Graphics;
import com.moviles.equipo.framework.Input;
import com.moviles.equipo.framework.Screen;

import java.util.List;

/**
 * Created by ecast_000 on 08-Dec-14.
 */
public class CreditosScreen extends Screen {
    public CreditosScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        int len = touchEvents.size();



        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                if (inBounds(event, 0, 0, 1280, 720)) {
                    game.setScreen(new MainMenuScreen(game));
                    if (Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
            }
        }
    }

    private boolean inBounds(Input.TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.creditosback, 0, 0);
    }
    @Override
    public void pause() {
        //Settings.save(game.getFileIO());
    }

    @Override
    public void resume() {
    }
    @Override
    public void dispose() {
    }
}
