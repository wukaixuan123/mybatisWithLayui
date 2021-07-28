package com.hdax.Servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hdax.Dao.studentDao;
import com.hdax.until.pageConfig;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletGetUser", value = "/ServletGetUser")
public class ServletGetUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            //获取页码
            int page = Integer.valueOf(request.getParameter("page"));
            //获取每页个数
            int limitNumber = Integer.valueOf(request.getParameter("limitNumber"));
            //获取姓名
            String name = request.getParameter("names")!=null&&!request.getParameter("names").equals("names")? request.getParameter("names"):null;
        studentDao student = new studentDao();
        pageConfig pages = student.getPage(page, limitNumber,name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",pages.getCount());
        jsonObject.put("data",pages.getList());
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(jsonObject));
        out.flush();
        out.close();
    }
}
