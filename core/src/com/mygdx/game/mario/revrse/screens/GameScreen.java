package com.mygdx.game.mario.revrse.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.mario.revrse.MyGdxGame;
import com.mygdx.game.mario.revrse.assets.Assets;
import com.mygdx.game.mario.revrse.player.Player;



public class GameScreen extends MyScreen {
	
	private ShapeRenderer myShapeRenderer;	
	private int x, y;
	private Player player;

	public GameScreen(MyGdxGame myGdxGame) {
		this.game = myGdxGame;
		// TODO Auto-generated constructor stub
		myShapeRenderer = new ShapeRenderer();
		player = new Player();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//rysowanie wszystkiego 
		if(Gdx.input.isTouched())
		{
			x = Gdx.input.getX();
			y = (int) (MyGdxGame.getScreenHeight() - Gdx.input.getY());
			myShapeRenderer.begin(ShapeType.Filled);
			myShapeRenderer.setColor(Color.YELLOW);
			myShapeRenderer.circle(x, y, 50);
			myShapeRenderer.end();
			player.move(delta);
		}
		Assets.batch.begin();
		player.drow();
		
		Assets.batch.end();
	}



}
