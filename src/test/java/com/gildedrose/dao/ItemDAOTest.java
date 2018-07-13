package com.gildedrose.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemDAOTest {
	private ItemDAO itemDao;

	@Before
	public void setUp() throws Exception {
		 itemDao = new ItemDAO();
	}

	@Test
	public void testList() {
		assertNotNull(ItemDAO.list());
	}

	@Test
	public void testBuy() {
		assertNotNull(itemDao.buy("shoes"));
	}

}
