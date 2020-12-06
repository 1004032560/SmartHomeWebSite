<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <script>
        $(function () {
            $(".dropdown").mouseover(function () {
                $(this).addClass("open");
            });

            $(".dropdown").mouseleave(function(){
                $(this).removeClass("open");
            })

        })
    </script>
<div class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a href="index.jsp" class="navbar-brand logo">SmartFurniture</a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" id="nav-header">
            <ul class="nav navbar-nav">
                <c:forEach items="${categories}" var="category" end="3">
                    <li>
                        <a href="product/list?cid=${category.id}">${category.name}</a>
                    </li>
                </c:forEach>
            </ul>
            <ul class="nav navbar-nav navbar-right" style="margin-right: 10px">
            	<c:if test="${sessionScope.user == null}">
                	<li><a href="jsp/cart.jsp">购物车</a></li>
                	<li><a href="jsp/login.jsp">登录</a></li>
                	<li><a href="jsp/regist.jsp">注册</a></li>
              	</c:if>
              	<c:if test="${sessionScope.user != null}">
              		<li><a><span class="glyphicon glyphicon-user"></span> ${sessionScope.user.name}</a></li>
                	<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">功能<strong class="caret"></strong></a>
							<ul class="dropdown-menu" style="margin-top: 0px">
								<li><a href="jsp/cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> 购物车</a></li>
								<li class="divider">
								</li>
								<li><a href="order/list"><span class="glyphicon glyphicon-list"></span> 我的订单</a></li>
							</ul>
					</li>
                	<li><a href="user/quit">退出</a></li>
              	</c:if>
            </ul>
        </nav>
    </div>
</div>