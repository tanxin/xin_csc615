/**
 * Assignment 4
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
 * @author  tanxin
 * Editor:  vim
 * Compile: sun-jdk-1.6.0.13 64bit
 * Date:    May 17th 2009
 * Makefile:build.xml (runa4)
 */

package edu.nu.csc615.assignment4;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class DrugTester extends JFrame {

	private JButton startButton;
	private JButton resetButton;
	private JButton undoButton;
	private JButton exitButton;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JList jList1;
	private JList jList2;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JPanel jPanel4;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JTextField jTextField1;
	private ArrayList<String> selectList;
	private ArrayList<String> candidateList;
	private ArrayList<ArrayList<String>> undoList1;
	private ArrayList<ArrayList<String>> undoList2;

	/** Creates new form NewJFrame1 */
	public DrugTester() {
		resetData();
		initGUI();
	}

	private void resetData() {
		selectList = new ArrayList<String>();
		candidateList = new ArrayList<String>();
		undoList1 = new ArrayList<ArrayList<String>>();
		undoList2 = new ArrayList<ArrayList<String>>();
		candidateList.add("Hakeem Olajuwon");
		candidateList.add("Yao Ming");
		candidateList.add("Clyde Drexler");
		candidateList.add("Moses Malone");
		candidateList.add("Robert Horry");
		candidateList.add("Sam Cassell");
		candidateList.add("Elvin Hayes");
		candidateList.add("Cutino Mobley");
		candidateList.add("John Lucas");
		candidateList.add("Kenny Smith");
		candidateList.add("Mario Ellie");
		candidateList.add("Robert Reid");
		candidateList.add("Stevie Francis");
		candidateList.add("Tracy McGrady");
		candidateList.add("Buck Johnson");
		candidateList.add("Chuck Hayes");
		candidateList.add("Eddie Johnson");
		candidateList.add("Eric Sleepy Floyd");
		candidateList.add("Jim Peterson");
		candidateList.add("Larry Smith");
	}

	private void initGUI() {
		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		jPanel2 = new JPanel();
		jLabel2 = new JLabel();
		jTextField1 = new JTextField();
		jLabel3 = new JLabel();
		jPanel3 = new JPanel();
		startButton = new JButton();
		resetButton = new JButton();
		undoButton = new JButton();
		exitButton = new JButton();
		jPanel4 = new JPanel();
		jScrollPane1 = new JScrollPane();
		jList1 = new JList();
		jScrollPane2 = new JScrollPane();
		jList2 = new JList();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("NFL Drug Testing System v1.0");
		setMinimumSize(new java.awt.Dimension(640, 480));
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.LINE_AXIS));
		jPanel1.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		
		jLabel1.setFont(new java.awt.Font("Dialog", 3, 24));
		jLabel1.setText("NFL Drug Testing Program");
		jPanel1.add(jLabel1);

		getContentPane().add(jPanel1);

		jPanel2.setBorder(BorderFactory.createEmptyBorder(10, 120, 1, 120));
		jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.X_AXIS));

		jLabel2.setText("No. of Candidates");
		jPanel2.add(jLabel2);

		jTextField1.setText("0");
		jTextField1.setPreferredSize(new java.awt.Dimension(10, 30));
		jTextField1.setSize(new java.awt.Dimension(10, 30));
		jPanel2.add(jTextField1);

		jPanel2.add(jLabel3);

		getContentPane().add(jPanel2);

		jPanel3.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

		startButton.setText("Start");
		startButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startButtonActionPerformed(evt);
			}
		});
		jPanel3.add(startButton);

		resetButton.setText("Reset");
		resetButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resetButtonActionPerformed(evt);
			}
		});
		jPanel3.add(resetButton);

		undoButton.setText("Undo");
		undoButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				undoButtonActionPerformed(evt);
			}
		});
		jPanel3.add(undoButton);

		exitButton.setText("Exit");
		exitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitButtonActionPerformed(evt);
			}
		});
		jPanel3.add(exitButton);

		getContentPane().add(jPanel3);

		jPanel4.setBorder(BorderFactory.createTitledBorder("Selection Results"));
		jPanel4.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

		jScrollPane1.setBorder(BorderFactory.createTitledBorder("Selection List"));
		jScrollPane1.setViewportView(jList1);

		jPanel4.add(jScrollPane1);
		
		jScrollPane2.setBorder(BorderFactory.createTitledBorder("Remaining Candidates"));
		jScrollPane2.setViewportView(jList2);
		jScrollPane2.setPreferredSize(new java.awt.Dimension(110, 340));

		jPanel4.add(jScrollPane2);

		getContentPane().add(jPanel4);

		pack();
		
		myrefresh();
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DrugTester().setVisible(true);
			}
		});
	}

	private void startButtonActionPerformed(ActionEvent evt) {
		int num;
		try{
			num = Integer.parseInt(jTextField1.getText());
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Please enter the number in textbox");
			return;
		}

		int i;
		String tmp;
		ArrayList<String> undo = new ArrayList<String>();
		
		if(candidateList.size()<num)
			num = candidateList.size();
		if(num<1) {
			JOptionPane.showMessageDialog(this, "Please enter the number which bigger than zero in textbox");
			return;
		}

		undoList1.add(new ArrayList<String>(selectList));
		selectList.clear();
		
		Random random = new Random();
		for(int j=0;j<num;j++){
			i = random.nextInt(candidateList.size());
			tmp = candidateList.remove(i);
			undo.add(tmp);
			selectList.add(tmp);
		}
		undoList2.add(undo);
		myrefresh();
	}

	private void myrefresh() {
		jList1.setModel(new AbstractListModel() {
			public int getSize() { return selectList.size(); }
			public Object getElementAt(int i) { return selectList.get(i); }
		});
		
		jList2.setModel(new AbstractListModel() {
			public int getSize() { return candidateList.size(); }
			public Object getElementAt(int i) { return candidateList.get(i); }
		});
		jLabel3.setText("(Remaining candidates: " + candidateList.size() + ")");
		if(undoList1.size()>0)
			undoButton.setEnabled(true);
		else
			undoButton.setEnabled(false);
	}
	
	private void exitButtonActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	private void resetButtonActionPerformed(ActionEvent evt) {
		resetData();
		myrefresh();
	}
	private void undoButtonActionPerformed(ActionEvent evt) {
		if(undoList1.size()>0 && undoList2.size()>0){
			selectList= undoList1.remove(undoList1.size()-1);
			candidateList.addAll(undoList2.remove(undoList2.size()-1));
		}
		myrefresh();
	}
}
