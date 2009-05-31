/**
 * Lab4
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
 * 
 * Copyright: Fig. 8.6: Time2Test.java
 */
package edu.nu.csc615.lab4;

import java.util.Scanner;

public class Time2Test 
{
	public static void main( String args[] )
	{
		/* input buffer */
		int input;
		
		/* initialize time */
		Time2 t = new Time2();

		System.out.println("Enter the time");

		System.out.print("Hours:");
		Scanner scanner = new Scanner(System.in);
		t.setHour(scanner.nextInt());

		System.out.print("Minutes:");
		t.setMinute(scanner.nextInt());

		System.out.print("Seconds:");
		t.setSecond(scanner.nextInt());

		/* show menu in loop */
		while(true){
			System.out.println("1. Add 1 second");
			System.out.println("2. Add 1 Minute");
			System.out.println("3. Add 1 Hour");
			System.out.println("4. Add seconds");
			System.out.println("5. Exit");

			System.out.print("Choice:");
			input = scanner.nextInt();

			switch(input){
			/* add 1 second */
			case 1:
				t.setSecond(t.getSecond()+1);
				break;
			/* add 1 minute */
			case 2:
				t.setMinute(t.getMinute()+1);
				break;
			/* add 1 hour */
			case 3:
				t.setHour(t.getHour()+1);
				break;
			/* add particular seconds */
			case 4:
				System.out.print("Enter seconds to tick:");
				input = scanner.nextInt();
				t.setSecond(t.getSecond() + input);
				break;
			case 5:
				System.exit(0);

			default:
				System.out.println("Wrong choice !!");
			break;
			}
			
			/* output result */
			System.out.printf( "Universal time: %s\t Standard time: %s\n", t.toUniversalString(), t.toString());
		}

	}
}


/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
