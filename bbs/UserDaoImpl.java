package com.sejian.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sejian.dao.UserDao;
import com.sejian.pojo.User;

public class UserDaoImpl implements UserDao {

	private static final String INSERT_USER = "INSERT INTO sejian.user VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW(), ?, 1, 0, ?, ?)";

	private static final String UPDATE_USER = "";

	private static final String QUERY_USER_BY_ID = "SELECT * FROM sejian.user WHERE id=?";

	private static final String QUERY_USER_BY_ID_PWD = "SELECT * FROM sejian.user WHERE id=? AND password=?";

	private static final String DELETE_USER = "DELETE sejian.user WHERE id=?";

	private JdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}

	@Override
	public User insert(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User get(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
