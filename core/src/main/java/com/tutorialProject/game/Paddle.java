package com.tutorialProject.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y;
    int paddleWidth;

    public Paddle(int x, int y, int paddleWidth )
    {
        this.x = x; // set x to whatever is passed in
        this.y = y; // set y to whatever is passed in
        this.paddleWidth = paddleWidth;
    }

    public void update()
    {

        x = Gdx.input.getX() - (paddleWidth / 2); // get mouse X
        if ((x + (paddleWidth / 2 )) >= Gdx.graphics.getWidth())
        {
            x = Gdx.graphics.getWidth() - paddleWidth / 2;
        }
    }

    public void draw(ShapeRenderer shape)
    {
        shape.rect(x,y,paddleWidth,15);
        shape.setColor(Color.WHITE);
    }





}
