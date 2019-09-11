package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class HexTile extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    private float[] vertices;
    int refrence;
    float red = 0f;
    float blue = 0f;
    float green = 0f;

    HexTile(float xOff, float yOff, int ref) {
        shapeRenderer = new ShapeRenderer();
        vertices = new float[12];
        tempSetVertices(xOff, yOff);
        refrence = ref;

    }

    private void tempSetVertices(float xOff, float yOff){
        vertices[0] = 25f + xOff;
        vertices[1] = 0f + yOff;

        vertices[2] = 75f + xOff;
        vertices[3] = 0f + yOff;

        vertices[4] = 100f + xOff;
        vertices[5] = 50f + yOff;

        vertices[6] = 75f + xOff;
        vertices[7] = 100f + yOff;

        vertices[8] = 25f + xOff;
        vertices[9] = 100f + yOff;

        vertices[10] = 0f + xOff;
        vertices[11] = 50f + yOff;
    }

    private void setColors(){
        if(refrence == 1){
            red = 1;
        }
        else if(refrence == 2){
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
