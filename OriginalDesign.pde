int r = 255, g = 255, b = 255;
int x = 1, y = 1;
boolean keyW = false, keyA = false, keyS = false, keyD = false, border = false;;


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
  outline();
  rect(x - 1, y - 1, 3, 3);
}

void mouseClicked()
{
  x = mouseX - 1;
  y = mouseY - 1;
}

void outline()
{
  if(border)
  {
    stroke(100);
  }
  else 
  {
    noStroke();
    
  }
}

void boundary()
{
  if(x < 1)
  {
    x = 1;
  }
  if(x > 400)
  {
    x = 398;
  }
  if(y < 1)
  {
    y = 1;
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
  if(key == 'n')
  {
    border = !border;
  }
  if(key == 'b')
  {
    r = 0;
    g = 0;
    b = 0;
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