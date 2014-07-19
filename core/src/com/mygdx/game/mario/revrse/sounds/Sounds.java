package com.mygdx.game.mario.revrse.sounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Sounds {

	private static Music rainMusic;
	
	public static void load() {
		
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("data/rain.mp3"));
		
		rainMusic.setLooping(true);
		rainMusic.play();
	}

}
