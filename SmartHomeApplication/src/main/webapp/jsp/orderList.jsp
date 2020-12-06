<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>订单页面</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-theme.css" />
<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<link rel="stylesheet" href="Flat-UI-master/dist/css/flat-ui.css"/>
<script src="Flat-UI-master/dist/js/flat-ui.js"></script>
<script>
function fenye(curPage){
	location.href="order/list?curPage="+curPage;
}
</script>
</head>
<body>

<%@ include file="menu.jsp"%>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h4><i class="glyphicon glyphicon-list-alt"></i>我的订单</h4>
            <table class="table table-bordered table-hover">
                <c:forEach items="${page.list}" var="order">
                <thead>
                <tr>
                    <th colspan="5">
                        订单编号：${order.id}&nbsp;&nbsp;&nbsp;&nbsp;
                        订单金额:<span color="red">￥${order.total}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                        <span color="red">
                            <c:if test="${order.state == 1}">
                                <a href="order/payMoney/${order.id}">付款</a>
                            </c:if>
                            <c:if test="${order.state == 2}">
                                已付款
                            </c:if>
                            <c:if test="${order.state == 3}">
                                <a href="order/receive/${order.id}">确认收货</a>
                            </c:if>
                            <c:if test="${order.state == 4}">
                                交易成功
                            </c:if>
                        </span>
                    </th>
                </tr>
                <tr>
                    <th  class="text-center">图片</th>
                    <th  class="text-center">商品</th>
                    <th  class="text-center">价格</th>
                    <th  class="text-center">数量</th>
                    <th  class="text-center">小计</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${order.orderitems}" var="item">
                    <tr>
                        <td class="text-center">
                            <img src="${item.product.image}" height="80" width="80" />
                        </td>
                        <td class="text-center">${item.product.name}</td>
                        <td class="text-center">￥${item.product.shopPrice}</td>
                        <td class="quantity text-center" width="60">${item.count}</td>
                        <td class="text-center" width="140"><span>￥${item.subtotal}</span>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                </c:forEach>
            </table>
            <div class="clear"></div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="navigation">
                <ul class="pagination pagination-md" style="background-color:#bdc3c7;">
                    <li>
                        <a href="javascript:fenye('${page.prePage}')">上一页</a>
                    </li>
                    <c:forEach var="p" begin="1" end="${page.pages}" >
                        <li>
                            <a href="javascript:fenye('${p}')">${p }</a>
                        </li>
                    </c:forEach>
                    <li>
                        <a href="javascript:fenye('${page.nextPage}')">下一页</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>