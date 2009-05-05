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

/**
 * Object Grade
 *
 */
public class Grade {

	public static final double NUM_A = 4.0;
	public static final double NUM_AM = 3.7;
	public static final double NUM_BP = 3.3;
	public static final double NUM_B = 3.0;
	public static final double NUM_BM = 2.7;
	public static final double NUM_CP = 2.3;
	public static final double NUM_C = 2.0;
	public static final double NUM_CM = 1.7;
	public static final double NUM_DP = 1.3;
	public static final double NUM_D = 1.0;
	public static final double NUM_DM = 0.7;
	public static final double NUM_F = 0.0;
	
	protected String gradeString;
	
	protected double gradeDouble;
	
	public String getGradeString() {
		return gradeString;
	}

	public void setGradeString(String gradeString) {
		this.gradeString = gradeString;
	}

	public double getGradeDouble() {
		return gradeDouble;
	}

	public void setGradeDouble(double gradeDouble) {
		this.gradeDouble = gradeDouble;
	}

}