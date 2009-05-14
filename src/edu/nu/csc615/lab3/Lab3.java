/**
 * Lab3
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
package edu.nu.csc615.lab3;

import java.util.Random;

public class Lab3 {
	
	/* define constant */
	public final static int ARRAY_SIZE = 500;

	public static void main(String[] args) {
		
		int average=0, sum=0, numAbove=0, numBelow=0, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
		int[] intArray = new int[ARRAY_SIZE];
		
		generateRandomArray(intArray);
		
		/* calculate */
		for(int j=0;j<intArray.length;j++){
			sum += intArray[j];
			
			if(intArray[j] > max)
				max = intArray[j];
			
			if(intArray[j] < min)
				min = intArray[j];
		}
		average = sum / intArray.length;
		
		/* count the above/below average */
		for(int j=0;j<intArray.length;j++){
			if(intArray[j] > average)
				numAbove++;
			if(intArray[j] < average)
				numBelow++;
		}
		
		/* print out the generated num */
		System.out.println("Generated num:");
		printArray(intArray);
		
		System.out.println("average = " + average);
		System.out.println("sum = " + sum);
		System.out.println("largest = " + max);
		System.out.println("smallest = " + min);
		System.out.println("number above the average = " + numAbove);
		System.out.println("number below the average = " + numBelow);
		
		sort(intArray);
		
		/* print out the array again after sorting */
		System.out.println("After sorting");
		printArray(intArray);
		
	}

	private static void printArray(int[] intArray) {
		for(int j=0;j<intArray.length;j++){
			System.out.print(intArray[j] + ",");
		}
		System.out.println(".");
	}

	/* generate random array */
	private static void generateRandomArray(int[] intArray) {
		
		Random random = new Random();
		for(int j=0;j<intArray.length;j++){
			intArray[j] = random.nextInt(200) + 1;
		}
	}
	
	/* bubble sort */
	public static void sort(int[] intArray){
		int i,j,t;
		for(i=0;i<intArray.length-1;i++){
			for(j=i+1;j<intArray.length;j++){
				if(intArray[i]>intArray[j]){
					t=intArray[i];
					intArray[i]=intArray[j];
					intArray[j]=t;
				}
			}
		}
	}
}
