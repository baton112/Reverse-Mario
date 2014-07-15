package com.mygdx.game.mario.revrse.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.mario.revrse.MyGdxGame;

public class MainMenuScreen extends MyScreen {
	

	public MainMenuScreen(MyGdxGame myGdxGame) {
		this.game = myGdxGame;
		// TODO Auto-generated constructor stub
	}


	@Override
	public void create () {
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//rysowanie 
	}
	

}
