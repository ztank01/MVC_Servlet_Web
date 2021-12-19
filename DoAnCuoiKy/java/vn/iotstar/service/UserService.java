package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.AccountModel;

public interface UserService {
	List<AccountModel> getALLSeller();
	List<AccountModel> getALLUser();
	void insert(AccountModel user);
	void delete(int id);
	void edit(AccountModel user);
	AccountModel get(int userId);
	AccountModel login(String username, String password);
	AccountModel get(String username);
}
