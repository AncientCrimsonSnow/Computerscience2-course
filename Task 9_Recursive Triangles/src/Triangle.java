import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Random;

import javax.swing.JPanel;


public class Triangle extends JPanel {
	
	private Sierpinski_Triangle myST;
	private Dimension D;
	//every different size of Triangle got a random Color.
	private Color[] colors;
	//Amount of iterations 
	private int depth;
	/*
	 * A triangle drawing panel can be called with a Dimension or by the value directly.
	 */
	public Triangle(Dimension dimension, int depth) {
		Triangle myTriangle = new Triangle(dimension.height,dimension.width,depth);
	}
	public Triangle(int height, int width, int depth) {
		D = new Dimension(width, height);
		this.depth = depth;
		colors = new Color[depth+2];
		Random rand = new Random();
		float r;
		float g;
		float b;
		for(int i = 0; i<colors.length;i++) {
			r = rand.nextFloat();
			g = rand.nextFloat();
			b = rand.nextFloat();
			colors[i] = new Color(r,g,b);
		}
		setBackground(Color.black);
	}
	@Override
	
	public void paintComponent(Graphics g) {
		//Ask again for the Size everytime to update the Triangle.
		D.setSize(getParent().getSize());
		
		//calculating the hight of the Triangle.
		int height = D.height;	
		int h = (int) Math.round(D.width/2*Math.sqrt(3));
		h = height -(D.height-h);

		//calculating the 3 corner points.
		Point p1;
		Point p2;
		Point p3;
		//checking if our width or height of our Panel is limiting our Triangle
		//and calculating the points in corresponds to that.
		if(h<=D.height) {
			p1 = new Point(0, h);
			p2 = new Point(D.width, h);
			p3 = new Point(D.width/2,0);
		}
		else {
			h = D.height;
			int c = (int)(2*h/Math.sqrt(3));
			p1 = new Point(0,h);
			p2 = new Point(c,h);
			p3 = new Point(c/2,0);
		}
		//creating new Sierpinski Triangle with the points.
		myST = new Sierpinski_Triangle(depth, p1, p2, p3);
		
		//drawing the outa Border of our Triangle
		g.drawPolygon(new Polygon(myST.getXpoints(), myST.getYpoints(), 3));
		//Start to paint our Triangle
		g.setColor(colors[myST.getDepth()+1]);
		paintTriangles(g, myST);
	}
	public void paintTriangles(Graphics g, Sierpinski_Triangle myST) {
		g.setColor(colors[myST.getDepth()]);
		//Drawing Lines are the connection of all Midpoints of our edges.
		int[]xpoints = {
				UM.getMidpoint(myST.getP1(), myST.getP2()).getX(),
				UM.getMidpoint(myST.getP2(), myST.getP3()).getX(),
				UM.getMidpoint(myST.getP1(), myST.getP3()).getX(),
		};
		int[]ypoints = {
				UM.getMidpoint(myST.getP1(), myST.getP2()).getY(),
				UM.getMidpoint(myST.getP2(), myST.getP3()).getY(),
				UM.getMidpoint(myST.getP1(), myST.getP3()).getY(),
		};
		g.drawPolygon(new Polygon(xpoints, ypoints, 3));
		g.fillPolygon(new Polygon(xpoints, ypoints, 3));
		
		//if there are more and
		//if its worth to paint them(Triangle is bigger than 3 Pixels)
		//We call this function again 3 Time for the next 3 Triangle with one size lvl lower.
		if(myST.getDepth()>0 && myST.getP2().getX()-myST.getP1().getX()>3) {
			paintTriangles(g, myST.getSt1());
			paintTriangles(g, myST.getSt2());
			paintTriangles(g, myST.getSt3());
		}
	}
}
