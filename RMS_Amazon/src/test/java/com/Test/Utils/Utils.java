package com.Test.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Utils {
	public static WebDriver driver;

	public static WebDriver WindowHandleByArray(WebDriver driver, int FrameNumberIndex) {

		Set<String> AllWindows = driver.getWindowHandles();

		System.out.println(AllWindows);

		List<String> ListOfWindows = new ArrayList<String>(AllWindows);

		return driver.switchTo().window(ListOfWindows.get(FrameNumberIndex));

	}

}
