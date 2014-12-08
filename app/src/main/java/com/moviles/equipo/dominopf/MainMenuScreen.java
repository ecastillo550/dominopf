package com.moviles.equipo.dominopf;

/**
 * Created by ecast_000 on 07-Dec-14.
 */
import android.widget.Toast;

import java.util.List;
import com.moviles.equipo.framework.Game;
import com.moviles.equipo.framework.Graphics;
import com.moviles.equipo.framework.Input.TouchEvent;
import com.moviles.equipo.framework.Screen;

public class MainMenuScreen extends Screen {
    public MainMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        int len = touchEvents.size();



        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (inBounds(event, g.getWidth()/3, g.getHeight()/3-150, 425, 280)) {
                    game.setScreen(new GameScreen(game));
                    if (Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
                if (inBounds(event, g.getWidth()/3, (g.getHeight()/3-150)+280, 380, 240)) {
                    game.setScreen(new CreditosScreen(game));
                    if (Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }

//                if (inBounds(event, 64, 220 + 84, 192, 42)) {
                //Settings.soundEnabled = !Settings.soundEnabled;
                //if (Settings.soundEnabled)
//                    game.setScreen(new HelpScreen(game));
//                    if (Settings.soundEnabled)
//                        Assets.click.play(1);
//                    return;
//                }
            }
        }
    }

    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.botonjugar,  g.getWidth()/3, (g.getHeight()/3-150));
        g.drawPixmap(Assets.creditos, g.getWidth()/3, (g.getHeight()/3-150) + 280);
//        if(Settings.soundEnabled)
//            g.drawPixmap(Assets.buttons, 0, 416, 0, 0, 64, 64);
//        else
//            g.drawPixmap(Assets.buttons, 0, 416, 64, 0, 64, 64);
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