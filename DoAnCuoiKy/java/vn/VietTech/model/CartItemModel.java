package vn.VietTech.model;

public class CartItemModel {

	 private int Itemid;
	 private int quantity;
	 private int unitPrice;
	 private ProductModel product;
	 private CartModel cart;
	 private int OrderId;
	 private int Status;
	public CartItemModel() {
		super();
	}
	public CartItemModel(int itemid, int quantity, int unitPrice, ProductModel product, CartModel cart, int orderId,
			int status) {
		super();
		Itemid = itemid;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.product = product;
		this.cart = cart;
		OrderId = orderId;
		Status = status;
	}
	public int getItemid() {
		return Itemid;
	}
	public void setItemid(int itemid) {
		Itemid = itemid;
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
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public CartModel getCart() {
		return cart;
	}
	public void setCart(CartModel cart) {
		this.cart = cart;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "CartItemModel [Itemid=" + Itemid + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", product="
				+ product + ", cart=" + cart + ", OrderId=" + OrderId + ", Status=" + Status + "]";
	}
	
	
}
