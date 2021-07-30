package com.hdax.Servlet;

import com.alibaba.fastjson.JSON;
import com.hdax.Dao.studentDao;
import com.hdax.pojo.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletQueryWithId", value = "/ServletQueryWithId")
public class ServletQueryWithId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //编码
         request.setCharacterEncoding("utf-8");
         response.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");
         //获取请求参数(id)
        Integer id = Integer.valueOf(request.getParameter("id"));
        studentDao dao = new studentDao();
        Student student = dao.queryWithId(id);
        PrintWriter out = response.getWriter();
        System.out.println(student.toString());
        out.print(JSON.toJSONString(student));
        out.flush();
        out.close();
    }
}
