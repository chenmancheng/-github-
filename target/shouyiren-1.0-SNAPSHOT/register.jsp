<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<% pageContext.setAttribute("ctx", request.getContextPath()); %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <title>注册</title>
    <script>
        function check(){
            var regmTel = /^[0-9_]+$/;
            var regmSname = /^[\u4e00-\u9fa5]{0,}$/;
            var regmPassword = /^\w{5,17}$/;
            if(layui-form.tel.value==""){
                alert("用户编号不能为空！");
                layui-form.tel.focus();
                return false;
            }
            if(!layui-form.tel.value.match(regmTel)){
                alert("用户编号格式不对，请使用数字！");
                layui-form.tel.focus();
                return false;
            }
            if(layui-form.password.value==""){
                alert("密码不能为空！");
                layui-form.password.focus();
                return false;
            }
            if(!layui-form.password.value.match(regmPassword)){
                alert("密码名格式不正确，长度在6~18之间，只能包含字母、数字和下划线！");
                layui-form.password.focus();
                return false;
            }
            if(layui-form.cfmpassword.value==""){
                alert("密码不能为空！");
                layui-form.cfmpassword.focus();
                return false;
            }
            if(!layui-form.cfmpassword.value.match(regmPassword)){
                alert("密码名格式不正确,密码以字母开头，长度在6~18之间，只能包含字母、数字和下划线！");
                layui-form.cfmpassword.focus();
                return false;
            }
            if(layui-form.password.value!= form.cfmpassword.value){
                alert("密码不一致！请重新输入！");

                layui-form.cfmpassword.focus();
                return false;
            }
        }
    </script>


    <style type="text/css">
        .container{
            width: 420px;
            height: 460px;
            min-height: 320px;
            max-height: 460px;
            position: absolute;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
            margin: auto;
            padding: 20px;
            z-index: 130;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
            font-size: 16px;
        }
        .close{
            background-color: white;
            border: none;
            font-size: 18px;
            margin-left: 410px;
            margin-top: -10px;
        }

        .layui-input{
            border-radius: 5px;
            width: 300px;
            height: 40px;
            font-size: 15px;
        }
        .layui-form-item{
            margin-left: -20px;
        }
        #logoid{
            margin-top: -16px;
            padding-left:150px;
            padding-bottom: 15px;
        }
        .layui-btn{
            margin-left: -50px;
            border-radius: 5px;
            width: 350px;
            height: 40px;
            font-size: 15px;
        }
        .verity{
            width: 120px;
        }
        .font-set{
            font-size: 13px;
            text-decoration: none;
            margin-left: 120px;
        }
        a:hover{
            text-decoration: underline;
        }

    </style>
</head>
<body>

<form class="layui-form" action="${ctx}/admin/register" method="post">
    <div class="container">
        <label class="layui-form-label" style="width: 150px;margin-left: 85px">欢迎注册本系统</label>
        <button class="close" title="关闭">X</button>
        <div class="layui-form-mid layui-word-aux">

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">tel</label>
            <div class="layui-input-block">
                <input type="text" name="tel" required  lay-verify="required" placeholder="请输入tel" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
            <!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-inline">
                <input type="password" name="cfmpassword" required lay-verify="required" placeholder="请再次输入密码" autocomplete="off" class="layui-input">
            </div>
            <!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input verity">
            </div>

            <!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline">
                <input type="text" name="gender" required  lay-verify="required" placeholder="请输入性别" autocomplete="off" class="layui-input verity">
            </div>

            <!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-inline">
                <input type="text" name="age" required  lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input verity">
            </div>

            <!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->

        </div>

        <!-- 			  <div class="layui-form-item">
                            <label class="layui-form-label">记住密码</label>
                            <div class="layui-input-block">
                              <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
                            </div>
                      </div> -->

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo" onClick="return check()">注册</button>
            </div>
        </div>
        <a href="register.jsp" class="font-set">重置</a>  <a href="login.jsp" class="font-set">立即登录</a>
    </div>
</form>
<script type="text/javascript" src="${ctx}/layui/layui.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        /* laydate.render({
           elem: '#date'
         });
         laydate.render({
           elem: '#date1'
         });

         //创建一个编辑器
         var editIndex = layedit.build('LAY_demo_editor');


         //自定义验证规则
         form.verify({
           title: function(value){
             if(value.length < 5){
               return '标题至少得5个字符啊';
             }
           }
           ,pass: [
             /^[\S]{6,12}$/
             ,'密码必须6到12位，且不能出现空格'
           ]
           ,content: function(value){
             layedit.sync(editIndex);
           }
         });

         //监听指定开关
         form.on('switch(switchTest)', function(data){
           layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
             offset: '6px'
           });
           layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
         });

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });

        //表单初始赋值
        /* form.val('example', {
           "username": "贤心" // "name": "value"
           ,"password": "123456"
           ,"interest": 1
           ,"like[write]": true //复选框选中状态
           ,"close": true //开关状态
           ,"sex": "女"
           ,"desc": "我爱 layui"
         })*/


    });
</script>





























<%--<form name="form" action="${ctx}/admin/register" method="post">--%>


<%--    <div class="dowebok">--%>

<%--        <div class="logo"></div>--%>
<%--        <span style="color: red"><h3>${requestScope.msg}</h3></span>--%>
<%--        <div class="form-item">--%>
<%--            <input type="text" name="tel" placeholder="请输入用户ID">--%>
<%--        </div>--%>
<%--        <div class="form-item">--%>
<%--            <input type="password" name="password" placeholder="请输入密码">--%>
<%--        </div>--%>
<%--        <div class="form-item">--%>
<%--            <input type="password" name="cfmpassword" placeholder="请输入确认密码">--%>
<%--        </div>--%>
<%--        <div class="form-item">--%>

<%--            <select name="permissions">--%>

<%--                <option value="1" class="break">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生</option>--%>
<%--                <option value="2" class="break">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;老师</option>--%>
<%--                <option value="3" class="break">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理</option>--%>
<%--            </select>--%>

<%--        </div>--%>

<%--        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input class="myinput" type="submit" value="注册" onClick="return check();" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--        <input class="myinput" type="Reset" value="重置&nbsp;&nbsp;&nbsp;&nbsp;"/>--%>
<%--    </div>--%>

</form>
</body>
</html>
