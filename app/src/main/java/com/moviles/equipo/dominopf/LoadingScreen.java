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
        Assets._00 = g.newPixmap("_00.png", PixmapFormat.ARGB4444);
        Assets._01 = g.newPixmap("_01.png", PixmapFormat.ARGB4444);
        Assets._02 = g.newPixmap("_02.png", PixmapFormat.ARGB4444);
        Assets._03 = g.newPixmap("_03.png", PixmapFormat.ARGB4444);
        Assets._11 = g.newPixmap("_11.png", PixmapFormat.ARGB4444);
        Assets._12 = g.newPixmap("_12.png", PixmapFormat.ARGB4444);
        Assets._13 = g.newPixmap("_13.png", PixmapFormat.ARGB4444);
        Assets._15 = g.newPixmap("_15.png", PixmapFormat.ARGB4444);
        Assets._22 = g.newPixmap("_22.png", PixmapFormat.ARGB4444);
        Assets._23 = g.newPixmap("_23.png", PixmapFormat.ARGB4444);
        Assets._24 = g.newPixmap("_24.png", PixmapFormat.ARGB4444);
        Assets._25 = g.newPixmap("_25.png", PixmapFormat.ARGB4444);
        Assets._33 = g.newPixmap("_33.png", PixmapFormat.ARGB4444);
        Assets._34 = g.newPixmap("_34.png", PixmapFormat.ARGB4444);
        Assets._35 = g.newPixmap("_35.png", PixmapFormat.ARGB4444);
        Assets._36 = g.newPixmap("_36.png", PixmapFormat.ARGB4444);
        Assets._40 = g.newPixmap("_40.png", PixmapFormat.ARGB4444);
        Assets._44 = g.newPixmap("_44.png", PixmapFormat.ARGB4444);
        Assets._45 = g.newPixmap("_45.png", PixmapFormat.ARGB4444);
        Assets._46 = g.newPixmap("_46.png", PixmapFormat.ARGB4444);
        Assets._50 = g.newPixmap("_50.png", PixmapFormat.ARGB4444);
        Assets._51 = g.newPixmap("_51.png", PixmapFormat.ARGB4444);
        Assets._55 = g.newPixmap("_55.png", PixmapFormat.ARGB4444);
        Assets._56 = g.newPixmap("_56.png", PixmapFormat.ARGB4444);
        Assets._60 = g.newPixmap("_60.png", PixmapFormat.ARGB4444);
        Assets._61 = g.newPixmap("_61.png", PixmapFormat.ARGB4444);
        Assets._62 = g.newPixmap("_62.png", PixmapFormat.ARGB4444);
        Assets._66 = g.newPixmap("_66.png", PixmapFormat.ARGB4444);

        //Assets.bitten = game.getAudio().newSound("bitten.ogg");
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
