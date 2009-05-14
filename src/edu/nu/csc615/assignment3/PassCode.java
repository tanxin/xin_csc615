/**
 * Assignment 3
 *
 * Copyright 2005-2009 Shin Tan <tanxincn@gmail.com>
 *
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * 
 * @author	tanxin
 * Editor:	vim
 * Compile:	sun-jdk-1.6.0.13 64bit
 * Date:	May 8th 2009
 * Makefile:build.xml (runa2)
 */

package edu.nu.csc615.assignment3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class PassCode extends JFrame {
	
	public final static int BUTTON_NUM = 12;
	public final static int STATUS_NORMAL = 0;
	public final static int STATUS_RESULT = 1;	

	private JPanel titlePane;
	private JPanel passPane;
	private JPanel buttonPane;
	private JPanel outputPane;
	private JButton[] buttonArray;
	
	
	private JLabel titleLabel;
	private JTextField passField;
	private JFormattedTextField outputField;
	
	private int status;
	FlashThread flashThread;
	

	/* constructure */
	public PassCode() {

		/* initialize object */
		buttonArray = new JButton[BUTTON_NUM];		
		titleLabel = new JLabel("Security Access System");
		passField = new JPasswordField();
		outputField = new JFormattedTextField();
		
		titlePane = new JPanel();
		passPane = new JPanel();
		buttonPane = new JPanel();
		outputPane = new JPanel();
		
		/* fields initialization */
		Font font = new Font(Font.MONOSPACED, Font.BOLD, 22);
		passField.setPreferredSize(new Dimension(100,25));
		passField.setHorizontalAlignment(JPasswordField.RIGHT);
		passField.setFont(font);
		outputField.setPreferredSize(new Dimension(300,30));
		outputField.setHorizontalAlignment(JTextField.CENTER);
		outputField.setFont(font);
		outputPane.setBorder(new EmptyBorder(5,0,0,0));
		
		
		/* create uniform dimension for objects */
		Dimension dimensionB = new Dimension(100, 30);

		/* buttons initialization */
		int j;
		String[] buttonText = { "1", "2" , "3", "4", "5", "6" , "7", "8", "9", "Clear" , "0", "Enter"};
		for(j=0; j<buttonArray.length ; j++){
			buttonArray[j] = new JButton();
			buttonArray[j].setText(buttonText[j]);
			buttonArray[j].setSize(dimensionB);
			
			switch(j){
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 10:
				buttonArray[j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						numButtonActionPerformed(evt);
					}
				});
				break;
				
			case 9:
				buttonArray[j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						clearButtonActionPerformed(evt);
					}
				});
				break;
				
			case 11:
				buttonArray[j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						enterButtonActionPerformed(evt);
					}
				});
			}
		}
		

		/* layout definition */
		Container contentPane = getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		buttonPane.setLayout(new GridLayout(5,6,2,2));

		contentPane.add(titlePane);
		contentPane.add(passPane);
		contentPane.add(buttonPane);
		contentPane.add(outputPane);

		titlePane.add(titleLabel);
		passPane.add(passField);
		for(j=0; j<buttonArray.length; j++){
			buttonPane.add(buttonArray[j]);
		}
		
		outputPane.add(outputField);
		
		contentPane.setPreferredSize(new Dimension(320,240));

		/* apply layout */
		pack();
		/* close button can exit */
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/* clearButton Action */
	private void clearButtonActionPerformed(ActionEvent evt) {
		clearAll();
	}

	/* exitButton Action */
	private void enterButtonActionPerformed(ActionEvent evt) {
		status = STATUS_RESULT;
		if(flashThread != null && flashThread.isAlive())
			flashThread.interrupt();
		
		flashThread = new FlashThread(outputField);
		int intText;
		try{
			intText = Integer.parseInt(passField.getText());
		}catch (Exception e) {
			intText = 0;
		}
		
		if( intText < 1000){
			outputField.setText("Access Denied!!");
			outputField.setForeground(Color.RED);
		}else if(intText >= 1645 && intText <=1689){
			outputField.setText("Technical Personnel!!");
			outputField.setForeground(Color.GREEN);
		}else if(intText == 8345){
			outputField.setText("Custodian Services!!");
			outputField.setForeground(Color.GREEN);
		}else if(intText == 55875){
			outputField.setText("Special Services!!");
			outputField.setForeground(Color.GREEN);
		}else if(intText == 999898 || (intText >= 1000006 && intText <= 1000008)){
			outputField.setText("Science Personnel!!");
			outputField.setForeground(Color.GREEN);
		}else{
			outputField.setText("Access Denied!!");
			outputField.setForeground(Color.RED);
		}

		flashThread.start();
	}
	
	private void numButtonActionPerformed(ActionEvent evt) {
		if(status==STATUS_RESULT)
			clearAll();
		JButton btm = (JButton) evt.getSource();
		passField.setText(passField.getText() + btm.getText());
		System.out.println(passField.getText());
	}
	
	private void clearAll(){
		passField.setText("");
		outputField.setText("");
		status = STATUS_NORMAL;
	}
}
