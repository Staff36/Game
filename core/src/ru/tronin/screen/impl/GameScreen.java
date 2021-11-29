package ru.tronin.screen.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.tronin.math.Key;
import ru.tronin.math.Rect;
import ru.tronin.screen.BaseScreen;
import ru.tronin.sprite.impl.Background;
import ru.tronin.sprite.impl.Ship;
import ru.tronin.sprite.impl.Star;


public class GameScreen extends BaseScreen {
    public final float V_LEN = 0.01f;
    private static final int STAR_COUNT = 256;
    private Texture bg;
    private Background background;
    private Star[] stars;
    private TextureAtlas atlas;
    private Ship ship;
    private Texture shipTexture;
    private Vector2 touchPos;
    private Key key;
    Rect worldBounds;

    @Override
    public void show() {
        super.show();
        shipTexture = new Texture("textures/ship.png");
        atlas = new TextureAtlas("textures/menuAtlas.tpack");
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
        ship = new Ship(shipTexture);
        touchPos = new Vector2();
        key = new Key();
        worldBounds = new Rect();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        ship.resize(worldBounds);
        this.worldBounds = worldBounds;
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();
        shipTexture.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        touchPos.set(touch);
        ship.setNewMovementVector(touch,V_LEN);
        return super.touchUp(touch, pointer, button);
    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        ship.draw(batch, touchPos);

        moveShip();
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        key.pressKey(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        key.releaseKey();
        return false;
    }

    private void moveShip() {
        if (key.isPressed()) {
            if (key.getCode() == 21) {
                touchPos.x = touchPos.x - V_LEN;
            }
            if (key.getCode() == 22) {
                touchPos.x = touchPos.x + V_LEN;
            }
            validateTouchPosition();
            ship.setNewMovementVector(touchPos, V_LEN);
        }
    }

    private void validateTouchPosition(){
        if (touchPos.x >= worldBounds.getRight()){
            touchPos.x = worldBounds.getRight();
        }
        if (touchPos.x <= worldBounds.getLeft()){
            touchPos.x = worldBounds.getLeft();
        }
        if (touchPos.y >= worldBounds.getTop()){
            touchPos.y = worldBounds.getTop();
        }
        if (touchPos.y <= worldBounds.getBottom()){
            touchPos.y= worldBounds.getBottom();
        }
    }
}
