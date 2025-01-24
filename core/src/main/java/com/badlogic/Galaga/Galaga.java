package com.badlogic.Galaga;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Galaga extends Game {
    public SpriteBatch batch;
    public Texture background;
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    public FitViewport viewport;
    public BitmapFont welcomeFont;
    public BitmapFont pressFont;
    public BitmapFont startFont;
    public BitmapFont gameOverFont;
    public BitmapFont tryAgainFont;
    FreeTypeFontGenerator generatorTwo;
    FreeTypeFontGenerator.FreeTypeFontParameter parameterTwo;
    /*public Texture star;
    public Array<Sprite> starArray;*/

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("blackBackground.png");
        generator = new FreeTypeFontGenerator(Gdx.files.internal("ARCADECLASSIC.TTF"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 12;
        welcomeFont = generator.generateFont(parameter);
        pressFont = generator.generateFont(parameter);
        gameOverFont = generator.generateFont(parameter);
        tryAgainFont = generator.generateFont(parameter);
        viewport = new FitViewport(7.2f,12.8f);

        welcomeFont.setUseIntegerPositions(false);
        welcomeFont.getData().setScale(2*(viewport.getWorldHeight()/Gdx.graphics.getHeight()));
        welcomeFont.setColor(Color.RED);
        pressFont.setUseIntegerPositions(false);
        pressFont.getData().setScale(viewport.getWorldHeight()/Gdx.graphics.getHeight());
        gameOverFont.setUseIntegerPositions(false);
        tryAgainFont.setUseIntegerPositions(false);
        gameOverFont.getData().setScale(3*(viewport.getWorldHeight()/Gdx.graphics.getHeight()));
        tryAgainFont.getData().setScale(2*(viewport.getWorldWidth()/Gdx.graphics.getHeight()));

        generatorTwo = new FreeTypeFontGenerator(Gdx.files.internal("ARCADECLASSIC.TTF"));
        parameterTwo = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 12;
        startFont = generator.generateFont(parameter);
        startFont.setUseIntegerPositions(false);
        startFont.getData().setScale(2f*(viewport.getWorldHeight()/Gdx.graphics.getHeight()));
        startFont.getData().markupEnabled = true;
        gameOverFont.getData().markupEnabled = true;
        /*star = new Texture(Gdx.files.internal("star.png"));
        starArray = new Array<>();*/

        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        generator.dispose();
    }
}
