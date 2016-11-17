package com.finskul.hbase;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

public class HbaseClient {
	
	

	public static void connect()
	{
		Configuration hadoopConf = getConfig();
		Configuration hConf = HBaseConfiguration.create(hadoopConf);
		hConf.set("hbase.zookeeper.quorum", "bonsai-phoenix");
		hConf.setInt("hbase.zookeeper.property.clientPort", 2181);

		/*try {
			HTable hTable = new HTable(hConf, "client");
			System.out.println(hTable.getTableDescriptor().toString());
			hTable.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public static void scanTable()
	{
		Configuration hadoopConf = getConfig();
		Configuration hConf = HBaseConfiguration.create(hadoopConf);
		hConf.set("hbase.zookeeper.quorum", "bonsai-phoenix");
		hConf.setInt("hbase.zookeeper.property.clientPort", 2181);
		HTable hTable = null;
		try {
			hTable =  new HTable(hConf, "orders");
			System.out.println(hTable.getTableDescriptor().toString());
			Scan scan = new Scan();
			ResultScanner scanner = hTable.getScanner(scan);
			Iterator<Result> resultIterator = scanner.iterator();
			while(resultIterator.hasNext())
			{
				Result result = resultIterator.next();
				System.out.println(new String(result.getValue("client".getBytes(), "name".getBytes())));
				System.out.println(new String(result.getRow()));
			}
			} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			if(hTable!=null)
				try {
					hTable.close();
				} catch (IOException e) {
							e.printStackTrace();
				}
		}
		
	}
	
	public static void putSomeRows()
	{
		Configuration hadoopConf = getConfig();
		Configuration hConf = HBaseConfiguration.create(hadoopConf);
		hConf.set("hbase.zookeeper.quorum", "bonsai-phoenix");
		hConf.setInt("hbase.zookeeper.property.clientPort", 2181);
		HTable hTable = null;
		try {
			hTable =  new HTable(hConf, "orders");
			System.out.println(hTable.getTableDescriptor().toString());
			Put put = new Put("jana_123".getBytes());
			put.add("client".getBytes(), "name".getBytes(), "jana".getBytes());
			hTable.put(put);
			hTable.flushCommits();
			
			} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			if(hTable!=null)
				try {
					hTable.close();
				} catch (IOException e) {
							e.printStackTrace();
				}
		}
	}
	public static void newConnect()
	{
		
	}
	
	public static Configuration getConfig() {
		String hdfsPath = "hdfs://" + "bonsai-master" + ":" + "9000";
		Configuration conf = new Configuration();
		conf.set("fs.default.name", hdfsPath);
		// If you dont configure this then you will be using the defaults
		/*conf.set("dfs.replication", "3");
		conf.set("dfs.blocksize", "4K");*/
		return conf;
	}
}
