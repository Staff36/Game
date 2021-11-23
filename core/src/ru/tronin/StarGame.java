package ru.tronin;

import com.badlogic.gdx.Game;

import ru.tronin.screen.impl.MenuScreen;


public class StarGame extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen());
	}
}
