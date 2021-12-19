package vn.VietTech.dao;

import vn.VietTech.model.AccountModel;
import vn.VietTech.model.ProductModel;

public interface UserDao {

	int CountAll();
	void insert (AccountModel user);
	AccountModel editName (String username, String u_id);
	AccountModel editPass (String password, String u_id);
	AccountModel getID(int int1);
	AccountModel getAllId(String id, String pass);
	AccountModel getAllID(String id);
	AccountModel getAll(String username, String pass);

}
