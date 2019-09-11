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
	float[] xOff;
	float[] yOff;
	HexTile[] hex;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont();
		xOff = new float[12];
		yOff = new float[12];
		setOffsets();
		hex = new HexTile[12];
		int i;
		for (i = 0; i < hex.length; i++){
			hex[i] = new HexTile(xOff[i], yOff[i]);
		}
	}

	private void setOffsets(){
		xOff[0] = 0f;
		yOff[0] = 0f;
		xOff[1] = 100f;
		yOff[1] = 0f;
		xOff[2] = 200f;
		yOff[2] = 0f;
		xOff[3] = 300f;
		yOff[3] = 0f;
		xOff[4] = 400f;
		yOff[4] = 0f;
		xOff[5] = 0f;
		yOff[5] = 100f;
		xOff[6] = 100f;
		yOff[6] = 100f;
		xOff[7] = 200f;
		yOff[7] = 100f;
		xOff[8] = 300f;
		yOff[8] = 100f;
		xOff[9] = 400f;
		yOff[9] = 100f;
		xOff[10] = 0f;
		yOff[10] = 200f;
		xOff[11] = 100f;
		yOff[11] = 200f;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//font.draw(batch, "Happy Coding", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		//batch.draw(img, 0, 0);
		batch.end();
		for (int i = 0; i < hex.length; i++) {
			hex[i].drawHex();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		img.dispose();
		for (int i = 0; i < hex.length; i++){
			hex[i].dispose();
		}
		xOff = null;
		yOff = null;
	}
}
