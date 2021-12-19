package vn.iotstar.model;

public class ProductModel {
	private int id;
	private String name;
	private String description;
	private double price;
	private String image;
	private int categoryID;
	private int sellerID;
	private int amount;
	private int inStock;
	private String cate_name;
	private String user;

	public ProductModel(int id, String name, String description, double price, String image, int categoryID,
			int sellerID, int amount, int inStock, String cate_name, String user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.categoryID = categoryID;
		this.sellerID = sellerID;
		this.amount = amount;
		this.inStock = inStock;
		this.cate_name = cate_name;
		this.user = user;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public ProductModel(int id, String name, String description, double price, String image, int categoryID,
			int sellerID, int amount, int inStock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.categoryID = categoryID;
		this.sellerID = sellerID;
		this.amount = amount;
		this.inStock = inStock;
	}

	public ProductModel() {
		super();
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", image=" + image + ", categoryID=" + categoryID + ", sellerID=" + sellerID + ", amount=" + amount
				+ ", inStock=" + inStock + "]";
	}

}
