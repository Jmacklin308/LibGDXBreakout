package com.tutorialProject.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.Random;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class TutorialProject extends ApplicationAdapter {
    //create our shape
    ShapeRenderer shape;

    int ballSpeedX = 3;
    int ballSpeedY = 3;
    int ballSize = 3;

    //Ball list
    int maxBalls = 3;
    int maxBallSize = 5;
    ArrayList<Ball> balls = new ArrayList<>();
    Random r = new Random();


    //Paddle
    Paddle paddle;


    @Override
    public void create ()
    {
        //allows us to render
        shape = new ShapeRenderer();

        //create some balls
        for (int i = 0; i < maxBalls; i++)
        {
            balls.add(new Ball(
                    r.nextInt(Gdx.graphics.getWidth()), //x
                    r.nextInt(Gdx.graphics.getHeight()), //y
                    r.nextInt(maxBallSize), //size
                    r.nextInt(6), //xspeed
                    r.nextInt(6) //yspeed
            ));
        }

        //create our paddle
        paddle = new Paddle(20, 20, 60);
    }



    @Override
    public void render ()
    {
        //clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //DRAW EVERTHING
        shape.begin(ShapeRenderer.ShapeType.Filled);

        for (Ball ball : balls)
        {
            ball.update();
            ball.draw(shape);
            ball.checkCollision(paddle);
        }


        //Draw our paddle
        paddle.update();
        paddle.draw(shape);


        //check collisio


        shape.end();
    }

}