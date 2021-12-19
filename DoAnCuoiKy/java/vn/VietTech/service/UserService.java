package vn.VietTech.service;

import vn.VietTech.model.AccountModel;

public interface UserService {

	int CountAll();
	void insert (AccountModel user);
	AccountModel editName (String username,String  u_id);
	AccountModel editPass (String password,String  u_id);
	AccountModel getID(int int1);
	AccountModel getAllID(String id);
	AccountModel getAllId(String id, String pass);
	AccountModel getAll(String username, String pass);
}
