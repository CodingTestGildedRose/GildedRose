package com.gildedrose.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gildedrose.dao.ItemDAO;
import com.gildedrose.dao.UserDAO;
import com.gildedrose.model.Item;
import com.gildedrose.model.User;

@RestController
public class UserRestController {

	@Autowired
	private UserDAO UserDAO;

	@Autowired
	private ItemDAO ItemDAO;

	@GetMapping("/Users")
	public List getUsers() {
		return UserDAO.list();
	}

	@GetMapping("/Users/{id}")
	public ResponseEntity getUser(@PathVariable("id") Long id) {

		User User = UserDAO.get(id);
		if (User == null) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(User, HttpStatus.OK);
	}

	@RequestMapping(value = "/Authenticate", params = { "username", "password" })
	public ResponseEntity getUser(@RequestParam("username") String userName,
			@RequestParam("password") String password) {

		ArrayList<Item> items = UserDAO.authenticate(userName, password);
		if (items == null) {
			return new ResponseEntity("Authentication failed ", HttpStatus.NOT_FOUND);
		}
		if (items.isEmpty()) {
			return new ResponseEntity("Empty Inventory. Not possible to buy ", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(items, HttpStatus.OK);
	}

	@RequestMapping(value = "/Buy", params = { "name" })
	public ResponseEntity getUser(@RequestParam("name") String name) {

		String itemName = ItemDAO.buy(name);
		if (itemName == null) {
			return new ResponseEntity("item not found ", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(itemName, HttpStatus.OK);
	}

	@PostMapping(value = "/Users")
	public ResponseEntity createUser(@RequestBody User User) {

		UserDAO.create(User);

		return new ResponseEntity(User, HttpStatus.OK);
	}

	@DeleteMapping("/Users/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {

		if (null == UserDAO.delete(id)) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/Users/{id}")
	public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User User) {

		User = UserDAO.update(id, User);

		if (null == User) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(User, HttpStatus.OK);
	}

}
