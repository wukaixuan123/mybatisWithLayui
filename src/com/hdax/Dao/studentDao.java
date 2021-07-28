package com.hdax.Dao;

import com.hdax.mapper.studentMapper;
import com.hdax.pojo.Student;
import com.hdax.until.MybatisJdbcUntil;
import com.hdax.until.pageConfig;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class studentDao {
    static SqlSessionFactory factory = null;
   static SqlSession session = null;
    //获取数据总量
    public int countPage(){
        SqlSession sessions = MybatisJdbcUntil.getSqlSeeion();
      studentMapper studentMapper  = sessions.getMapper(studentMapper.class);
      int count = studentMapper.queryCount();
      return count;
    }

    public static void main(String[] args) {
        studentDao studentMapper = new studentDao();
    }
    //执行分页查询
    public pageConfig getPage(int pageNumber,int limit,String name){
        studentMapper studentMapper  = MybatisJdbcUntil.getSqlSeeion().getMapper(studentMapper.class);
        pageConfig pageConfig = new pageConfig(pageNumber,limit,countPage());
//        studentMapper stu = MybatisJdbcUntil.getSqlSeeion().getMapper(studentMapper.class);
        //分页查询出数据
        HashMap map = new HashMap();
        map.put("page",pageConfig);
        map.put("name",name);
       List<Student> listStu =  studentMapper.queryAllLimit(map);
       pageConfig.setList(listStu);
        MybatisJdbcUntil.commitSession();
        return pageConfig;
    }
    //删除
    public int delStudentWithId(int id){
     //获取session
        SqlSession session = MybatisJdbcUntil.getSqlSeeion();
       studentMapper studentMapper =  session.getMapper(studentMapper.class);
        int row =studentMapper.delStudentWithId(id);
        MybatisJdbcUntil.commitSession();
        return row;
    }
}
