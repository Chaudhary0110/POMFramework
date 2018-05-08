package signInAction;


import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testpractis {
	
	@BeforeClass(groups = {"regression", "sainity" , "database"})
	public void testBeforeClass() {	System.out.println("Before Class"); }
	
	@Test(groups = {"regression", "sainity"})
	public void test1() {	System.out.println("regression & sainity"); }
	
	@Test(groups = {"sainity", "database"})
	public void test2() {	System.out.println("database & sainity"); }
	
	@Test(groups = {"regression"})
	public void test3() {	System.out.println("regression"); }
	
	@Test(groups = {"sainity"})
	public void test4() {	System.out.println("sainity");}
	
	@Test(dependsOnMethods = {"test1", "test2"})
	public void depends() {	System.out.println("testing Dependson");}
	
	@Test (groups = {"sainity"})
	@Parameters ({"userName","passWord"})
	public void testingDataProvider(@Optional("user") String userName, @Optional("user") String passWord){
			
		System.out.println("userName : "+userName);
		System.out.println("passWord : "+passWord);
		
	}
	
	@Test(enabled = false)
	public void enabletest() {	System.out.println("testing enable disable");}
	
}
