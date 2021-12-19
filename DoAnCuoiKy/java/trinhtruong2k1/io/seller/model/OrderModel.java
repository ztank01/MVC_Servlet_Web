package trinhtruong2k1.io.seller.model;

import java.sql.Date;

public class OrderModel {
	private int orderId;
	private int userId;
	private Date orderDate;
	private int status;
	public OrderModel() {
		super();
	}
	public OrderModel(int orderId, int userId, Date orderDate, int status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", status=" + status
				+ "]";
	}
	

}
