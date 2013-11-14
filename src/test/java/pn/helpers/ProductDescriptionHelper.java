package pn.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pn.components.ProductDescription;


public class ProductDescriptionHelper {
	
private static ProductDescription page;


	
	public static void setProductDescriptionHelper(ProductDescription productPage){
		page = productPage;
	}

	public static Map<String, String> getInfoByProduct() {
		Map<String, String> map = new HashMap<>();
		String key = null;
		String value = null;
		int i = 0;
		while (true) {
			key = page.getInfoKey().get(i).getText();
			value = page.getInfoValue().get(i).getText();
			map.put(key, value);
			if (i != page.getInfoKey().size() - 1)
				i++;
			else
				break;
		}
		return map;

	}
	
	public static List<String> getInfoByProductToList() {
		List<String> list = new ArrayList<>();
		int i = 0;
		while (true) {
			String str = page.getInfoKey().get(i).getText().toLowerCase().trim() + " " + page.getInfoValue().get(i).getText().toLowerCase().trim();
			list.add(str);
			if (i != page.getInfoKey().size() - 1)
				i++;
			else
				break;
		}
		return list;

	}
	
	

	
}
