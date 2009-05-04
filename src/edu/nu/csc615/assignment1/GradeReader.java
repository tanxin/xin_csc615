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

public class GradeReader {
	private Grade grade;
	
	public GradeReader(){
		grade = new Grade();
	}
	
	public Grade getGrade() {
		return grade;
	}

	public void readFromDialog() throws ExitException {
		String input = JOptionPane.showInputDialog("Please enter a grade number, press cancel to stop");
		if(input == null)
			throw new ExitException();
		grade.setGradeString(input);
	}
	
	public void writeToTerminal() throws InvalidInputException{
		System.out.println(grade.getGradeString() + ":" + grade.getGrade());
	}
}
