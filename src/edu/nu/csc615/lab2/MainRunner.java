package edu.nu.csc615.lab2;

public class MainRunner {
	
	/* define lines */ 
	public final static int lines = 10;

	public static void main(String[] args) {	
		
		/* loop lines */
		for (int line=1;line<=lines;line++){
			
			/* 1st triangle loop */
			for(int t1=0;t1<line;t1++)
				System.out.print("* ");
			
			/* 1st space loop */
			for(int s1=lines;s1>=line;s1--)
				System.out.print(" ");
			
			/* 2nd triangle */
			for(int t2=lines;t2>=line;t2--)
				System.out.print("* ");
			
			/* 2nd space */
			for(int s2=0;s2<line;s2++)
				System.out.print("  ");
			
			/* 3rd triangle */
			for(int t3=lines;t3>=line;t3--)
				System.out.print("* ");
			
			/* 3rd space */
			for(int s3=lines;s3>=line;s3--)
				System.out.print(" ");
			
			/* 4th triangle */
			for(int t4=0;t4<=line;t4++)
				System.out.print("* ");
			
			/* done */
			System.out.println("");			
		}
	}
}
