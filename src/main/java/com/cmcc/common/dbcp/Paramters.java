package com.cmcc.common.dbcp;

public class Paramters {
	public static final int MAX_ACTIVE_DEFAULT_VALUE = 50;

	public static final int MAX_IDLE_DEFAULT_VALUE = 10;

	public static final int MAX_WAIT_DEFAULT_VALUE = 10000;

	public static final int MIN_EVICTABLE_IDLE_TIME = 3600;

	private String drivers = null;

	private String url = null;

	private String userName = null;

	private String password = null;

	private int maxActive = MAX_ACTIVE_DEFAULT_VALUE;

	private int maxIdle = MAX_IDLE_DEFAULT_VALUE;

	private int maxWait = MAX_WAIT_DEFAULT_VALUE;

	private String osuser = null;

	private String machine = null;

	private String program = null;

	private int minEvictableIdleTime = MIN_EVICTABLE_IDLE_TIME;

	private boolean removeAbandoned = false;
	private int removeAbandonedTimeout = 300;
	private boolean logAbandoned = false;
	private String validationQuery;
	private boolean testOnBorrow = true;
	private boolean testWhileIdle = false;
	private int timeBetweenEvictionRunsMillis;
	private int minEvictableIdleTimeMillis;
	private boolean poolPreparedStatements = false;
	private int maxPoolPreparedStatementPerConnectionSize;
	private String filters;

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public int getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public boolean isPoolPreparedStatements() {
		return poolPreparedStatements;
	}

	public void setPoolPreparedStatements(boolean poolPreparedStatements) {
		this.poolPreparedStatements = poolPreparedStatements;
	}

	public int getMaxPoolPreparedStatementPerConnectionSize() {
		return maxPoolPreparedStatementPerConnectionSize;
	}

	public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
		this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
	}

	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public boolean isLogAbandoned() {
		return logAbandoned;
	}

	public void setLogAbandoned(boolean logAbandoned) {
		this.logAbandoned = logAbandoned;
	}

	public boolean isRemoveAbandoned() {
		return removeAbandoned;
	}

	public void setRemoveAbandoned(boolean removeAbandoned) {
		this.removeAbandoned = removeAbandoned;
	}

	public int getRemoveAbandonedTimeout() {
		return removeAbandonedTimeout;
	}

	public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public String getDrivers() {
		return drivers;
	}

	public void setDrivers(String drivers) {
		this.drivers = drivers;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getOsuser() {
		return osuser;
	}

	public void setOsuser(String osuser) {
		this.osuser = osuser;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public int getMinEvictableIdleTime() {
		return minEvictableIdleTime;
	}

	public void setMinEvictableIdleTime(int minEvictableIdleTime) {
		this.minEvictableIdleTime = minEvictableIdleTime;
	}
}
