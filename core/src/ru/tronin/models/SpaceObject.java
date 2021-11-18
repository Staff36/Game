package ru.tronin.models;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpaceObject {
    private int x, y;
    private float rotation;
    private TextureRegion textureRegion;

    public SpaceObject(int x, int y, float rotation, TextureRegion textureRegion) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.textureRegion = textureRegion;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public TextureRegion getTextureRegion() {
        return textureRegion;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }
}
