// Fig. 8.6: Time2Test.java
// Overloaded constructors used to initialize Time2 objects.
package edu.nu.csc615.lab4;

import java.util.Scanner;

public class Time2Test 
{
	public static void main( String args[] )
	{
		int input;
		Time2 t = new Time2();

		System.out.println("Enter the time");

		System.out.print("Hours:");
		Scanner scanner = new Scanner(System.in);
		t.setHour(scanner.nextInt());

		System.out.print("Minutes:");
		t.setMinute(scanner.nextInt());

		System.out.print("Seconds:");
		t.setSecond(scanner.nextInt());

		while(true){
			System.out.println("1. Add 1 second");
			System.out.println("2. Add 1 Minute");
			System.out.println("3. Add 1 Hour");
			System.out.println("4. Add seconds");
			System.out.println("5. Exit");

			System.out.print("Choice:");
			input = scanner.nextInt();

			switch(input){
			case 1:
				t.setSecond(t.getSecond()+1);
				break;
			case 2:
				t.setMinute(t.getMinute()+1);
				break;
			case 3:
				t.setHour(t.getHour()+1);
				break;
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
