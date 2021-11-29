package ru.tronin;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import ru.tronin.screen.impl.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create() {
		Music music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));
		music.play();
		setScreen(new MenuScreen(this));
	}
}
