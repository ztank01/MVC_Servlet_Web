package vn.iotstar.model;

public class OrderItemModel {

	private int itemId;
	private int quantity;
	private int unitPrice;
	private int productId;
	private int orderId;
	private int status;
	private String proName;
	private String userName;

	public OrderItemModel(int itemId, int quantity, int unitPrice, int productId, int orderId, int status,
			String proName, String userName) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.productId = productId;
		this.orderId = orderId;
		this.status = status;
		this.proName = proName;
		this.userName = userName;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public OrderItemModel(int itemId, int quantity, int unitPrice, int productId, int orderId, int status) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.productId = productId;
		this.orderId = orderId;
		this.status = status;
	}

	public OrderItemModel() {
		super();
	}

}
