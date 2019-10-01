package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class HexTile extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    private float[] vertices;
    private int reference;
    float red = 0f;
    float blue = 0f;
    float green = 0f;
    //Pc player;
    float centerX;
    float centerY;
    Character character;
    int order;

    HexTile(float xCenter, float yCenter, int ref, int order) {//
        shapeRenderer = new ShapeRenderer();
        vertices = new float[12];
        tempSetVertices(xCenter, yCenter);
        reference = ref;
        centerX = xCenter;
        centerY = yCenter;
        character = new Npc();
        //player = null;
        order = order;
    }

    private void tempSetVertices(float xCenter, float yCenter){
        vertices[0] = xCenter - 50f;
        vertices[1] = yCenter;

        vertices[2] = xCenter - 25f;
        vertices[3] = yCenter - 50f;

        vertices[4] = xCenter + 25f;
        vertices[5] = yCenter - 50f;

        vertices[6] = xCenter + 50f;
        vertices[7] = yCenter;

        vertices[8] = xCenter + 25f;
        vertices[9] = yCenter + 50f;

        vertices[10] = xCenter - 25f;
        vertices[11] = yCenter + 50f;
    }

    private void setColors(){
        if(reference == 1){
            red = 1;
        }
        else if(reference == 2){
            blue = 1;
        }
        else{
            green = 1;
        }
    }

    public void drawHex(){
        setColors();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(red,green,blue,1);
        shapeRenderer.polygon(vertices);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        vertices = null;
    }


}
