package com.finskul.hbase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HbaseClientTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConnect() {
		HbaseClient.connect();
		
	}
	
	@Test
	public void testScan()
	{
		HbaseClient.scanTable();
	}
	
	@Test
	public void testPut()
	{
		HbaseClient.putSomeRows();
	}
	
	@Test
	public void testJdbc()
	{
		try {
			JdbcClient.connect();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
