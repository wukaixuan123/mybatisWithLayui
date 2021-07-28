layui.use('layer',function () {
 var layer = layui.layer;//获取到弹窗对象
 layer.open({ //使用open模式
     skin:"layui-layer-lan",
     type:0,  //类型   0(信息框) 1(页面层) 2 ifram层 3加载层 4tips层  默认为0信息框
     title:['我是信息'], //标题信息
     content:'https://www.github.com' //内容
     ,btn:['确定','关闭'] //按钮
     ,yes:function () {
         layer.msg('确定')
     },btn2:function () {
         layer.msg("btn2")
     },
     area:['200px','100px'] //定义宽高  自适应auto
     ,cancel:function () {
         return false; //点击右上角关闭  false是 不执行任何操作
     }
     ,closeBtn:2 //右上角关闭按钮风格 设置
     // ,shade:[0.3,"red"]   //默认0.3的透明度 后面是颜色
     ,shadeClose :true //是否开启可关闭外层遮罩
     ,time:100000 //自动关闭时间
     ,anim:4   //弹出方式的动画
 })
    // layer.load(2)  //加载样式  有0-2的风格    信息框有6中风格
})
//layer加载的是 弹窗模块
