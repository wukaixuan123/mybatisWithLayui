package com.hdax.Servlet;

import com.hdax.Dao.studentDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletDel", value = "/ServletDel")
public class ServletDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                //编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //获取删除的Id
        Integer id = Integer.valueOf(request.getParameter("stuId"));
        //调用Dao层 删除数据
        studentDao dao = new studentDao();
        int row = dao.delStudentWithId(id);
        if(row==1){
            PrintWriter out = response.getWriter();
            out.print(row);
            out.flush();
            out.close();
        }
    }
}
