package com.kodgemisi;

import com.kodgemisi.usermanagement.User;
import com.kodgemisi.usermanagement.UserDao;
import com.kodgemisi.usermanagement.UserDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		final UserDao userDao = new UserDaoImpl();
		logger.info("Generating users...");
		UserGenerator.generate(userDao);
		logger.info("Generating users: DONE.");
		logger.info("Listing first 100 users:");
		userDao.findAll().stream().limit(100).map(User::toString).forEach(logger::info);
	}
}
