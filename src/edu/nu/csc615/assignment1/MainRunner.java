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

import edu.nu.csc615.assignment1.exception.ExitException;
import edu.nu.csc615.assignment1.exception.InvalidInputException;

/**
 * Assigment 1 CSC615
 * @author	Xin Tan
 * IDE:		vim & eclipse
 * Date:	May 4th 2009
 * Compiler:JDK 6.0 64bit(1.6)
 * Makefile:build.xml
 */
public class MainRunner {
	
	/* exit code to the shell */
	public final static int EXIT_NORMAL = 0;
	public final static int EXIT_FATAL = 9;

	/**
	 * Entrance point
	 * @param args	unless so far
	 */
	public static void main(String[] args) {
		
		/* allocate the instance */
		GradeAccessor gradeAccessor = new GradeAccessor();
		
		while(true){
			try{
				/* read by opening the dialog according to the requirement */
				gradeAccessor.readFromDialog();
				/* output to stdout according to the requirement */
				gradeAccessor.writeToTerminal();
			}catch(InvalidInputException e /* invalid grade, print error message and keep going*/){ 
				System.err.println("Please enter A-F");
			}catch(ExitException e /* exit exception by clicking cancel button and exit with normal signal*/){
				System.out.println("Thank you for your using.");
				System.exit(EXIT_NORMAL);
			}catch(Exception e /* impossible exception catch, could not happen generally. if that happen, need debug stack */){
				System.err.println("impossible exception occured, debug information:");
				e.printStackTrace();
				System.exit(EXIT_FATAL);
			}
		}
	}
}
