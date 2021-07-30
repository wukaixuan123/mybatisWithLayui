<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2021/7/26
  Time: 下午 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Layui表格</title>
    <c:set var="path" value="${pageContext.request.contextPath}"></c:set>
    <link href="${path}/layui/css/layui.css" rel="stylesheet">
  </head>
  <body>
    <form class="layui-form" lay-filter="forms">
      <div class="layui-form-item">
          <lable class="layui-form-label">姓名:</lable>
        <div class="layui-input-inline">   <input type="text" name="search" placeholder="请输入" autocomplete="off" class="layui-input" width="100px">
        </div>
        <button type="submit" class="layui-btn layui-btn-primary" lay-filter="serach" lay-submit="" >搜索数据</button>
      </div>
    </form>
    <table id="test" class="layui-hide" lay-filter="table"></table>
    <script type="text/javascript" src="${path}/layui/layui.js"></script>
    <script type="text/javascript" src="${path}/web.hdax/js/LoadTable.js"></script>
    <script type="text/html" id="titleTpl">
      <a class="layui-btn layui-btn-xs" lay-event="bianji">编辑</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
  <script type="text/html" id="tplDemo">
     <input type="checkbox" checked/>
  </script>
<%--  //表格工具行--%>
  <script type="text/html" id="toolbradDemo">
    <input type="button"  class="layui-btn layui-btn-sm" lay-event="add" value="新增学生">
    <input type="button"  class="layui-btn layui-btn-sm" lay-event="showTool">
</script>
  </body>
</html>
