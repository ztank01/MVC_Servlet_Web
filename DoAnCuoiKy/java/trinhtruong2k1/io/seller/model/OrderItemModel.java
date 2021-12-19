package trinhtruong2k1.io.seller.model;

public class OrderItemModel {
	private int id;
	private int quantity;
	private int unitPrice;
	private int productId;
	private int orderId;
	private int status;
	public OrderItemModel() {
		super();
	}
	public OrderItemModel(int id, int quantity, int unitPrice, int productId, int orderId, int status) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.productId = productId;
		this.orderId = orderId;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "OrderItemModel [id=" + id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", productId="
				+ productId + ", orderId=" + orderId + ", status=" + status + "]";
	}
}
