<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>购物车</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-theme.css" />
<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<link rel="stylesheet" href="Flat-UI-master/dist/css/flat-ui.css"/>
<script src="Flat-UI-master/dist/js/flat-ui.js"></script>
</head>
<body>

<%@ include file="menu.jsp"%>

<div class="container">
    <div class="row clearfix">
       <div class="col-md-12 column">
           <h4>激活成功，<a href="jsp/login.jsp">点击此处前往登录</a></h4>
        </div>
    </div>
    <div class="clear"></div>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>