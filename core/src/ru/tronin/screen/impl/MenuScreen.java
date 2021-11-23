package ru.tronin.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.tronin.models.SpaceObject;
import ru.tronin.screen.BaseScreen;

public class MenuScreen extends BaseScreen {

    protected Texture background;
    protected Texture spaceManAndRocket;
    protected SpaceObject spaceMan;
    protected Vector2 touchVector;

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this);
        spaceManAndRocket = new Texture("austronaut.png");
        background = new Texture("bck.jpeg");
        spaceMan = new SpaceObject(new Vector2(0, 0), new TextureRegion(spaceManAndRocket, 10, 0, 460, 700));
        touchVector = new Vector2(0, 0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        moveSpaceObjectToCoordinates(spaceMan, touchVector, 3f);
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(spaceMan.getRegion(), spaceMan.getCoordinates().x, spaceMan.getCoordinates().y, 100, 150);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        background.dispose();
        spaceManAndRocket.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touchVector.x = screenX;
        touchVector.y = Gdx.graphics.getHeight() - screenY;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        touchVector.x = screenX;
        touchVector.y = Gdx.graphics.getHeight() - screenY;
        return false;
    }

    private void moveSpaceObjectToCoordinates(SpaceObject spaceObject, Vector2 target, float speed) {
        Vector2 currentCoordinates = spaceObject.getCoordinates();
        Vector2 vector = target.cpy().sub(currentCoordinates);
        if (vector.len() < 1.415f){
            return;
        }
        vector = vector.nor().scl(speed);
        currentCoordinates.add(vector);
    }
}
