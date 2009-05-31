package test;

public class Test {
	
	public static void test(int[] test){
		test[0]=1;
	}
	
	public static void main(String test[]){
		int a[]={0,1,2,3,4,5};
		System.out.print(a[0]);
		test(a);
		System.out.print(a[0]);
	}

}
