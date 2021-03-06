package ru.tronin.sprite.impl;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.tronin.math.Rect;
import ru.tronin.sprite.Sprite;

public class GameOver extends Sprite {

    private static final float HEIGHT = 0.075f;

    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
    }
}
