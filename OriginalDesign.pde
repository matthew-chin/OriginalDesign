int r = 255, g = 255, b = 255;
int x = 0, y = 0;
boolean keyW = false, keyA = false, keyS = false, keyD = false;


void setup()
{
  size(400,400);
  background(0);
  frameRate(100);
  noStroke();
}
void draw()
{
  fill(r,g,b);
  move();
  boundary();
  rect(x - 1, y - 1, 3, 3);
}

void boundary()
{
  if(x < 0)
  {
    x = 0;
  }
  if(x > 400)
  {
    x = 398;
  }
  if(y < 0)
  {
    y = 0;
  }
  if(y > 400)
  {
    y = 398;
  }
}

void move()
{
  if(keyW == true)
  {
    y -= 3;
  }
  else if(keyS == true)
  {
    y += 3;
  }
  if(keyA == true)
  {
    x -= 3;
  }
  else if(keyD == true)
  {
    x += 3;
  }
}

void keyPressed()
{
  if(key == 'w')
  {
    keyW = true;
  }
  else if(key == 'a')
  {
    keyA = true;
  }
  else if(key == 's')
  {
    keyS = true;
  }
  else if(key == 'd')
  {
    keyD = true;
  }
  if(key == '0')
  {
    background(0);
  }
  if(key == '1')
  {
    r = 255;
    g = 0;
    b = 0;
  }
  if(key == '2')
  {
    r = 0;
    g = 255;
    b = 0;
  }
  if(key == '3')
  {
    r = 0;
    g = 0;
    b = 255;
  }
  if(key == '4')
  {
    r = 255;
    g = 255;
    b = 0;
  }
  if(key == '5')
  {
    r = 255;
    g = 0;
    b = 255;
  }
  if(key == '6')
  {
    r = 255;
    g = 140;
    b = 0;
  }
  if(key == '7')
  {
    r = 139;
    g = 69;
    b = 19;
  }
  if(key == '8')
  {
    r = 190;
    g = 190;
    b = 190;
  }
  if(key == '9')
  {
    r = 255;
    g = 255;
    b = 255;
  }
}

void keyReleased()
{
  if(key == 'w')
  {
    keyW = false;
  }
  else if(key == 'a')
  {
    keyA = false;
  }
  else if(key == 's')
  {
    keyS = false;
  }
  else if(key == 'd')
  {
    keyD = false;
  }
}