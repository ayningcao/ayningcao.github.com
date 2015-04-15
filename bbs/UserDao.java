package com.sejian.dao;

import com.sejian.pojo.User;

public interface UserDao {

	User insert(User user);

	User update(User user);

	void delete(User user);

	User get(User user);

}
