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

public class Grade {
	public final static double NUM_A = 4.0;
	public final static double NUM_AM = 3.7;
	public final static double NUM_BP = 3.3;
	public final static double NUM_B = 3.0;
	public final static double NUM_BM = 2.7;
	public final static double NUM_CP = 2.3;
	public final static double NUM_C = 2.0;
	public final static double NUM_CM = 1.7;
	public final static double NUM_DP = 1.3;
	public final static double NUM_D = 1.0;
	public final static double NUM_DM = 0.7;
	public final static double NUM_F = 0.0;
	
	HashMap<String, Double> gradeList;
	
	private String gradeString;
	
	public Grade(){
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
	
	public void setGradeString(String gradeString) {
		this.gradeString = gradeString;
	}
	
	public String getGradeString() {
		return gradeString;
	}

	public double getGrade() throws InvalidInputException{
		try{
			return gradeList.get(gradeString);
		}catch(NullPointerException e){
			/* impossible */
			throw new InvalidInputException();
		}
	}
}
