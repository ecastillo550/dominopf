package com.moviles.equipo.dominopf;

/**
 * Created by ecast_000 on 07-Dec-14.
 */
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
                if (inBounds(event, 0, 0, 1280, 700)) {
                    //Settings.soundEnabled = !Settings.soundEnabled;
                    //if (Settings.soundEnabled)
                        Assets.click.play(1);
                }
//                if (inBounds(event, 64, 220, 192, 42)) {
//                    game.setScreen(new GameScreen(game));
//                    if (Settings.soundEnabled)
//                        Assets.click.play(1);
//                    return;
//                }

//                if (inBounds(event, 64, 220 + 84, 192, 42)) {
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
        //g.drawRect(0, g.getHeight() - 200, 200, 200, android.R.color.white);
        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.botonjugar, 150, 150, 100, 100, 800, 400);
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