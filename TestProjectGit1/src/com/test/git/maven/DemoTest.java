package com.test.git.maven;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class DemoTest {
	WebDriver driver;
	
	@Test
	public void nameGit() {
		System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.Jdk14Logger");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/All-drivers/chromedriver.exe");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("start-maximized");

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.firstcry.com/");
		driver.close();
		driver.quit();
	}
}
