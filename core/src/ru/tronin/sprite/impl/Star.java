package ru.tronin.sprite.impl;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import ru.tronin.math.Rect;
import ru.tronin.sprite.Sprite;


public class Star extends Sprite {

    private Rect worldBounds;
    private final Vector2 v;

    public Star(TextureAtlas atlas) {
        super(atlas.findRegion("star"));
        float x = MathUtils.random(-0.0005f, 0.0005f);
        float y = MathUtils.random(-0.05f, -0.001f);
        this.v = new Vector2(x, y);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(0.3f * v.y);
        float x = MathUtils.random(worldBounds.getLeft(), worldBounds.getRight());
        float y = MathUtils.random(worldBounds.getBottom(), worldBounds.getTop());
        this.pos.set(x, y);
    }

    @Override
    public void update(float delta) {
        this.pos.mulAdd(v, delta);
        checkBounds();
    }

    private void checkBounds() {
        if (getRight() < worldBounds.getLeft()) {
            setLeft(worldBounds.getRight());
        }
        if (getLeft() > worldBounds.getRight()) {
            setRight(worldBounds.getLeft());
        }
        if (getTop() < worldBounds.getBottom()) {
            setBottom(worldBounds.getTop());
        }
    }
}
