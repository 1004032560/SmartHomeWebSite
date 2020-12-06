<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${pageContext.request.contextPath}/"/>
<title>智慧家电商城管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%--<link href="${pageContext.request.contextPath}/css/general.css" rel="stylesheet" type="text/css" />--%>
<%--<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" />--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/static/admin/layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/static/admin/css/login.css" />
<%--<style type="text/css">
body {
  color: white;
}
</style>--%>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script src="static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
   $(function() {
	$("#form1").validate({
		rules:{
			username:{
				required:true,
				remote:"admin/validUsername"
			},
			password:{
				required:true,
				remote:{
					url:"admin/validPassword",
				    type:"post",
				    dataType:"json",
				    data:{
				    	username:function(){
				    		return $("#username").val();
				    	},
				    	password:function(){
				    		return $("#password").val();
				    	}
				    }
				}
			},
		},
		messages:{
			username:{
				remote:"该用户名不存在"
			},
			password:{
				remote:"密码不正确"
			},
		}
	});
});
</script >
</head>
<body>

<div class="m-login-bg">
  <div class="m-login">
    <h3>后台系统登录</h3>
    <div class="m-login-warp">
      <form class="layui-form" id="form1" action="admin/login" method="post">
        <div class="layui-form-item">
          <input type="text" id="username" name="username" required lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-item">
          <input type="password" id="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-item m-login-btn">
          <div class="layui-inline">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="login">登录</button>
          </div>
          <div class="layui-inline">
            <button type="reset" class="layui-btn layui-btn-primary">取消</button>
          </div>
        </div>
      </form>
    </div>
    <p class="copyright">Copyright 2019-2020 by looper</p>
  </div>
</div>
</body>