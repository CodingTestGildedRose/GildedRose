package com.gildedrose.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.gildedrose.model.User;

public class UserDAOTest {

	private UserDAO userdao;
	private ItemDAO itemDao;

	@Before
	public void setUp() throws Exception {
		userdao = new UserDAO();
		itemDao = new ItemDAO();

	}

	@Test
	public void testList() {
		ArrayList<User> users = userdao.list();
		assertNotNull(users);
	}

	@Test
	public void testGet() {
		assertNotNull(userdao.get((long) 101));
	}

	@Test
	public void testAuthenticate() {
		assertNotNull(userdao.authenticate("RussSmith", "password2"));
	}

	@Test
	public void testCreate() {
		assertNotNull(userdao.create(new User("JohnSmith",401,"password3", "John", "Smith", "sjohn@gmail.com")));
	}

	@Test
	public void testDelete() {
		assertNotNull(userdao.delete((long)201));
	}

	@Test
	public void testUpdate() {
		userdao.update((long)401, new User("RobSmith",401,"password3", "Rob", "Smith", "srob@gmail.com"));
	}

}
