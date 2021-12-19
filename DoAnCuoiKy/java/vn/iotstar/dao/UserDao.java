package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.AccountModel;

public interface UserDao {
	List<AccountModel> getALLSeller();
	List<AccountModel> getALLUser();
	void insert(AccountModel user);
	void delete(int id);
	void edit(AccountModel user);
	AccountModel get(int userId);
	AccountModel get(String username);
}
