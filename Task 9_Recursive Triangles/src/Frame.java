
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JWindow;

public class Frame extends JFrame{
	
	public Frame(int height ,int width, int depth) {
		
		this.setBackground(Color.black);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.black));
		add(new Triangle(height-50,width-50,depth));
		setTitle("Triangle");
		setSize(height ,width);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	public static void main(String[] args) {
		
		//Frame myFrame = new Frame(500, 500, Integer.valueOf(args[0]));
		Frame myFrame = new Frame(500, 500, 10);
	}
}
