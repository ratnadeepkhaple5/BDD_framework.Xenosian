package stepDefinationFiles;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.Assert;

import hookClasses.Hooks;
import io.cucumber.java.en.*;
import xenosian.BDD.ObjectRepository.LoginPage;
import xenosian.GenricUtility.BaseClass;

public class Login_SDF extends BaseClass{

	BaseClass base;
	public Login_SDF(BaseClass base) {
		this.base=base;
	}

	@Given("enter username and password")
	public void enter_username_and_password() {
		base.loginPage=new LoginPage(base.driver);
		base.loginPage.loginToApp(base.pUtil.getUserName(), base.pUtil.getPassword());
		
	}

	@Then("click on submit")
	public void click_on_submit() throws IOException {
		base.loginPage=new LoginPage(base.driver);
		base.loginPage.clickOnSubmit();

	}

	@Then("verify homepage title")
	public void verify_homepage_title() {
		System.out.println("homepage Verified");
	}


}
