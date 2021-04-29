package com.cmcc.common.dbcp;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alibaba.druid.pool.DruidDataSource;

public class PoolManager {
	private DruidDataSource dataSource;

    private String i_drivers = "";

    private String i_url = "";

    private String i_userName = "";

    private String i_password = "";

    /**
     * 
     * @param drivers
     *            数据库驱动
     * @param Url
     *            数据库地址
     * @param UserName
     *            数据库登陆名称
     * @param Password
     *            数据库登陆密码
     * @throws Exception
     *             建立连接池失败
     */
    /*
     * public PoolManager(String drivers, String url, String userName, String password) throws Exception {
     * Paramters para = new Paramters(); para.setDrivers(drivers); para.setUrl(url);
     * para.setUserName(userName); para.setPassword(password);
     * para.setMaxActive(Paramters.MAX_ACTIVE_DEFAULT_VALUE);
     * para.setMaxIdle(Paramters.MAX_IDLE_DEFAULT_VALUE); para.setMaxWait(Paramters.MAX_WAIT_DEFAULT_VALUE);
     * para.setOsuser(Config.getProperty("osuser")); para.setMachine(Config.getProperty("machine"));
     * para.setProgram(Config.getProperty("program"));
     * para.setMinEvictableIdleTime(Paramters.MIN_EVICTABLE_IDLE_TIME); this(para); }
     */

    /**
     * 
     * @param drivers
     *            数据库驱动
     * @param Url
     *            数据库地址
     * @param UserName
     *            数据库登陆名称
     * @param Password
     *            数据库登陆密码
     * @param maxActive
     *            最大活跃连接数
     * @param maxIdle
     *            最大闲置连接数
     * @param maxWait
     *            最大等待时间
     * @throws Exception
     *             建立连接池失败
     */
    public PoolManager(Paramters para) throws Exception
    {
        String drivers = para.getDrivers();
        String url = para.getUrl();
        String userName = para.getUserName();
        String password = para.getPassword();
        int maxActive = para.getMaxActive();
       // int maxIdle = para.getMaxIdle();
        int maxWait = para.getMaxWait();
        String osuser = para.getOsuser();
        String machine = para.getMachine();
        String program = para.getProgram();
        int MinEvictableIdleTime = para.getMinEvictableIdleTime();

        if (drivers == null)
        {
            throw new Exception("drivers is null!");
        }
        if (url == null)
        {
            throw new Exception("url is null!");
        }
        if (userName == null)
        {
            throw new Exception("userName is null!");
        }
        if (password == null)
        {
            throw new Exception("password is null!");
        }

        if (osuser == null || "".equals(osuser.trim()))
        {
            osuser = System.getProperty("user.name").toString();
        }
        if (machine == null || "".equals(machine.trim()))
        {
            machine = InetAddress.getLocalHost().getCanonicalHostName().toUpperCase();
        }
        if (program == null || "".equals(program.trim()))
        {
            program = "Default Program";
        }

        if (i_drivers.equals(drivers) && i_url.equals(url) && i_userName.equals(userName) && i_password.equals(password))
        {
            return;
        }
        i_drivers = drivers;
        i_url = url;
        i_userName = userName;
        i_password = password;

        dataSource = new DruidDataSource();
        dataSource.setDriverClassName(i_drivers);
        dataSource.setUrl(i_url);
        dataSource.setUsername(i_userName);
        dataSource.setPassword(i_password);
        dataSource.setMaxActive(maxActive);
//        dataSource.setMaxIdle(maxIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.addConnectionProperty("v$session.osuser", osuser);
        dataSource.addConnectionProperty("v$session.machine", machine);
        dataSource.addConnectionProperty("v$session.program", program);
        dataSource.setLogAbandoned(para.isLogAbandoned());
        dataSource.setRemoveAbandoned(para.isRemoveAbandoned());
        dataSource.setTestOnBorrow(para.isTestOnBorrow());
        dataSource.setTestWhileIdle(para.isTestWhileIdle());
        dataSource.setAccessToUnderlyingConnectionAllowed(true);
        if (para.getRemoveAbandonedTimeout() > 0)
            dataSource.setRemoveAbandonedTimeout(para.getRemoveAbandonedTimeout());
        if (para.getValidationQuery() != null && !"".equals(para.getValidationQuery()))
            dataSource.setValidationQuery(para.getValidationQuery());

        if (para.getTimeBetweenEvictionRunsMillis() > 0)
        {
            dataSource.setTimeBetweenEvictionRunsMillis(para.getTimeBetweenEvictionRunsMillis());
        }

        if (para.getMinEvictableIdleTimeMillis() > 0)
        {
            dataSource.setMinEvictableIdleTimeMillis(para.getMinEvictableIdleTimeMillis());
        } else
        {
            dataSource.setMinEvictableIdleTimeMillis(MinEvictableIdleTime * 1000);// 1小时
        }
        dataSource.setPoolPreparedStatements(para.isPoolPreparedStatements());
        if (para.getMaxPoolPreparedStatementPerConnectionSize() > 0)
        {
            dataSource.setMaxPoolPreparedStatementPerConnectionSize(para.getMaxPoolPreparedStatementPerConnectionSize());
        }
        if (para.getFilters() != null && !"".equals(para.getFilters()))
        {
            dataSource.setFilters(para.getFilters());
        }
    }

    /**
     * 设置最大活跃连接数，也就是实际连接数量。 <br>
     * 默认是：50
     * 
     * @param maxActiveCount
     */
    public void setMaxActive(int maxActiveCount)
    {
        dataSource.setMaxActive(maxActiveCount);
    }

    /**
     * 设置最大闲置连接数,也就是连接池中允许存在的没有被使用的最大连接数量 <br>
     * 如果闲置连接数超出该数量，将不在保留，将被close掉。 <br>
     * 默认是：10
     * 
     * @param maxMaxIdle
     */
    @SuppressWarnings("deprecation")
    public void setMaxIdle(int maxMaxIdle)
    {
        dataSource.setMaxIdle(maxMaxIdle);
    }

    /**
     * 连接数量超出最大活跃连接数时，多出连接的最大等待时间，如果多出连接的等待时间超过它，将被抛弃。 <br>
     * 默认是：10000 ms
     * 
     * @param maxMaxWait
     *            单位：ms
     */
    public void setMaxWait(int maxMaxWait)
    {
        dataSource.setMaxWait(maxMaxWait);
    }

    /**
     * 从连接池取一个数据库连接
     * 
     * @return Connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException
    {
        return dataSource.getConnection();
    }

    /**
     * 执行更新操作
     * 
     * @param sql
     * @return 执行结果
     * @throws SQLException
     */
    public int executeUpdate(String sql) throws SQLException
    {
        int rows = 0;
        Connection conn = null;
        Statement st = null;
        try
        {
            conn = getConnection();
            st = conn.createStatement();
            rows = st.executeUpdate(sql);
        } catch (SQLException ex)
        {
            throw ex;
        } finally
        {
            close(st);
            close(conn);
        }
        return rows;
    }

    public static void close(ResultSet rs)
    {
        if (rs != null)
        {
            try
            {
                rs.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement st)
    {
        if (st != null)
        {
            try
            {
                st.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection con)
    {
        if (con != null)
        {
            try
            {
                con.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
