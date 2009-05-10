/**
 * Lab1
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
package edu.nu.csc615.lab1;

import java.util.Scanner;

/**
 * @author Shin Tan
 *
 */
public class SimpleCalc {
	
	final public static int NUM = 3; 

	public static void main(String[] args) {
		Integer[] intArray = new Integer[NUM];
		Integer smallest=Integer.MAX_VALUE, largest=Integer.MIN_VALUE, sum=0, average=0, product=1;
		
		Scanner scanner = new Scanner(System.in);
		
		/* input NUM numbers */
		for(int j=0;j<NUM;j++){
			System.out.println("Input number " + (j+1) + ": ");
			intArray[j] = scanner.nextInt();
		}
		
		/* output All the numbers */
		System.out.println("Display:\t");
		for(int j=0;j<NUM;j++)
			System.out.printf("intArray[%d] = %d\n", j, intArray[j]);
		
		
		/* start calculate */
		for(int j=0;j<NUM;j++){
			sum +=intArray[j];
			product *= intArray[j];
			if(intArray[j] < smallest)
				smallest = intArray[j];
			if(intArray[j] > largest)
				largest = intArray[j];		                   
		}
		average = sum / NUM;
		
		/* print the result */
		System.out.println("Sum:\t" + sum);
		System.out.println("Average:\t" + average);
		System.out.println("Product:\t" + product);
		System.out.println("Smallest:\t" + smallest);
		System.out.println("Largest:\t" + largest);
	}
}
