package Assignments;

import org.openqa.selenium.By;

public class ComplexXpathPractice extends Base {
	By containEg = By.xpath("//a[contains(text(),'Hacking')]");

	// to get text of h4 (h4 is following sibling of <a>
	// a[@href='/ethical-hacking-tutorials.html']/following-sibling::h4/a[text()='Ethical
	// Hacking']
	By followingsib = By.xpath("//a[@href='/ethical-hacking-tutorials.html']/following-sibling::h4");

	// it will return immediate parent of <a>
	By parent = By.xpath("//a[@href='/ethical-hacking-tutorials.html']/parent::div");

	// it will return all div ancestor of <a>
	By ancestor = By.xpath("//a[@href='/ethical-hacking-tutorials.html']/ancestor::div");

	// it will return body ancestor of <a>
	By ancestor1 = By.xpath("//a[@href='/ethical-hacking-tutorials.html']/ancestor::body");

	// use of and /or
	By andOR = By.xpath("//input[@type='submit' and @name='btnLogin']");

	By startsWith = By.xpath("//label[starts-with(@id,'message')]");

	// return all the input before current node
	By preceding = By.xpath("//*[@type='submit']//preceding::input");

	// return all the input after current node
	By follow = By.xpath("//*[@type='submit']//following::input");

	// all <p> elements that are inside <div> elements
	By descendant = By.xpath("//div[@class='col-md-3']/descendant::p");

	By SAPCO = By.xpath(
			"//div[@class='featured-box']/ul/li[a[text()='SAP CO'] and following-sibling::li/a[text()='SAP Payroll']]/a[text()='SAP CO']");

	By ex = By.xpath("//div[@class='featured-box']/h4[b[text()='Web']]");
	By vbScript = By.xpath("//div[@class='featured-box']/ul/li[a[text()='VBScript']]");
	By sibling = By.xpath(
			"//div[@class='featured-box']/ul/li[a[text()='VBScript']]/parent::ul/following-sibling::h4[b[text()='Test Management']]");

	// table xpaths 10 practice
	By table1 = By.xpath("//table[@id='courses_table']//tr[8]/td[4]");
	By table2 = By.xpath("//table[@id='courses_table']//tr/td[text()='Advanced Selenium']");
	By table3 = By.xpath("//table[@id='courses_table']//tr/td[text()='1517620']");
	By tableAssign= By.xpath("//table[@id='courses_table']//tr/td[text()='Intermediate']//parent::tr/following-sibling::tr/td[text()='Advanced']");

	public void locateSAP() {
		driver.navigate().to("https://demo.guru99.com/test/selenium-xpath.html");
	}

}
