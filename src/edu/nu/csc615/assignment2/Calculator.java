/**
 * Assignment 2
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
 * Memo:	Prof: it could not be compiled last assignment with 7 separate files, this time I tried to do within 1 file without packages 
 */
package edu.nu.csc615.assignment2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import edu.nu.csc615.assignment1.exception.InvalidInputException;

public class Calculator extends javax.swing.JFrame {

	private JButton addButton;
	private JButton clearButton;
	private JButton divideButton;
	private JButton multiplyButton;
	private JLabel numLabel3;
	private JLabel numLable1;
	private JLabel numLable2;
	private JTextField numText1;
	private JTextField numText2;
	private JTextField numText3;
	private JButton subtractButton;
	private JLabel titleLabel;
	private JButton exitButton;
	private JPanel titlePane;
	private JPanel inputPane;
	private JPanel buttonPane;
	private JPanel systemPane;


	/* constructure */
	public Calculator() {

		/* initialize object */
		titleLabel = new JLabel();
		numLable1 = new JLabel();
		numText1 = new JTextField();
		numLable2 = new JLabel();
		numText2 = new JTextField();
		numLabel3 = new JLabel();
		numText3 = new JTextField();
		addButton = new JButton();
		subtractButton = new JButton();
		multiplyButton = new JButton();
		divideButton = new JButton();
		clearButton = new JButton();
		exitButton = new JButton();
		titlePane = new JPanel();
		inputPane = new JPanel();
		buttonPane = new JPanel();
		systemPane = new JPanel();

		/* create uniform dimension for objects */
		Dimension dimension = new Dimension(100, 19);

		/* close button can exit */
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		/* labels initialization */
		titleLabel.setText("SUPER CALCULATOR");
		numLable1.setText("Num1:");
		numText1.setPreferredSize(dimension);
		numLable2.setText("Num2:");
		numText2.setPreferredSize(dimension);
		numLabel3.setText("Result:");
		numText3.setEditable(false);
		numText3.setPreferredSize(dimension);

		/* buttons initialization */
		addButton.setText("Add");
		addButton.setPreferredSize(dimension);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				AddButtonActionPerformed(evt);
			}
		});

		subtractButton.setText("Subtract");
		subtractButton.setPreferredSize(dimension);
		subtractButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SubtractButtonActionPerformed(evt);
			}
		});

		multiplyButton.setText("Multiply");
		multiplyButton.setPreferredSize(dimension);
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				MultiplyButtonActionPerformed(evt);
			}
		});

		divideButton.setText("Divide");
		divideButton.setPreferredSize(dimension);
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DivideButtonActionPerformed(evt);
			}
		});

		clearButton.setText("Clear");
		clearButton.setPreferredSize(dimension);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ClearButtonActionPerformed(evt);
			}
		});

		exitButton.setText("Exit");
		exitButton.setPreferredSize(dimension);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				exitButtonActionPerformed(evt);
			}
		});

		/* layout definition */
		Container contentPane = getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		contentPane.add(titlePane);
		contentPane.add(inputPane);
		contentPane.add(buttonPane);
		contentPane.add(systemPane);

		titlePane.add(titleLabel);
		inputPane.add(numLable1);
		inputPane.add(numText1);
		inputPane.add(numLable2);
		inputPane.add(numText2);
		inputPane.add(numLabel3);
		inputPane.add(numText3);
		buttonPane.add(addButton);
		buttonPane.add(subtractButton);
		buttonPane.add(multiplyButton);
		buttonPane.add(divideButton);
		systemPane.add(clearButton);
		systemPane.add(exitButton);

		/* apply layout */
		pack();
	}

	/* clearButton Action */
	private void ClearButtonActionPerformed(ActionEvent evt) {
		numText1.setText("");
		numText2.setText("");
		numText3.setText("");
	}

	/* exitButton Action */
	private void exitButtonActionPerformed(ActionEvent evt) {										   
		System.exit(0);
	}										  

	/* addButton Action */
	private void AddButtonActionPerformed(ActionEvent evt) {
		try {
			Double result = parseDouble(numText1) + parseDouble(numText2);
			numText3.setText(result.toString());
		} catch (InvalidInputException e) {
			JOptionPane.showMessageDialog(this, "Please enter the number in textbox");
		}

	}

	/* subtractButton Action */
	private void SubtractButtonActionPerformed(ActionEvent evt) {
		try{
			Double result = parseDouble(numText1) - parseDouble(numText2);
			numText3.setText(result.toString());
		} catch (InvalidInputException e) {
			JOptionPane.showMessageDialog(this, "Please enter the number in textbox");
		}
	}

	/* multiplyButton Action */
	private void MultiplyButtonActionPerformed(ActionEvent evt) {
		try{
			Double result = parseDouble(numText1) * parseDouble(numText2);
			numText3.setText(result.toString());
		} catch (InvalidInputException e) {
			JOptionPane.showMessageDialog(this, "Please enter the number in textbox");
		}
	}

	/* diviveButton Action */
	private void DivideButtonActionPerformed(ActionEvent evt) {
		if(Double.parseDouble(numText2.getText()) == 0){
			JOptionPane.showMessageDialog(this, "Any number divided by zero is meanless");
			return;
		}

		try{
			Double result = parseDouble(numText1) / parseDouble(numText2);
			String resultString = result.toString();
			numText3.setText((resultString.length()>12 ? resultString.substring(0,12):resultString));
		} catch (InvalidInputException e) {
			JOptionPane.showMessageDialog(this, "Please enter the number in textbox");
		}
	}

	/* function to correct textfield */
	public Double parseDouble(JTextField text) throws InvalidInputException{
		try{
			return Double.parseDouble(text.getText());
		}catch (NumberFormatException e) {
			throw new InvalidInputException("abc");
		}
	}
}
