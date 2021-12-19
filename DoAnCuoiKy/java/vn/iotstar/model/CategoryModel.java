package vn.iotstar.model;

public class CategoryModel {
private int cate_id;
private String cate_name;
private String cate_icon;


public CategoryModel() {
	super();
}


public int getCate_id() {
	return cate_id;
}


public void setCate_id(int cate_id) {
	this.cate_id = cate_id;
}


public String getCate_name() {
	return cate_name;
}


public void setCate_name(String cate_name) {
	this.cate_name = cate_name;
}


public String getCate_icon() {
	return cate_icon;
}


public void setCate_icon(String cate_icon) {
	this.cate_icon = cate_icon;
}


public CategoryModel(int cate_id, String cate_name, String cate_icon) {
	super();
	this.cate_id = cate_id;
	this.cate_name = cate_name;
	this.cate_icon = cate_icon;
}


@Override
public String toString() {
	return "CategoryModel [cate_id=" + cate_id + ", cate_name=" + cate_name + ", cate_icon=" + cate_icon + "]";
}


}
