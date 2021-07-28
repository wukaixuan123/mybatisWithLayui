package com.hdax.until;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisJdbcUntil {
    //mybatis的工具类 类似jdbc
    private static SqlSessionFactory sqlSessionFactory = null;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();//创建当前线程同步变量
    static {
        try {
            String configPath = "Student.xml";
            Reader reader = Resources.getResourceAsReader(configPath);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        MybatisJdbcUntil.sqlSessionFactory = sqlSessionFactory;
    }

    public static ThreadLocal<SqlSession> getThreadLocal() {
        return threadLocal;
    }

    public static void setThreadLocal(ThreadLocal<SqlSession> threadLocal) {
        MybatisJdbcUntil.threadLocal = threadLocal;
    }

    //创建新的sqlSession对象
    public static void newSqlSession(){
       SqlSession sqlSession =  sqlSessionFactory.openSession(true);
        threadLocal.set(sqlSession);//存储在本线程 本线程执行完成之前都可以获取
    }
    //获取session
    public static SqlSession getSqlSeeion(){
        SqlSession session = null;
       if( (session = threadLocal.get())==null){
           //没有存在变量就 创建
           newSqlSession();
           //再次获取
           session = threadLocal.get();
       }
        return session;
    }
    //提交
    public static void commitSession(){
           SqlSession session = threadLocal.get();
           if(session!=null){
               session.commit();
               session.close();
               //已经关闭的session不能存在线程里面
               threadLocal.remove();
               System.out.println(threadLocal.get());
           }
    }
    //数据回滚
    public static void rollbackAndClose() {
        //将来进行写操作，之后需要提交，我们定义的方法
        SqlSession session = threadLocal.get();
        if (session != null) {
            session.rollback();//回滚
            session.close();//释放
            //已经关闭的session不能留在local
            //所以要删除
            threadLocal.remove();
        }
    }
}
