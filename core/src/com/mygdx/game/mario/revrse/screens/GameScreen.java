package com.mygdx.game.mario.revrse.screens;

import java.awt.event.FocusEvent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.mario.revrse.MyGdxGame;
import com.mygdx.game.mario.revrse.assets.Assets;
import com.mygdx.game.mario.revrse.contorls.GameButtons;
import com.mygdx.game.mario.revrse.player.Player;



public class GameScreen extends MyScreen {
	
	private ShapeRenderer myShapeRenderer;	
	private int x, y;
	private Player player;
	private final Vector2 gravity;
	
	private World world; // swiat do fizyki /// box2d
	private OrthographicCamera camera;
	private Box2DDebugRenderer debugRenderer; // do wyswitlania tak na chwile 
	
	private final int  velocityIterations = 8, positionIterations = 3;
	
	//private final float pixelsToMeters 
	

	public GameScreen(MyGdxGame myGdxGame) {
		this.game = myGdxGame;
		// TODO Auto-generated constructor stub
		myShapeRenderer = new ShapeRenderer();
		player = new Player();
		gravity = new Vector2(0.0f, -9.81f);
		world = new World(gravity, true);
		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());  
		/// podzielic na skale zeby bylo wieksze 
		
		//definicja ciala 
		BodyDef playerDef = new BodyDef();
		playerDef.type = BodyType.DynamicBody;
		playerDef.position.set(0,1);
		
		PolygonShape kwadrat = new PolygonShape();
		kwadrat.setAsBox(10, 10);
		
		//fixture deinition 
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = kwadrat;
		fixtureDef.density = 10;
		fixtureDef.friction = 0.1f;
		fixtureDef.restitution = 0;//odbijanie 
		
		world.createBody(playerDef).createFixture(fixtureDef);
		
		kwadrat.dispose();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		debugRenderer.render(world, camera.combined);
		
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
		if(GameButtons.isTouched())
		{
			player.move(delta);
		}
		Assets.batch.begin();
		player.drow();
		GameButtons.draw();
		
		Assets.batch.end();
		
		
		
		world.step(delta, velocityIterations, positionIterations);
	}

	@Override 
	public void dispose() {
		world.dispose();
		debugRenderer.dispose();
	}

}
