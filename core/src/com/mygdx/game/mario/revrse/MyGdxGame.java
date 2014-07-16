package com.mygdx.game.mario.revrse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.mario.revrse.assets.Assets;
import com.mygdx.game.mario.revrse.screens.GameScreen;
import com.mygdx.game.mario.revrse.screens.MainMenuScreen;

public class MyGdxGame extends Game {
	
	private static float screenHeight;
	private static float screenWidth;
	private static float resolutionScaleX;
	private static float resolutionScaleY;
	
	@Override
	public void create() {
		Assets.load();
		
		setScreenWidth(Gdx.graphics.getWidth());
		setScreenHeight(Gdx.graphics.getHeight());
		
		//setScreen(new MainMenuScreen(this));
		setScreen(new GameScreen(this));
	}
	
	public void startGame() {

		this.getScreen().dispose();
		setScreen(new GameScreen(this));
		
	}

	public static float getScreenHeight() {
		return screenHeight;
	}
	

	public static void setScreenHeight(float screenHeight) {
		MyGdxGame.screenHeight = screenHeight;
	}

	public float getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(float screenWidth) {
		MyGdxGame.screenWidth = screenWidth;
	}
	
	
	
}
