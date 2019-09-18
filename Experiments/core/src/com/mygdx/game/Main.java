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
	HexTile[][] hexMap;
	boolean renderInfo = false;
	boolean renderMainMenu = false;
	float[][] hexData;

	//Menu menu;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont();
		xOff = new float[12];
		yOff = new float[12];
		setOffsets();
		hex = new HexTile[10];
		hexMap = new HexTile[4][5];//assuming the grid is 4x5
		hexData = new float[100][2];

		int i;
		r = 1;
		g = 0;
		b = 0;


		for (int j = 0; j < 10; j++){
			if (j%2 == 0){
				hexData[j][0] = 300f + 100 * (j%10)/2;
				hexData[j][1] = 300f + 100 * (j/10);
			}
			else {
				hexData[j][0] = 350f + 100 * (j%10)/2;
				hexData[j][0] = 250f + 100 * (j/10);
			}
		}

		for (i = 0; i < hex.length; i++){//for now, the 1D array will be created before the 2D array
			hex[i] = new HexTile(hexData[i][0], hexData[i][1],2, i);
		}

		i = 0;
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

	public void genTiles()//to be used to create 2D array independent of 1D array. also gives each hex a random color
	{
		Random rand = new Random();
		int i = 0;
		int color = 0;
		for(int y = 0; y < 4 && i < 12; y++)
		{
			for(int x = 0; x < 5 && i < 12; x++)
			{
				color = rand.nextInt(3);//color will be red, blue or green
				hexMap[y][x] = new HexTile(xOff[i], yOff[i], color, i);
				i++;
			}
		}
	}


	@Override
	public void render () {
		//r = 1, g = 0, b = 0
		Gdx.gl.glClearColor(r, g, b, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) && !renderMainMenu) {
			renderMainMenu = true;
		}
		else if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			renderMainMenu = false;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.I) && !renderInfo)
		{
			renderInfo = true;
		}
		else if(Gdx.input.isKeyJustPressed(Input.Keys.I))
		{
			renderInfo = false;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
			r = 0;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
			g = 1;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			b = 1;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			r = 1;
			g = 0;
			b = 0;
		}
		//batch.begin();
		//font.draw(batch, "Happy Coding", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		//batch.draw(img, 0, 0);
		//batch.end();

		/**this was commented out so that the 2D array is being printed by itself
		for (int i = 0; i < hex.length; i++) {
			hex[i].drawHex();
		}
		batch.begin();
		//menu.drawMenu();//to be implemented when menu is working
		//if(Gdx.input.isKeyJustPressed(Input.Keys.I)) {
			for (int i = 0; i < hex.length; i++) {
				//hex[i].drawHex();
				//
				//batch.begin();
				font.draw(batch, hex[i].character.name, hex[i].centerX, hex[i].centerY);
				font.draw(batch, hex[i].character.bio, hex[i].centerX, hex[i].centerY-15);
				//batch.draw(img, 0, 0);
				//batch.end();
				//
			}


		//}
		batch.end();
		 **/

		if(renderMainMenu)
		{
			displayStartMenu();
		}
		else
		{
			displayHexes();
		}
	}

	private void displayStartMenu()
	{
		//going to create a custom font for the title screen in Century Gothic
		//BitmapFont.TextBounds bounds;//text bounds being buggy will fix later
		batch.begin();
		String title = "TCOM";
		//bounds = font.getBounds(title);
		//font.draw(batch, title, Gdx.graphics.getWidth()/2 - bounds.width/2, Gdx.graphics.getHeight()/2 + bounds.height/2);//places title in center of screen
		font.draw(batch, title, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		//batch.draw(img, 0, 0);
		batch.end();
	}

	private void displayHexes()
	{
		int i = 0;//i keeps track of the order of the hexes, essentially showing the 2D array itself
		for (i = 0; i < hex.length; i++) {
			hex[i].drawHex();
			batch.begin();
			if (renderInfo) {
				//font.draw(batch, hex[i].character.name, hex[i].centerX, hex[i].centerY);
				//font.draw(batch, hex[i].character.bio, hex[i].centerX, hex[i].centerY - 15);
				//show that the order of hexes is correct by printing currentHex.order "==" i
				//font.draw(batch, Integer.toString(hex[i].order), hex[i].centerX, hex[i].centerY - 30);
				//font.draw(batch, " == ", hex[i].centerX + 15, hex[i].centerY - 30);
				//font.draw(batch, Integer.toString(i), hex[i].centerX + 40, hex[i].centerY - 30)
			}
			batch.end();
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

		/**
		for (int y = 0; y < 12; y++)
		{
			for(int x = 0; x < 12; x++)
			{
				hexMap[y][x].dispose();
			}
		}
		**/
	}
}
