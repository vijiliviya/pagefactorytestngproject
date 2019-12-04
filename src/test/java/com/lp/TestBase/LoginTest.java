package com.lp.TestBase;

import org.testng.annotations.Test;

import com.lp.pages.LoginPage;

public class LoginTest {
	LoginPage loginobj;
	
	@Test
	public void logintest() throws InterruptedException
	{
		loginobj=new LoginPage();
		loginobj.logindetails();
		loginobj.verifyTitle();
		loginobj.userdetails();
		loginobj.isFileDownloaded();
	}
	

}
