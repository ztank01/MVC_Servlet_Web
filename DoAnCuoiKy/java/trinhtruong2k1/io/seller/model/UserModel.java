package trinhtruong2k1.io.seller.model;

public class UserModel {
	private int id;
	private String uname;
	private String password;
	private int seller;
	private int admin;
	public UserModel() {
		super();
	}
	public UserModel(int id, String uname, String password, int seller, int admin) {
		super();
		this.id = id;
		this.uname = uname;
		this.password = password;
		this.seller = seller;
		this.admin = admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSeller() {
		return seller;
	}
	public void setSeller(int seller) {
		this.seller = seller;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", uname=" + uname + ", password=" + password + ", seller=" + seller + ", admin="
				+ admin + "]";
	}
	
}
