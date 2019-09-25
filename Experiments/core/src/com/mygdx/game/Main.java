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

	boolean renderInfo = false;
	boolean renderMainMenu = false;

	int numCol;
	int colSize;

	//Menu menu;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont();
		numCol = 19;
		colSize = 1;
		int temp = 0;
		int t;
		for (t = 0; t <= numCol/2; t++){
			temp += (colSize+t)*2;
		}
		if (numCol%2 != 0){
			temp += colSize+t;
		}
		System.out.print(temp);
		hex = new HexTile[temp];
		Random rand = new Random();
		r = 1;
		g = 0;
		b = 0;

		int currentCol = 0;
		int colDist = 0;
		float colOffset = 525f;
		for (int j = 0; j < hex.length; j++){
			float tempX;
			float tempY;
			tempX = 150f + 75 * (currentCol);
			tempY = colOffset + 100 * (colDist);
			hex[j] = new HexTile(tempX,tempY, 2, j);

			colDist++;
			if (colDist >= colSize) {
				currentCol++;
				if (currentCol >= numCol) {
					break;
				}
				if (currentCol > numCol / 2) {
					colSize -= 1;
					colOffset += 50;
				} else {
					colSize += 1;
					colOffset -= 50;
				}
				colDist = 0;
			}
		}
		hex[50].addNpc();
	}

	@Override
	public void render () {
		//r = 1, g = 0, b = 0
		Gdx.gl.glClearColor(r, g, b, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		/*if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) && !renderMainMenu) {
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
		}*/
		//batch.begin();
		//font.draw(batch, Gdx.graphics.getWidth() + "  " + Gdx.graphics.getHeight(), Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
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
		int i;//i keeps track of the order of the hexes, essentially showing the 2D array itself
		for (i = 0; i < hex.length; i++) {
			if (hex[i] == null){
				continue;
			}
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
