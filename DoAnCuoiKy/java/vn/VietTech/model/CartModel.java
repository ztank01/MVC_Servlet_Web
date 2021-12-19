package vn.VietTech.model;

import java.util.Date;

public class CartModel {

	 private int orderid;
	 private AccountModel buyer;
	 private Date buyDate;
	 private int Status;
	public CartModel() {
		super();
	}
	public CartModel(int orderid, AccountModel buyer, Date buyDate, int status) {
		super();
		this.orderid = orderid;
		this.buyer = buyer;
		this.buyDate = buyDate;
		Status = status;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public AccountModel getBuyer() {
		return buyer;
	}
	public void setBuyer(AccountModel buyer) {
		this.buyer = buyer;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "CartModel [orderid=" + orderid + ", buyer=" + buyer + ", buyDate=" + buyDate + ", Status=" + Status
				+ "]";
	}
	 
}
