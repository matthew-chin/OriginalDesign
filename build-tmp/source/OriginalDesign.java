import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OriginalDesign extends PApplet {

leftPaddle player1 = new leftPaddle(0, 80);
rightPaddle player2 = new rightPaddle(445, 80);
rightAttack attack1 = new rightAttack(150, 87);
leftAttack attack2 = new leftAttack(300, 87);
boolean keyW = false;
boolean keyS = false;
boolean keyUp = false;
boolean keyDown = false;
Ball boing = new Ball(PApplet.parseInt(random(2)), PApplet.parseInt(random(2)));
boolean gameOver = false;
int point1 = 0;
int point2 = 0;

public void setup()
{
  size(450, 200);
  textAlign(CENTER);
  textSize(24);
  fill(0, 0, 255);
}

public void draw()
{
  if (gameOver == false)
  {
    background(0);
    player1.move();
    player2.move();
    player1.show();
    player2.show();
    attack1.move();
    attack2.move();
    attack1.show();
    attack2.show();
    boing.bounce();
    boing.check();
    boing.move();
    boing.show();
    boing.points();
  }
}


public void keyPressed() 
{
  if (key == 'w') 
  {
    keyW = true;
  } else if (key == 's') 
  {
    keyS = true;
  } else if (key == 'k') 
  {
    keyUp = true;
  } else if (key == 'm')
  {
    keyDown = true;
  }
}

public void keyReleased() 
{
  if (key == 'w') 
  {
    keyW = false;
  } else if (key == 's') 
  {
    keyS = false;
  } 
  if (key == 'k')
  {
    keyUp = false;
  } else if (key == 'm')
  {
    keyDown = false;
  }
}
int up;
int left;
class Ball
{
  int ballX = 225;
  int ballY = 100;

  Ball(int upTemp, int leftTemp)
  {
    up = upTemp;
    left = leftTemp;
  }

  public void points()
  {
    if (ballX > 445)
    {
      point1++;
    }
    if (ballX < 5)
    {
      point2++;
    }
    textSize(24);
    text(point1, 205, 25);
    text(point2, 245, 25);
    if (point1 > 19)
    {
      gameOver = true;
      background(255, 20, 147);
      fill(254);
      text("PLAYER 1 WINS!!!", 225, 100);
    } else if (point2 > 19)
    {
      gameOver = true;
      background(255, 20, 147);
      fill(254);
      text("PLAYER 2 WINS!!!", 225, 100);
    }
  }

  public void check()
  {
    if (get(ballX+6, ballY) == color(255))
    {
      left = 1;
    }
    if (get(ballX-6, ballY) == color(255))
    {
      left = 2;
    }
  }
  public void move()
  {
    if (up == 1)
    {
      ballY -= 5;
    } else 
    {
      ballY += 5;
    }
    if (left == 1)
    {
      ballX -= 5;
    } else 
    {
      ballX += 5;
    }
  }
  public void bounce()
  {
    if (ballY > 195)
    {
      up = 1;
    }
    if (ballY < 5)
    {
      up = 2;
    }
    if (ballX < 5)
    {
      left = 2;
    }
    if (ballX > 445)
    {
      left = 1;
    }
  }
  public void show()
  {
    fill(255);
    ellipse(ballX, ballY, 10, 10);
  }
}


class Paddle
{
  int paddleX;
  int paddleY;
  int atklength1;
  int atklength2;
  Paddle() {
  };
  Paddle(int tempX, int tempY)
  {
    paddleX = tempX;
    paddleY = tempY;
  }

  public void show()
  {
    fill(255);
    rect(paddleX, paddleY, 5, 40);
  }
}
class leftPaddle extends Paddle
{
  leftPaddle(int tempX, int tempY)
  {
    super (tempX, tempY);
  }
  public void move()
  {
    if (keyW == true)
    {
      paddleY -= 5;
    } else if (keyS == true)
    {
      paddleY += 5;
    }

    if (paddleY < 0)
    {
      paddleY = 0;
    }
    if (paddleY > 160)
    {
      paddleY = 160;
    }
  }
  public void show()
  {
    super.show();
  }
}

class rightPaddle extends Paddle
{
  rightPaddle(int tempX, int tempY)
  {
    super (tempX, tempY);
  }
  public void move()
  {
    if (keyUp == true)
    {
      paddleY -= 5;
    } else if (keyDown == true)
    {
      paddleY += 5;
    }

    if (paddleY < 0)
    {
      paddleY = 0;
    }
    if (paddleY > 160)
    {
      paddleY = 160;
    }
  }
  public void show()
  {
    super.show();
  }
}

class rightAttack extends rightPaddle
{
  rightAttack(int tempX, int tempY)
  {
    super (tempX, tempY);
  }
  public void move()
  {
    if (keyUp == true)
    {
      paddleY -= 5;
    } else if (keyDown == true)
    {
      paddleY += 5;
    }

    if (paddleY < 0)
    {
      paddleY = 0;
    }
    if (paddleY > 174 - atklength2)
    {
      paddleY = 174 - atklength2;
    }
  }
  public void show()
  {
    fill(255);
    atklength2 = (point1 - point2)*5;
    if (atklength2 < 0)
    {
      atklength2 = 0;
    }

    rect(paddleX, paddleY, 10, 26 + atklength2);
  }
}

class leftAttack extends leftPaddle
{
  leftAttack(int tempX, int tempY)
  {
    super (tempX, tempY);
  }
  public void move()
  {
    if (keyW == true)
    {
      paddleY -= 5;
    } else if (keyS == true)
    {
      paddleY += 5;
    }

    if (paddleY < 0)
    {
      paddleY = 0;
    }
    if (atklength1 < 0)
    {
      atklength1 = 0;
    }
    if (paddleY > 174 - atklength1)
    {
      paddleY = 174 - atklength1;
    }
  }
  public void show()
  {
    fill(255);
    atklength1 = (point2 - point1)*5;
    if (atklength1 < 0)
    {
      atklength1 = 0;
    }
    rect(paddleX, paddleY, 10, 26 + atklength1);
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalDesign" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
