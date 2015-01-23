import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import javax.swing.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class NewFrame extends PApplet {

 
SecondApplet s;
public void setup() {
  size(640, 480); // size of first window 
  PFrame f = new PFrame(width, height);  // copies size of first window to second  
  frame.setTitle("first window");
  f.setTitle("second window");
  fill(0);
}
public void draw() {  //only for first window
  background(255);
  ellipse(mouseX, mouseY, 10, 10);
  s.setGhostCursor(mouseX, mouseY);
}



public class PFrame extends JFrame {
  public PFrame(int width, int height) {
    setBounds(100, 100, width, height);
    s = new SecondApplet();
    add(s);
    s.init();
    show();
  }
}

// basically a second window code center
public class SecondApplet extends PApplet 
{
  int ghostX, ghostY;
  public void setup() 
  {
    background(0);
    noStroke();
  }

  public void draw()
  {
    background(50);
    fill(255);
    ellipse(mouseX, mouseY, 10, 10);
    fill(0);
    ellipse(ghostX, ghostY, 10, 10);
  }
  public void setGhostCursor(int ghostX, int ghostY) 
  {
    this.ghostX = ghostX;
    this.ghostY = ghostY;
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "NewFrame" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
