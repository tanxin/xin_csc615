package edu.nu.csc615.assignment2;

import java.awt.EventQueue;

public class Assign2 {

	/* entrance point */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Calculator().setVisible(true);
			}
		});
	}

}
