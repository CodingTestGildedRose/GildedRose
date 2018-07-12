package com.gildedrose.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gildedrose.model.Item;
import com.gildedrose.model.User;
@Component
public class UserDAO {

	
	private static ArrayList<User> users;
	{
		users = new ArrayList<User>();

		users.add(new User("JohnDoe",101,"password1", "John", "Doe", "djohn@gmail.com"));
		users.add(new User("RussSmith",201, "password2","Russ", "Smith", "sruss@gmail.com"));
		users.add(new User("KateWilliams",301, "password3","Kate", "Williams", "kwilliams@gmail.com"));
	}

	/**
	 * Returns list of customers from dummy database.
	 * 
	 * @return list of customers
	 */
	public ArrayList<User> list() {
		return users;
	}

	/**
	 * Return customer object for given id from dummy database. If customer is not
	 * found for id, returns null.
	 * 
	 * @param id customer id
	 * @return customer object for given id
	 */
	public User get(Long id) {

		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	

	/**
	 * Authenticate customer object for given password and name from database. If customer is not
	 * found , returns null.
	 * 
	 * @param id customer id
	 * @return list of items
	 */
	public ArrayList<Item> authenticate(String userName, String password) {

		for (User user : users) {
			if((user.getUserName().equals(userName)) && (user.getPassword().equals(password))) {
				return ItemDAO.list();
			}
		}
		return null;
	}

	/**
	 * Create new customer in dummy database. Updates the id and insert new customer
	 * in list.
	 * 
	 * @param customer Customer object
	 * @return customer object with updated id
	 */
	public User create(User user) {
		user.setId(System.currentTimeMillis());
		users.add(user);
		return user;
	}

	/**
	 * Delete the customer object from dummy database. If customer not found for
	 * given id, returns null.
	 * 
	 * @param id the customer id
	 * @return id of deleted customer object
	 */
	public Long delete(Long id) {

		for (User user : users) {
			if (user.getId().equals(id)) {
				users.remove(user);
				return id;
			}
		}

		return null;
	}

	/**
	 * Update the customer object for given id in dummy database. If customer not
	 * exists, returns null
	 * 
	 * @param id
	 * @param customer
	 * @return customer object with id
	 */
	public User update(Long id, User _user) {

		for (User user :users) {
			if (user.getId().equals(id)) {
				user.setId(user.getId());
				users.remove(user);
				users.add(_user);
				return _user;
			}
		}

		return null;
	}

}
