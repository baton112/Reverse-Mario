package com.mygdx.game.mario.revrse.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.mario.revrse.MyGdxGame;
import com.mygdx.game.mario.revrse.assets.Assets;
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
	private static float width = 1, height = 1;
			
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
		squareShape.setAsBox(width/2, height/2); /// polowa wielkosci 
		
		//fixture deinition 
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = squareShape;
		fixtureDef.density = 0; // wplywa na sile potrzebna do podskakiwania 
		fixtureDef.friction = 0.1f;
		fixtureDef.restitution = 0;//odbijanie
		
		playerBody = world.createBody(playerDef);
		playerBody.createFixture(fixtureDef);
		
		TextureRegion sprite = new TextureRegion(Assets.playerTexture,center,0 ,spriteWidthSmall, spriteHeightSmall );
		Sprite tmpSprite = new Sprite(sprite);
		tmpSprite.setSize(width, height);
		playerBody.setUserData(tmpSprite);
		
		
		squareShape.dispose();
	}
	
	public void drow()
	{
	
		//wybor tekstury z png z teksturami 
		//TextureRegion sprite = new TextureRegion(Assets.playerTexture,center,0 ,spriteWidthSmall, spriteHeightSmall );
		
		//rysowanie mario na jego pozycji 
		//Assets.batch.draw(sprite,playerBody.getPosition().x, playerBody.getPosition().y, 
		//		spriteWidthSmall*4*MyGdxGame.resolutionScaleX, spriteHeightSmall*4*MyGdxGame.resolutionScaleY);
		
		if(playerBody.getUserData() instanceof Sprite)
		{
			Sprite sprite = (Sprite) playerBody.getUserData();
			sprite.setPosition(playerBody.getPosition().x - sprite.getWidth()/2, playerBody.getPosition().y - sprite.getHeight()/2 );
			sprite.setRotation(playerBody.getAngle() * MathUtils.radiansToDegrees); // ustawiam angle bo czemu nie :D 
			sprite.setSize(width, height);
			sprite.setOrigin(sprite.getWidth()/2 , sprite.getHeight()/2);
			sprite.draw(Assets.batch);
			//Gdx.app.log("player rys", "narysowano mario");
		}
		
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
			playerBody.applyForceToCenter(0, 100, true);
		}
		else 
		{
			playerBody.applyForceToCenter(0, -100, true);
			//position.x += maxSpeed*delta;
		}
	}
	
	public Vector2 getPosition()
	{
		//Gdx.app.log("poz", playerBody.getPosition().toString());
		return playerBody.getPosition();
		
	}
	

}
