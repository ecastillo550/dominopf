package com.moviles.equipo.dominopf;

/**
 * Created by ecast_000 on 07-Dec-14.
 */

import com.moviles.equipo.framework.Game;
import com.moviles.equipo.framework.Graphics;
import com.moviles.equipo.framework.Screen;
import com.moviles.equipo.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background.jpg", PixmapFormat.RGB565);
        Assets.backgroundGame = g.newPixmap("backgroundgame.jpg", PixmapFormat.RGB565);
        Assets.botonjugar = g.newPixmap("botonjugar.jpg", PixmapFormat.ARGB4444);
        Assets.creditos = g.newPixmap("creditos.jpg", PixmapFormat.ARGB4444);
        Assets._00 = g.newPixmap("_00.png", PixmapFormat.ARGB4444);
        Assets._01 = g.newPixmap("_01.png", PixmapFormat.ARGB4444);
        Assets._02 = g.newPixmap("_02.png", PixmapFormat.ARGB4444);
        Assets._03 = g.newPixmap("_03.png", PixmapFormat.ARGB4444);
        Assets._11 = g.newPixmap("_11.png", PixmapFormat.ARGB4444);
        Assets._12 = g.newPixmap("_12.png", PixmapFormat.ARGB4444);
        Assets._13 = g.newPixmap("_13.png", PixmapFormat.ARGB4444);
        Assets._14 = g.newPixmap("_14.png", PixmapFormat.ARGB4444);
        Assets._22 = g.newPixmap("_22.png", PixmapFormat.ARGB4444);
        Assets._23 = g.newPixmap("_23.png", PixmapFormat.ARGB4444);
        Assets._24 = g.newPixmap("_24.png", PixmapFormat.ARGB4444);
        Assets._25 = g.newPixmap("_25.png", PixmapFormat.ARGB4444);
        Assets._33 = g.newPixmap("_33.png", PixmapFormat.ARGB4444);
        Assets._34 = g.newPixmap("_34.png", PixmapFormat.ARGB4444);
        Assets._35 = g.newPixmap("_35.png", PixmapFormat.ARGB4444);
        Assets._36 = g.newPixmap("_36.png", PixmapFormat.ARGB4444);
        Assets._04 = g.newPixmap("_04.png", PixmapFormat.ARGB4444);
        Assets._44 = g.newPixmap("_44.png", PixmapFormat.ARGB4444);
        Assets._45 = g.newPixmap("_45.png", PixmapFormat.ARGB4444);
        Assets._46 = g.newPixmap("_46.png", PixmapFormat.ARGB4444);
        Assets._05 = g.newPixmap("_05.png", PixmapFormat.ARGB4444);
        Assets._15 = g.newPixmap("_15.png", PixmapFormat.ARGB4444);
        Assets._55 = g.newPixmap("_55.png", PixmapFormat.ARGB4444);
        Assets._56 = g.newPixmap("_56.png", PixmapFormat.ARGB4444);
        Assets._06 = g.newPixmap("_06.png", PixmapFormat.ARGB4444);
        Assets._16 = g.newPixmap("_16.png", PixmapFormat.ARGB4444);
        Assets._26 = g.newPixmap("_26.png", PixmapFormat.ARGB4444);
        Assets._66 = g.newPixmap("_66.png", PixmapFormat.ARGB4444);

        Assets.click = game.getAudio().newSound("click.mp3");
        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void present(float deltaTime) {
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
