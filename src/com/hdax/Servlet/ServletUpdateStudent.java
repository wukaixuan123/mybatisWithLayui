package com.hdax.Servlet;

import com.hdax.Dao.studentDao;
import com.hdax.mapper.studentMapper;
import com.hdax.pojo.Student;
import com.hdax.until.MybatisJdbcUntil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletUpdateStudent", value = "/ServletUpdateStudent")
public class ServletUpdateStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            //获取更改的各项数据(id username sex sexBoolean)
            Integer id =Integer.valueOf(request.getParameter("id"));
            String username = request.getParameter("name");
            String sex = request.getParameter("sex");
            Integer sexBoolean = Integer.valueOf(request.getParameter("sexBoolean"));
            SqlSession session =  MybatisJdbcUntil.getSqlSeeion();
            studentMapper mapper = session.getMapper(studentMapper.class);
            //创建修改的对象
            Student student = new Student();
            student.setId(id);
            student.setSex(sex);
            student.setSexBoolean(sexBoolean);
            student.setUserName(username);
            int row = mapper.updateStudent(student);
            PrintWriter out = response.getWriter();
            out.print(row);
            out.flush();
            out.close();
    }
}
