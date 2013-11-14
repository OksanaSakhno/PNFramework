package pn.pages;


public class Product {
	private String name;
	private int price;
	private String description;
	private String href;
	
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getHref() {
		return href;
	}
	
	public Product withName(String name) {
		this.name = name;
		return this;
	}

	public Product withPrice(int price) {
		this.price = price;
		return this;
	}

	public Product wihtDescription(String description) {
		this.description = description;
		return this;
	}

	public Product wihtHref(String href) {
		this.href = href;
		return this;
	}

		
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", href=" + href + "]";
	}
	

}
