package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.Random;//

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	float[] xOff;
	float[] yOff;
	HexTile[] hex;
	int r,g,b;
	//
	HexTile[][] hexMap;
	int tiles;
	//
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont();
		xOff = new float[12];
		yOff = new float[12];
		setOffsets();
		hex = new HexTile[12];
		//
		hexMap = new HexTile[5][5];//assuming the grid is 5x5
		genTiles();
		//


		//int i;
		//r = 1;
		//g = 0;
		//b = 0;
		//for (i = 0; i < hex.length; i++){
		//	hex[i] = new HexTile(xOff[i], yOff[i],1);
		//}
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
	//
	public void genTiles()
	{
		Random rand = new Random();
		int pos, color = 0;
		tiles = 0;
		while(tiles < 5)
		{
			pos = rand.nextInt(12);
			color = rand.nextInt(3);//color will be red, blue or green
			if(hexMap[(int)yOff[pos]][(int)xOff[pos]] != null)
			{
				hexMap[(int) yOff[pos]][(int) xOff[pos]] = new HexTile(xOff[pos], yOff[pos],color);
				tiles++;
			}
		}
	}
	//

	@Override
	public void render () {
		//r = 1, g = 0, b = 0
		Gdx.gl.glClearColor(r, g, b, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
			r = 0;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			g = 1;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			b = 1;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			r = 1;
			g = 0;
			b = 0;
		}
		batch.begin();
		//font.draw(batch, "Happy Coding", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		//batch.draw(img, 0, 0);
		batch.end();
		//for (int i = 0; i < hex.length; i++) {
		//	hex[i].drawHex();
		//}

		//
		for(int i = 0; i < 5; i++)//5 or dimensions
		{
			for(int j = 0; j < 5; j++)
			{
				hexMap[i][j].drawHex();
			}
		}
		//
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

		//
		//
		for(int i = 0; i < 5; i++)//5 or dimensions
		{
			for(int j = 0; j < 5; j++)
			{
				hexMap[i][j].dispose();
			}
		}
		//
		//
	}
}
