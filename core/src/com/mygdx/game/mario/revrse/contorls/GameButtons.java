package com.mygdx.game.mario.revrse.contorls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.mario.revrse.MyGdxGame;
import com.mygdx.game.mario.revrse.assets.Assets;

public class GameButtons {
	
	private static int buttonSize = 60;
	
	public static void draw()
	{
		TextureRegion sprite = new TextureRegion(Assets.arrows,0,0 ,buttonSize, buttonSize );
		Assets.batch.draw(sprite, 0, 0);
		sprite = new TextureRegion(Assets.arrows,buttonSize, 0 ,buttonSize, buttonSize );
		Assets.batch.draw(sprite, buttonSize, 0);

		
	}
	
	public static boolean isTouched()
	{
		return isTouched(false) || isTouched(true);
	}
	
	public  static boolean isTouched( boolean left)
	{
		for (int i = 0; i < 2; i++) { // 20 is max number of touch points
			   if (Gdx.input.isTouched(i)) 
			   {
			      final int iX = Gdx.input.getX(i);
			      final int iY = Gdx.input.getY(i);
			      
			      if(left)
			      {
						if(iX > 0 && iX < buttonSize 
								&& iY < MyGdxGame.getScreenHeight() 
								&& iY > MyGdxGame.getScreenHeight()-buttonSize )
						{
							return true;
						}
			      }else 
			      {
			    	  if(iX > buttonSize  && iX < 2*buttonSize 
								&& iY < MyGdxGame.getScreenHeight() 
								&& iY > MyGdxGame.getScreenHeight()-buttonSize )
						{
							return true;
						}
			      }
			   }
		}
		return false;
	}

}