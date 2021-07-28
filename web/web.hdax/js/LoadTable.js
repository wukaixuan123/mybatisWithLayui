// layui.use(['table','laypage'], function(){
//     var table = layui.table;
//     var LayPage = layui.laypage;
//     //第一个实例
//     table.render({
//         // elem: '#test'
//         // ,url: '/Layui/web.hdax/data/data' //数据接口
//         // ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
//         //     // layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
//         //     //,curr: 5 //设定初始在第 5 页
//         //     // ,groups: 1 //只显示 1 个连续页码
//         //     count: 30,
//         //     click:function () {
//         //         alert(12)
//         //     }
//         // } //开启分页
//         // ,cols: [[ //表头  //列
//         //     {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}  //field 字段
//         //     ,{field: 'username', title: '用户名', width:80}
//         //     ,{field: 'sex', title: '性别', width:80, sort: true}
//         //     ,{field: 'city', title: '城市', width:80}
//         //     ,{field: 'sign', title: '签名', width: 177}
//         //     ,{field: 'experience', title: '积分', width: 80, sort: true}
//         //     ,{field: 'score', title: '评分', width: 80, sort: true}
//         //     ,{field: 'classify', title: '职业', width: 80}
//         //     ,{field: 'wealth', title: '财富', width: 135, sort: true}
//         // ]]
//         // ,count:30,
//         // limit:5,
//         // limits:[10,21,45],
//         // request:{
//         //     pageName:'pageName',
//         //     limitName: 'limitName',
//         // }
//         // ,where:{ //自定义参数
//         //     sss:'dd'
//         // }
//
//     });
//     LayPage.render({
//         count:20,
//         limit:10
//     })
// });
layui.use(['table','jquery','form'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var form = layui.form;
    var $ = layui.jquery;
    //第一个实例
      var roder = table.render({
        elem: '#test'
        ,  url: "/Layui/ServletGetUser"//数据接口
        , method: 'post'
        , page:true //开启分页
         ,limits:[10,100]
        , cols:  [[ //表头  //列
            {type:'checkbox',fixed: 'left'},
            {field: 'id', title: 'ID', width:80, sort: true}  //field 字段,templet:'#titleTpl'
            ,{field: 'userName', title: '用户名', width:80}
            ,{field: 'sex', title: '性别', width:80, sort: true}
            ,{toolbar:'#titleTpl',title: '操作'}
        ]],
        toolbar:true,
        defaultToolbar: ['filter', 'print', 'exports'],
        request: {
            pageName: 'page' // 页码的参数名4
            // 称，默认：page
            , limitName: 'limitNumber' //每页数据量的参数名，默认：limit
        },
    });
    //监听事件//监听行内自定义 的toolbar事件
   table.on('tool(table)',function (obj) {
        var event = obj.event;//获取点击按钮的event数据
        //获取当前选择的用户id
        var id = obj.data.id;
        console.log(id)
        var tr = obj.tr;//获取当前层的dom对象
        if(event=='bianji'){
            //编辑  获取当前行id

        }else if(event=='del'){
            //删除操作
            layer.open({
                type:0,
                content:'确定删除',
                title:'确定删除',
                btn:['确定删除','取消']
                ,yes:function f(index) {//确定按钮
                    //index是当前层使用 layer.close(index)可以关闭当前层
                    //发送删除请求到 sevlet
                    $.ajax({
                        type:'post',
                        url:'/Layui/ServletDel',
                        data:{
                            stuId:id
                        },
                        success:function (data) {
                            if(data>0){
                                layer.msg('删除成功')
                                layer.close(index)
                                //删除成功后刷新数据 或者不刷新直接删除这一行
                                roder.reload(parameter)
                            }
                        }
                    })
                },btn2:function (index) {//第二个按钮

                },cancel:function (index,layero) {//右上角按钮

                }
            })
        }
    })
    //重新加载数据的函数参数
    function parameter (where) {
        return {
            url:'/Layui/ServletGetUser',
            where: where
        }
    }
    //点击搜索
    form.on('submit(serach)', function(data){
        console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
        console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        var name = data.field.search;
        layer.msg(name)
        roder.reload(parameter({
            'names' : name
        }))//渲染更新
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
    //修改后更新本地缓存
    // obj.update({
    //     username: '123'
    //     ,title: 'xxx'
    // });
});