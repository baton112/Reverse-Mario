package com.mygdx.game.mario.revrse.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.mario.revrse.MyGdxGame;
import com.mygdx.game.mario.revrse.assets.Assets;



public class GameScreen extends MyScreen {
	
	private ShapeRenderer myShapeRenderer;	
	private int x, y;

	public GameScreen(MyGdxGame myGdxGame) {
		this.game = myGdxGame;
		// TODO Auto-generated constructor stub
		myShapeRenderer = new ShapeRenderer();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Assets.batch.begin();
		//rysowanie wszystkiego 
		if(Gdx.input.isTouched())
		{
			x = Gdx.input.getX();
			y = (int) (MyGdxGame.getScreenHeight() - Gdx.input.getY());
			myShapeRenderer.begin(ShapeType.Filled);
			myShapeRenderer.setColor(Color.YELLOW);
			myShapeRenderer.circle(x, y, 50);
			myShapeRenderer.end();
		}
		
		
		Assets.batch.end();
	}



}
