package javapractis;

public class PractisJava {

	void test() {	System.out.println("Default method");}
	void test(int a, int b) {	System.out.println("int a, int b method");}
	void test(int a, String s) {	System.out.println("int a, String s method");}
	void test(String s, int a) {	System.out.println("String s, int a method");}
	
	public void main (String Args[]){
		
		PractisJava pj = new PractisJava();
		pj.test();
		//pj.test(10, 20);
	}
}
