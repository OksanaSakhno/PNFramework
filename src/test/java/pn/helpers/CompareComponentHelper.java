package pn.helpers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static pn.helpers.BaseTestHelper.*;
import pn.components.CompareComponent;
import pn.components.Component;
import pn.components.ProductDescription;
import pn.pages.ProductsListPage;

public class CompareComponentHelper {

	private static ProductDescription prodDescriptComp;
	private static ProductsListPage page;
	public static Map<String, String> map1 = new HashMap<String, String>();
	public static Map<String, String> map2 = new HashMap<String, String>();
	static boolean flag;

	
	public static void setCompareComponentHelper(ProductsListPage page){
		CompareComponentHelper.page = ProductsListPage.getProductListPage();
	}
	
	public static Map<String, String> getInfoAboutProduct(ProductDescription prodDescriptComp) {
		String key = null;
		String value = null;
		Map<String, String> mapInfo = new HashMap<>();
		int index = 0;
		while (true) {
			key = prodDescriptComp.getInfoKey().get(index).getText();
			value = prodDescriptComp.getInfoValue().get(index).getText();
			mapInfo.put(key, value);
			if (index != prodDescriptComp.getInfoKey().size() - 1)
				index++;
			else
				break;
		}
		return mapInfo;
	}
	
	
	public static ProductsListPage openDescriptionProducts(double first, double second){
		if(isCorrectGoods(first, second)){
		prodDescriptComp = page.getProductList().openDescriptByProductWithCompare(first);
		map1 = cowertInfoAboutProductToMap();
		page.getProductList().openDescriptByProductWithCompare(second);
		map2 = cowertInfoAboutProductToMap();
		return PageFactory.initElements(Component.getDriver(), ProductsListPage.class);
		}else
			Assert.fail("Invalid input data!");
		return null;
	}
	
	
	public static boolean isCorrectGoods(double first, double second) {
		boolean flag = true;
		if (first == -1 || second == -1) {
			log("<b><h3>"
					+ "Only one parameter for comparing is entered! Enter number of the second goods!"
					+ "</h3></b>");
			flag = false;
		} else if (first <= 0 || second <= 0) {
			log("<b><h3>" + "Incorrect numbers of goods!" + "</h3></b>");
			flag = false;
		} else if (first > 20 || second > 20) {
			log("<b><h3>"
					+ "You can compare the goods on the first page!Goods on page at most 20."
					+ "</h3></b>");
			flag = false;
		}
		return flag;
	}
	
	public static Map<String, String> cowertInfoAboutProductToMap(){
		Map<String, String> map = new HashMap<String, String>();
		map = getInfoAboutProduct(prodDescriptComp);
		Component.getDriver().navigate().back();
		try {Thread.sleep(2500);} catch (InterruptedException e) {}
		return map;
		
	}
	
	public static CompareComponent checkDescriptionOfProducts(){
		Set <String> differentKey = new HashSet<String>();
		compareTwoProducts(map1, map2);
		differentKey = compareFeatures(map1, map2);
		checkDifferentKey(differentKey);
		return PageFactory.initElements(Component.getDriver(), CompareComponent.class);
	}
	
	
	
	public static boolean compareTwoProducts(Map<String, String > map1, Map<String, String > map2){
		flag = true;
		Map<String, Integer> mapFull = new HashMap<>();
		for(WebElement keyRows : page.getCompareComp().getKeyRow()){
			mapFull.put(keyRows.getText(), 0);
		}
		flag = compareMaps(mapFull, map1);
		Assert.assertTrue("Not all information on the first goods is present at the comparing table", flag);
		flag = compareMaps(mapFull, map2);
		Assert.assertTrue("Not all information on the second goods is present at the comparing table", flag);	
		return flag;
	}
	
	public static boolean compareMaps(Map<String, Integer > mapFull, Map<String, String > map){
		for (Entry<String, String> entry : map.entrySet()) {
			if(!mapFull.containsKey(entry.getKey())){
				return false;
			}
		}
		return true;
	}
	
	public static Set<String> compareFeatures(Map<String, String> map1,
			Map<String, String> map2) {
		flag = true;
		Set<String> set = new HashSet<>();
		for (String firstKey : map1.keySet()) {
			for (String secondKey : map2.keySet()) {
				if (firstKey.equals(secondKey)) {
					if (!map1.get(firstKey).equals(map2.get(secondKey))) {
						set.add(firstKey);
					}
				}
				if (!map1.containsKey(secondKey)){
					set.add(secondKey);
				}
				if (!map2.containsKey(firstKey)){
					set.add(firstKey);
				}
			}
		}
		return set;
	}
	
	public static void checkDifferentKey(Set<String> output){
		flag = true;
		for(WebElement key : page.getCompareComp().getDifferentValueRow()){
			if(!output.contains(key.getText())){
				System.out.println(key.getText());
				flag = false;
			}
		}
		if(page.getCompareComp().getDifferentValueRow().size() != output.size())
			flag = false;
		Assert.assertTrue("Distinctive characteristics of goods are identified incorrectly!", flag);
	}
	
	
	public static CompareComponent openComparePage(){
		page.getProductList().openCompare();
		return PageFactory.initElements(Component.getDriver(), CompareComponent.class);
	}
	
	}


