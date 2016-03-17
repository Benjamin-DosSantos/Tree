package snowman;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Snowman extends Applet{
	
	public void init(){
		this.setSize(1000, 800);
		this.setBackground(Color.blue);
	}
	
	public void paint(Graphics g){
		drawSnowman(g, 400, 200, 100, 2);
	}
	
	public void drawSnowman(Graphics g, int x, int y, int size, int zoom){
		drawFace(g, x, y, size, zoom);
		drawMiddle(g, x-20, y+size - 15, size+40, zoom);
		drawBody(g, x-40, y+size*2+40 - 50, size+80, zoom);
	}
	
	public void drawMiddle(Graphics g, int x, int y, int size, int zoom){
		drawBody(g, x, y, size, zoom);
		drawArms(g, x + 20, y + 30, x + (size - 20), y+30, zoom);
		drawButtons(g, x + size/2, y+20, zoom);
	}
	
	public void drawBody(Graphics g, int x, int y, int size, int zoom){
		g.setColor(Color.white);
		g.fillOval(x, y, size * zoom, size * zoom);
	}
	
	public void drawButtons(Graphics g, int x, int y, int zoom){
		g.setColor(Color.black);
		g.fillOval(x,y,10 * zoom,10 * zoom);
		g.fillOval(x,y+30,10 * zoom,10 * zoom);
		g.fillOval(x,y+60,10 * zoom,10 * zoom);
	}
	
	public void drawFace(Graphics g, int x, int y, int size, int zoom){
		drawBody(g, x, y, size, zoom);
		drawEyes(g, x+20, y+10, zoom);
		drawNose(g, x+40, y+45, zoom);
	}
	
	public void drawNose(Graphics g, int x, int y, int zoom){
		int xs[]= {x, x, x+40};
		int ys[]= {y, y+20, y+10};
		
		g.setColor(Color.orange);
		g.fillPolygon(xs, ys, 3);
	}
	
	public void drawEyes(Graphics g, int x, int y, int zoom){
		g.setColor(Color.black);
		g.fillOval(x,y + 20, 10 * zoom, 10 * zoom);
		g.fillOval(x + 40,y + 20, 10 * zoom, 10 * zoom);
	}
	
	public void drawArms(Graphics g, int lx, int ly, int rx, int ry, int zoom){
		g.setColor(Color.black);
		drawLeftArm(g, lx, ly);
		drawRightArm(g, rx, ry);
	}
	
	public void drawLeftArm(Graphics g, int x, int y){
		g.drawLine(x, y, x-100, y);
	}
	
	public void drawRightArm(Graphics g, int x, int y){
		g.drawLine(x, y, x+100, y);
	}

}
