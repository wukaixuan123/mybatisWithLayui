<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2021/7/28
  Time: 下午 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:set var="path" value="${pageContext.request.contextPath}"></c:set>
    <link href="${path}/layui/css/layui.css" rel="stylesheet">
    <script type="text/javascript" src="${path}/layui/layui.js"></script>
</head>
<body>
    <form class="layui-form" lay-filter="forms">
        <input type="hidden" value="" name="id" />
        <label class="layui-form-label"></label>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" required  lay-verify="required" placeholder="输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别:</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男" checked="">
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否锁定:</label>
            <div class="layui-input-block">
                <input type="checkbox" checked="" name="sexBoolean" lay-skin="switch" lay-filter="switchTest" title="锁定" lay-text="已锁定|未锁定">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <button  type="submit" lay-filter="addStudent" lay-submit="" class="layui-btn" >提交</button>
        </div>
    </form>
</body>
<script type="text/javascript">
    var form;
    layui.use(['form','layer','jquery'],function () {
        var layer = layui.layer;
        form = layui.form;
        var $ = layui.jquery;
        //监听提交
        form.on('submit(addStudent)',function (data) {
            console.log(data.field)
            let datas = data.field;
            let c = data.sexBoolean;
            datas.sexBoolean = c=='on'? 0:1
            console.log(datas)
            //发送请求
            $.ajax({
                url:"/Layui/ServletUpdateStudent",
                type:"POST",
                data:datas,
                dataType:"JSON",
                success:function (data) {
                    //结果刷新 调用父窗口的关闭方法 并且刷新 表格数据
                    console.log(data)
                    parent.layui.table.reload('test')
                }
            })
            return false;
        })
    })
    function loadFormData(data) {
        form.val('forms',{
            id:data.id,
            name:data.userName,
            sex:data.sex,
            open:data.sexBoolean==0? true:false,
        })
    }
    function ale() {
        alert("ssss")
    }
</script>
</html>
