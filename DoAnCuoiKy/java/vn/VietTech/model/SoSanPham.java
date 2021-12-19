package vn.VietTech.model;

public class SoSanPham {
	private int cate_id;
	private int sp;
	public SoSanPham() {
		super();
	}
	public SoSanPham(int cate_id, int sp) {
		super();
		this.cate_id = cate_id;
		this.sp = sp;
	}
	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
	public int getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	@Override
	public String toString() {
		return "SoSanPham [cate_id=" + cate_id + ", sp=" + sp + "]";
	}
	
}
