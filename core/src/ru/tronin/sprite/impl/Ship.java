package ru.tronin.sprite.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.tronin.math.Rect;
import ru.tronin.sprite.Sprite;

public class Ship extends Sprite {

    private Vector2 movement;

    public Ship(Texture texture) {
        super(new TextureRegion(texture));
        movement = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight() * 0.2f);
        this.pos.set(worldBounds.pos);

    }

    public void setNewMovementVector(Vector2 touch, float vLen){
        movement.set(touch.cpy().sub(pos).setLength(vLen));
    }



    protected void move(Vector2 touchPos){
        if (this.pos.dst(touchPos) > movement.len()){
            this.pos.add(movement);
        }
    }


    public void draw(SpriteBatch batch, Vector2 touchPos) {
        move(touchPos);
        super.draw(batch);
    }
}
