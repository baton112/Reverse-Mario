package com.mygdx.game.mario.revrse.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.mario.revrse.contorls.GameButtons;

public class Player {
	//private Vector2 position; // 
	private int health ; // zycie 
	private boolean jump; // true jesli jest w podskoku
	private boolean left;
	
	//cialo definicja -- to co potrzeba do box2D
	private Body playerBody;
	
	private final static int spriteWidthSmall = 15;
	private final static int spriteHeightSmall = 15;
	private final static int center = 180;
	private final static int maxSpeed = 100;
			
	public Player(World world)
	{
		//position = new Vector2();
		health = 0;
		jump = false;
		left = true;
		
		//kwadrat 
		//definicja ciala 
		BodyDef playerDef = new BodyDef() ;
		playerDef.type = BodyType.DynamicBody;
		playerDef.position.set(0,10);
		
		//definicja ksztaltu i wielkosci
		PolygonShape squareShape = new PolygonShape();
		squareShape.setAsBox(1, 1); /// polowa wielkosci 
		
		//fixture deinition 
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = squareShape;
		fixtureDef.density = 10;
		fixtureDef.friction = 0.1f;
		fixtureDef.restitution = 0;//odbijanie
		
		playerBody = world.createBody(playerDef);
		playerBody.createFixture(fixtureDef);
		
		
		squareShape.dispose();
	}
	
	public void drow(World world)
	{
	
		//wybor tekstury z png z teksturami 
		//TextureRegion sprite = new TextureRegion(Assets.playerTexture,center,0 ,spriteWidthSmall, spriteHeightSmall );
		
		//rysowanie mario na jego pozycji 
		//Assets.batch.draw(sprite,position.x, position.y, 
			//	spriteWidthSmall*4*MyGdxGame.resolutionScaleX, spriteHeightSmall*4*MyGdxGame.resolutionScaleY);
		
	}
	
	public void bonusHealth()
	{
		if(health <= 2) health +=2;
	}
	
	public void loseHealts()
	{
		if(health >=2 ) health +=2;
		else die();
	}

	public void die()
	{
		//TO DO 
		//umieranie
		
	}
	
	public void move(float delta)
	{
		if(GameButtons.isTouched(true)) left = true;
		if(GameButtons.isTouched(false)) left = false;
		if(left)
		{
			//position.x -= maxSpeed*delta;
		}
		else 
		{
			//position.x += maxSpeed*delta;
		}
	}
	
	public Vector2 getPosition()
	{
		Gdx.app.log("poz", playerBody.getPosition().toString());
		return playerBody.getPosition();
		
	}
	

}
