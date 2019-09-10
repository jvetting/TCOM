package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class HexTile extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;
    private float[] vertices;

    HexTile() {
        create();
    }

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        vertices = new float[12];
        tempSetVertices();
    }

    private void tempSetVertices(){
        vertices[0] = 225f;
        vertices[1] = 200f;

        vertices[2] = 275f;
        vertices[3] = 200f;

        vertices[4] = 300f;
        vertices[5] = 250f;

        vertices[6] = 275f;
        vertices[7] = 300f;

        vertices[8] = 225f;
        vertices[9] = 300f;

        vertices[10] = 200f;
        vertices[11] = 250f;
    }

    public void drawHex(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1,1,1,1);
        shapeRenderer.polygon(vertices);
        shapeRenderer.end();
    }

    @Override
    public void render() {
        drawHex();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        vertices = null;
    }


}
