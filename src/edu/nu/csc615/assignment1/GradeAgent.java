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

import java.util.HashMap;

import edu.nu.csc615.assignment1.exception.InvalidInputException;

/**
 * GradeAgent grade with the logic
 */
public class GradeAgent extends Grade {
	HashMap<String, Double> gradeList;
	
	/**
	 * Constructor with initial gradeList
	 */
	public GradeAgent(){
		gradeList = new HashMap<String, Double>();
		gradeList.put("A", NUM_A);
		gradeList.put("A-", NUM_AM);
		gradeList.put("B+", NUM_BP);
		gradeList.put("B", NUM_B);
		gradeList.put("B-", NUM_BM);
		gradeList.put("C+", NUM_CP);
		gradeList.put("C", NUM_C);
		gradeList.put("C-", NUM_CM);
		gradeList.put("D+", NUM_DP);
		gradeList.put("D", NUM_D);
		gradeList.put("D-", NUM_DM);
		gradeList.put("F", NUM_F);
	}
	
	/**
	 * Generate grade point from input grade "A-F"
	 * @param	gradeString				the grade from A to F  
	 * @throws	InvalidInputException	invalid grade string
	 */
	public void setGrade(String gradeString) throws InvalidInputException {
		this.gradeString = gradeString;
		
		try{
			this.gradeDouble = gradeList.get(gradeString);
		}catch(NullPointerException e){
			throw new InvalidInputException();
		}
	}
	
	/**
	 * TODO: unimplemented!!
	 * Generate grade from input grade point  
	 * @param gradeDouble	the grade from 0.0-4.0
	 */
	public void setGrade(Double gradeDouble){
		this.gradeDouble = gradeDouble;
		this.gradeString = null;
		throw new RuntimeException("This method has not been implemented!!");
	}

}
