package com.cmcc.common.dbcp;

import java.util.Hashtable;

public class PoolFactory {
	private static final String DEFAULT_POOL_NAME = "DEFAULT_POOL_NAME";

	private static Hashtable<String, PoolManager> poolMap = new Hashtable<String, PoolManager>();

	/**
	 * ȡȱʡ���ݿ����ӳع�����
	 * @return
	 */
	synchronized public static PoolManager getPool() {
		return getPool(DEFAULT_POOL_NAME);
	}

	/**
	 * ȡָ�����ݿ����ӳع�����
	 * @param poolName
	 * @return
	 */
	synchronized public static PoolManager getPool(String poolName) {
		Object obj = poolMap.get(poolName);
		return obj == null ? null : (PoolManager) obj;
	}

	/**
	 * ����ȱʡ���ݿ����ӳ� 
	 * @param para
	 * @throws Exception
	 */
	synchronized public static void buildPool(Paramters para) throws Exception {
		buildPool(DEFAULT_POOL_NAME, para);
	}

	/**
	 * ����ָ���������ݿ����ӳ� 
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
