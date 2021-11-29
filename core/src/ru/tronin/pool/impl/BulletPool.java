package ru.tronin.pool.impl;

import ru.tronin.pool.SpritesPool;
import ru.tronin.sprite.impl.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
