package ex5;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ex4.HtmlReadGuiLambda;

public class GuiHtmlReadTest {

	@Test
	public void test01() {
	
		Assert.assertEquals(HtmlReadGuiLambda.isValidURL("http://www.bbc.co.uk/news/uk-scotland-scotland-business-38536108"),true);
	}
	
	/**
	 * Url is correct
	 */
	@Test
	public void test02() {
	
		Assert.assertEquals(HtmlReadGuiLambda.isValidURL("http://www.thetimes.co.uk/edition/comment/population-growth-is-stifling-our-green-and-pleasant-land-6jsndv6tr"),true);
	}
	
	/**
	 * Url is incorrect
	 */
	@Test
	public void test03() {
	
		Assert.assertEquals(HtmlReadGuiLambda.isValidURL("tmtp://www.thetimes.co.uk/edition/comment/population-growth-is-stifling-our-green-and-pleasant-land-6jsndv6tr"),false);
	}

}
