<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${pageContext.request.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>订单确认</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="Flat-UI-master/dist/css/flat-ui.css"/>
<link rel="stylesheet" href="bootstrapvalidator-0.4.5/dist/css/bootstrapValidator.css"/>
<script  type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<script src="bootstrapvalidator-0.4.5/dist/js/bootstrapValidator.js"></script>

</head>
<body>

<%@ include file="menu.jsp" %>
	
<div class="container">
    <div class="row clearfix">
       <div class="col-md-12 column">
           <h4>亲!您的订单：${orders.id }，已经生成成功!</h4>
           <h4>快递单号是：ASUI202007014537，请注意查收!</h4>
        </div>
    </div>
    <div class="clear"></div>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>