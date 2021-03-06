/**
 * Assignment 1
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
 */
package edu.nu.csc615.assignment1;

import javax.swing.JOptionPane;

import edu.nu.csc615.assignment1.exception.ExitException;
import edu.nu.csc615.assignment1.exception.InvalidInputException;

/**
 * Accessor with Input Output
 *
 */
public class GradeAccessor {
	private GradeAgent grade, totalGrade;
	private int count=0;
	
	public GradeAccessor(){
		grade = new GradeAgent();
		totalGrade = new GradeAgent();
	}
	
	/**
	 * Read grade from Dialog, JOptionPane is required to be used in assignment requirement
	 * @throws ExitException			ask for exit if press cancel button
	 * @throws InvalidInputException	invalid grade string from A to F
	 */
	public void readFromDialog() throws ExitException, InvalidInputException {
		String input = JOptionPane.showInputDialog("Please enter a grade number, press cancel to stop");
		if(input == null)
			throw new ExitException();
		grade.setGrade(input);
		
		totalGrade.addGrade(grade);
		count++;
	}
	
	/**
	 * Write result to stdout followed by assignment requirement
	 */
	public void writeToTerminal() {
		System.out.println(grade.getGradeString() + ":" + grade.getGradeDouble());
	}
	
	public void writeGPAToTerminal(){
		GradeAgent result = new GradeAgent();
		result.setGrade(totalGrade.getGradeDouble() / Double.valueOf(count));
		System.out.println("GPA:" + result.getGradeString() + "(" + result.getGradeDouble() + ")");
	}
}
