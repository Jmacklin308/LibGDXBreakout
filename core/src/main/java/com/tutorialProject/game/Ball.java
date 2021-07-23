package com.tutorialProject.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import sun.tools.jconsole.JConsole;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;

    //our color pallet
    Color white = new Color().set(239,236,202,1);
    Color blue = new Color().set(169, 203, 183,1);
    Color green = new Color().set(247, 255, 88,1);
    Color orange = new Color().set(255, 147, 79,1);



    public Ball(int x, int y, int size, int xSpeed, int ySpeed)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }


    public void update()
    {
        x += xSpeed;
        y += ySpeed;
        if (x - size < 0)
        {
            xSpeed = -xSpeed;
        }
        if(x + size > Gdx.graphics.getWidth())
        {
            xSpeed = -xSpeed;
        }
        if (y - size < 0)
        {
            ySpeed = -ySpeed;
        }
        if (y + size > Gdx.graphics.getHeight())
        {
            ySpeed = -ySpeed;
        }
    }


    public void draw(ShapeRenderer shape)
    {
        shape.setColor(color);
        shape.circle(x, y, size);
    }


    public void checkCollision(Paddle paddle)
    {
        if (collidesWith(paddle))
        {
            color = Color.GREEN;
        }
        else
        {
            color = Color.WHITE;
        }
    }

    private boolean collidesWith(Paddle paddle)
    {
        return Math.random()>.5; // 50% chance
    }

}
