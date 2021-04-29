package com.cmcc.common.dbcp;

import java.util.Hashtable;

public class PoolFactory {
	private static final String DEFAULT_POOL_NAME = "DEFAULT_POOL_NAME";

	private static Hashtable<String, PoolManager> poolMap = new Hashtable<String, PoolManager>();

	/**
	 * 取缺省数据库连接池管理类
	 * @return
	 */
	synchronized public static PoolManager getPool() {
		return getPool(DEFAULT_POOL_NAME);
	}

	/**
	 * 取指定数据库连接池管理类
	 * @param poolName
	 * @return
	 */
	synchronized public static PoolManager getPool(String poolName) {
		Object obj = poolMap.get(poolName);
		return obj == null ? null : (PoolManager) obj;
	}

	/**
	 * 建立缺省数据库连接池 
	 * @param para
	 * @throws Exception
	 */
	synchronized public static void buildPool(Paramters para) throws Exception {
		buildPool(DEFAULT_POOL_NAME, para);
	}

	/**
	 * 建立指定名称数据库连接池 
	 * @param poolName
	 * @param para
	 * @throws Exception
	 */
	synchronized public static void buildPool(String poolName, Paramters para)
			throws Exception {
		try {
			PoolManager pool = new PoolManager(para);
			pool.getConnection().close();
			if (poolMap.get(poolName) != null) {
				poolMap.remove(poolName);
			}
			poolMap.put(poolName, pool);
		} catch (Exception e) {
			
		}
	}
}
