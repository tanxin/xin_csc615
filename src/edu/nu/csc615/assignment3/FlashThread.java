package edu.nu.csc615.assignment3;

import java.awt.Color;

import javax.swing.JFormattedTextField;

public class FlashThread extends Thread {
	
	public JFormattedTextField textField;
	public final static Color COLOR = Color.white;
	
	public FlashThread(JFormattedTextField outputField){
		this.textField = outputField;
	}
	
	public void run(){
		Color buff;
		buff = textField.getForeground();
		
		for(int j=0; j<5; j++){
			try {
				Thread.sleep(500);
				textField.setForeground(COLOR);
				Thread.sleep(500);
				textField.setForeground(buff);
			} catch (InterruptedException e) {
				//TODO: i eat it
			}
		}		
	}
	
}
