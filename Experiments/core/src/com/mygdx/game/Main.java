package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	HexTile hex;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont();
		hex = new HexTile();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, "Happy Coding", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		batch.draw(img, 0, 0);
		batch.end();
		hex.drawHex();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		img.dispose();
		hex.dispose();
	}
}
