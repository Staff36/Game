package ru.tronin.screen.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.tronin.math.Rect;
import ru.tronin.screen.BaseScreen;
import ru.tronin.sprite.impl.Background;
import ru.tronin.sprite.impl.Ship;


public class MenuScreen extends BaseScreen {

    public final float V_LEN = 0.01f;
    private Texture img;
    private Texture bg;
    private Vector2 touchPos;

    private Background background;
    private Ship ship;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        img = new Texture("textures/ship.png");
        touchPos = new Vector2();
        background = new Background(bg);
        ship = new Ship(img);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        ship.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        ship.draw(batch, touchPos);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        bg.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        touchPos.set(touch);
        ship.setNewMovementVector(touch,V_LEN);
        return super.touchDown(touch, pointer, button);
    }
}
