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
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
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
	
	private final float pixelsToMeters = 20;
	

	public GameScreen(MyGdxGame myGdxGame) {
		this.game = myGdxGame;
		camera = new OrthographicCamera(Gdx.graphics.getWidth() / pixelsToMeters , 
										Gdx.graphics.getHeight() /pixelsToMeters );  
		gravity = new Vector2(0.0f, -9.81f);
		world = new World(gravity, true);
		debugRenderer = new Box2DDebugRenderer();
		
		
		myShapeRenderer = new ShapeRenderer(); // takie gowno tylko na chwile 
		player = new Player(world);
		
		
		
		//GROUND 
		//body def 
		BodyDef groundDef = new BodyDef();
		groundDef.type = BodyType.StaticBody;
		groundDef.position.set(0,0);
		
		//ground shape 
		ChainShape groundShape = new ChainShape();
		groundShape.createChain(new Vector2[]{new Vector2(-500, 0), new Vector2(500, 0)});
		
		//fixture definition 
		FixtureDef fixtureDefGround = new FixtureDef();
		fixtureDefGround.shape = groundShape;
		fixtureDefGround.friction = 0.5f;
		fixtureDefGround.restitution = 0;//odbijanie 
		
		world.createBody(groundDef).createFixture(fixtureDefGround);
		
		groundShape.dispose();
		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
				
		//przyciski
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
		
		//update swiata 
		world.step(delta, velocityIterations, positionIterations);
		//update kamery 
		camera.position.set(player.getPosition().x, player.getPosition().y , 0);
		camera.update();
		
		//rysowanie 
		Assets.batch.begin();
		player.drow(world);
		GameButtons.draw();
		
		Assets.batch.end();
		
		
		debugRenderer.render(world, camera.combined);
		
	}

	@Override 
	public void dispose() {
		world.dispose();
		debugRenderer.dispose();
	
	}

}
