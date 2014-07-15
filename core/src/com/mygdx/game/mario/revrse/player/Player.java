package com.mygdx.game.mario.revrse.player;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.mario.revrse.assets.Assets;

public class Player {
	private Vector2 position; // lewy dolny rog jego pozycji 
	private int health ; // zycie 
	private boolean jump; // true jesli jest w podskoku
	private boolean left;
	
	private final static int spriteWidthSmall = 15;
	private final static int spriteHeightSmall = 15;
	private final static int center = 180;
	private final static int maxSpeed = 10;
			
	public Player()
	{
		position = new Vector2(100, 100);
		health = 0;
		jump = false;
		left = true;
	}
	
	public void drow()
	{
		//wybor tekstury z png z teksturami 
		TextureRegion sprite = new TextureRegion(Assets.playerTexture,center,0 ,spriteWidthSmall, spriteHeightSmall );
		
		//rysowanie mario na jego pozycji 
		Assets.batch.draw(sprite,position.x, position.y, spriteWidthSmall*4, spriteHeightSmall*4);
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
		if(left)
		{
			position.x -= maxSpeed*delta;
		}
		else 
		{
			position.x += maxSpeed*delta;
		}
	}

}
