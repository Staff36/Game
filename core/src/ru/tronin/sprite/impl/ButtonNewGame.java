package ru.tronin.sprite.impl;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.tronin.math.Rect;
import ru.tronin.screen.BaseScreen;
import ru.tronin.screen.impl.GameScreen;
import ru.tronin.sprite.BaseButton;

public class ButtonNewGame extends BaseButton {

    private static final float HEIGHT = 0.065f;
    private static final float BOTTOM_MARGIN = 0.08f;
    private GameScreen screen;



    private Rect worldBounds;


    public ButtonNewGame(TextureAtlas atlas, GameScreen screen) {
        super(atlas.findRegion("button_new_game"));
        this.screen = screen;
    }

    @Override
    public void action() {
        screen.restartGame();
        screen.resize(worldBounds);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + BOTTOM_MARGIN);
    }

    public Rect getWorldBounds() {
        return worldBounds;
    }

    public void setWorldBounds(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

}
