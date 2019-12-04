package com.lp.TestBase;

import org.testng.annotations.Test;

import com.lp.baseclass.BaseClass;

public class BaseTest {
	BaseClass baseobj;
	@Test
	public void openbrowesertest() {
		baseobj=new BaseClass();
		baseobj.openbrowser();
	}

}
