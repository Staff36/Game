package ru.tronin.sprite.impl;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.tronin.math.Rect;
import ru.tronin.pool.impl.ExplosionPool;
import ru.tronin.sprite.Ship;

public class RepairKit extends Ship {


    public RepairKit(ExplosionPool explosionPool,Rect worldBounds) {
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
        this.v = new Vector2();
        this.v0 = new Vector2(0, -0.05f);
        this.destroyed = true;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (getTop() > worldBounds.getTop()) {
            v.set(0, -0.4f);
        } else {
            v.set(v0);
        }
        if (getBottom() < worldBounds.getBottom()) {
            destroy();
        }
        if (isDestroyed()){
            pos.set(0,2f);
        }
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v1,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v1);
        setHeightProportion(height);
        this.hp = hp;
    }

    public boolean isBulletCollision(Bullet bullet) {
        return !(bullet.getRight() < getLeft()
                || bullet.getLeft() > getRight()
                || bullet.getBottom() > getTop()
                || bullet.getTop() < pos.y
        );
    }

    public void damage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            destroy();

        }
    }


    @Override
    protected void shoot() {

    }
}
