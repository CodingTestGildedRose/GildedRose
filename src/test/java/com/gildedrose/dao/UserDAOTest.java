package com.gildedrose.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.gildedrose.model.Item;
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
		User user =userdao.get((long) 101);
		assertNotNull(user);
		assertEquals(user.getUserName(),"JohnDoe");
	}

	@Test
	public void testAuthenticate() {
		ArrayList<Item> items =userdao.authenticate("RussSmith", "password2");
		assertNotNull(items);
		assertEquals(items.get(0).getName(), "shoes");
	}

	@Test
	public void testCreate() {
		User user =userdao.create(new User("JohnSmith",401,"password3", "John", "Smith", "sjohn@gmail.com"));
		assertNotNull(user);
		assertEquals(user.getFirstName(), "John");
	}

	@Test
	public void testDelete() {
		assertNotNull(userdao.delete((long)201));
	}

	@Test
	public void testUpdate() {
		User user =userdao.update((long)101, new User("RobSmith",101,"password3", "Rob", "Smith", "srob@gmail.com"));
		assertNotNull(user);
		assertEquals(user.getFirstName(),"Rob");
	}

}
