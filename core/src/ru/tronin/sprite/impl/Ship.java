package ru.tronin.sprite.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.tronin.math.Rect;
import ru.tronin.sprite.Sprite;

public class Ship extends Sprite {

    private Vector2 movement;
    private float heightPos = 0;
    private Rect worldBounds;

    public Ship(Texture texture) {
        super(new TextureRegion(texture));
        movement = new Vector2();
        worldBounds = new Rect();

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight() * 0.2f);
        this.pos.set(worldBounds.pos);
        heightPos = worldBounds.getBottom() + 0.15f ;
        this.worldBounds = worldBounds;
    }

    public void setNewMovementVector(Vector2 touch, float vLen){
        Vector2 vector2 = touch.cpy();
        vector2.y = heightPos;
        vector2.sub(pos).setLength(vLen);
        movement.set(vector2);
    }

    protected void move(Vector2 touchPos){
        pos.y = heightPos;
        if (Math.abs(touchPos.x - pos.x) > movement.len()){
            this.pos.add(movement);
        }
        if (this.getRight() >= worldBounds.getRight()){
            pos.x = worldBounds.getRight() - this.getHalfWidth();
        }
        if (this.getLeft() <= worldBounds.getLeft()){
            pos.x = worldBounds.getLeft() + this.getHalfWidth();
        }
    }

    public void draw(SpriteBatch batch, Vector2 touchPos) {
        move(touchPos);
        super.draw(batch);
    }
}
