/**
 * Lab5
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
 * Date:    May 20th 2009
 * Makefile:build.xml (runl5)
 */
package edu.nu.csc615.lab5;

import java.awt.Point;

public class Test {
	
	/* for test */
	public static void main(String[] args){
		Quadrilateral shape1 = new Quadrilateral(new Point(1,3), new Point(5,4), new Point(6,-4), new Point(0,-5));
		
		Trapezoid shape2 = new Trapezoid(new Point(2,3), new Point(7,3), new Point(10,10), new Point(0,10));
		System.out.println(shape2);
		
		Parallelogram shape3 = new Parallelogram(new Point(2,3), new Point(10,3), new Point(4,10), new Point(12,10));
		System.out.println(shape3);
		
		Rectangle shape4 = new Rectangle(new Point(2,3), new Point(8,3), new Point(8,10), new Point(2,10));
		System.out.println(shape4);
		
		Square shape5 = new Square(new Point(0,0), new Point(0,5), new Point(5,5), new Point(5,0));
		System.out.println(shape5);
	}

}
