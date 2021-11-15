package ru.tronin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.tronin.models.SpaceObject;
import sun.jvm.hotspot.gc.shared.Space;

public class MyGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Texture spaceManAndRocket;
    SpaceObject spaceMan;
    SpaceObject spaceRocket;

    @Override
    public void create() {
        spaceManAndRocket = new Texture("austronaut.png");
        spaceMan = new SpaceObject(-500,1100, 50, new TextureRegion(spaceManAndRocket, 0, 0, 460, 700));
        spaceRocket = new SpaceObject(1000, 1100,50,new TextureRegion(spaceManAndRocket, 460, 0, 400, 700));
        batch = new SpriteBatch();
        img = new Texture("bck.jpeg");
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(
                spaceMan.getTextureRegion(),
                spaceMan.getX(),
                spaceMan.getY(),
                150,
                170,
                150,
                170,
                1,
                1,
                spaceMan.getRotation()
        );
        batch.draw(spaceRocket.getTextureRegion(),
                spaceRocket.getX(),
                spaceRocket.getY(),
                150,
                200,
                150,
                200,
                1,
                1,
                spaceRocket.getRotation()
        );
        batch.end();
        spaceMan.setRotation(spaceMan.getRotation() + 1);
        spaceMan.setX(spaceMan.getX() + 1);
        spaceMan.setY(spaceMan.getY() - 2);
        spaceRocket.setRotation(spaceRocket.getRotation() - 1);
        spaceRocket.setX(spaceRocket.getX() - 1);
        spaceRocket.setY(spaceRocket.getY() - 1);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }


}
