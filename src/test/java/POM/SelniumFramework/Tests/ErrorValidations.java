package POM.SelniumFramework.Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import POM.SelniumFramework.TestComponents.BaseTest;
import dev.failsafe.internal.util.Assert;


public class ErrorValidations extends BaseTest {

	@Test
	
	public void submitorder( ) throws IOException{
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		landingpage.LoginApplication("uniquesumanth143@gmail.com", "Suman@1234");
		assertEquals("Incorrect email or password." ,landingpage.geterrormessage());

}}
