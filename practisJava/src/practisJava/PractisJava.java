package practisJava;

import java.util.Scanner;

 abstract class BaseJava {

		 static void test1() {	System.out.println("Parent class method");}
		 BaseJava() {
			 System.out.println("Base constructor");
		}
			
}

 
abstract class childJava extends BaseJava {

	 public void test2() {	System.out.println("child class method");}
			
	 childJava() {
		 System.out.println("Child constructor");
	}
	 
		void test4() {
			
			System.out.println("Method implemented");
			
		}
}

public class PractisJava extends childJava{
	
	  public void test3() {	System.out.println("Pactis class method");}
	
	
	public static void main (String Args[]){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the num : ");
		int i  = sc.nextInt();
		System.out.println("Enter the line : ");
		int c = sc.next().length();
		System.out.println(c);
		
		int num = 1;
		while (i > 0){
			
			num = num * i;
			i-- ;
			
		}
		System.out.println(num);
		
	}


}


