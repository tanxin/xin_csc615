package edu.nu.csc615.lab6;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;

public class MyApplet extends JApplet implements MouseListener {
	
	int step=0; 
	
	public void init() {
		addMouseListener(this);
    }

	public void paint(Graphics g){
		super.paint(g);
		if(step % 2 == 0){
			g.setColor(Color.red);
			g.drawOval(30, 30, 150, 60);
			g.setColor(Color.blue);
			g.drawRect(30, 30, 150, 60);
		}else{
	        g.setColor(Color.red);
	        g.drawOval(30, 30, 150, 60);
	        g.setColor(Color.blue);
	        g.drawOval(50, 50, 130, 70);
	        g.setColor(Color.green);
	        g.drawOval(10, 20, 70, 120);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		step++;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
} 