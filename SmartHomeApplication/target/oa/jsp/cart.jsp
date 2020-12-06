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
    <style>
        #car{
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<%@ include file="menu.jsp"%>

<div class="container">
    <div class="row clearfix">
        <c:if test="${fn:length(cart.cartItems)>0}">
            <div class="col-md-12 column">
                <h4><i class="glyphicon glyphicon-shopping-cart"></i>购物车信息</h4>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th class="text-center">图片</th>
                        <th class="text-center">商品</th>
                        <th class="text-center">价格</th>
                        <th class="text-center">数量</th>
                        <th class="text-center">小计</th>
                        <th class="text-center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cart.cartItems}" var="item">
                        <tr>
                            <td class="text-center">
                                <img src="${item.product.image}" height="80" width="80" />
                            </td>
                            <td class="text-center"><a target="_blank">${item.product.name}</a></td>
                            <td class="text-center">￥${item.product.shopPrice}</td>
                            <td class="quantity text-center" width="60">${item.count}</td>
                            <td width="140" class="text-center"><span class="subtotal">￥${item.subtotal}</span>
                            </td>
                            <td class="text-center"><a
                                    href="${ pageContext.request.contextPath }/cart/removeCart?id=${item.product.id}"
                                    class="delete">删除</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <div class="row clearfix" id="car">

                    <div class="col-md-12 column">
                        <ul class="list-unstyled">
                            <c:if test="${user==null}">
                                <li>
                                    <span style="color: red">登录后确认是否享有优惠</span>
                                </li>
                            </c:if>
                            <c:if test="${user!=null}">
                                赠送积分: <strong>${cart.total}</strong>
                            </c:if>
                            <li>
                                商品金额：<strong>￥${cart.total}元</strong>
                            </li>
                        </ul>
                    </div>

                    <div class="col-md-2 column">
                        <a href="order/saveOrder">
                            <button type="button" class="btn btn-danger btn-default active btn-block">提交订单</button>
                        </a>
                    </div>
                    <div class="col-md-2 column ">
                        <a href="cart/clearCart">
                            <button type="button" class="btn btn-link btn-default">清空购物车</button>
                        </a>
                    </div>

                </div>

                <div class="clear"></div>
            </div>
        </c:if>
        <c:if test="${fn:length(cart.cartItems)==0}">
            <div class="col-md-12 column">
                <h4 style="color: red">亲!您还没有购物!请先去购物!</h4>
            </div>
        </c:if>
    </div>
    <div class="clear"></div>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>