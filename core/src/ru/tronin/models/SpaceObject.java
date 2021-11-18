package ru.tronin.models;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class SpaceObject {

    private Vector2 coordinates;
    private TextureRegion region;

    public SpaceObject(Vector2 coordinates, TextureRegion textureRegion) {
        this.coordinates = coordinates;
        this.region = textureRegion;
    }

    public SpaceObject(float x, float y, TextureRegion textureRegion){
        this(new Vector2(x, y), textureRegion);
    }

    public Vector2 getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Vector2 coordinates) {
        this.coordinates = coordinates;
    }

    public TextureRegion getRegion() {
        return region;
    }

    public void setRegion(TextureRegion region) {
        this.region = region;
    }

}
