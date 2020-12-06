<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>智慧家电商场</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="css/bootstrap.css" />
<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<link rel="stylesheet" href="Flat-UI-master/dist/css/flat-ui.css"/>
<script src="Flat-UI-master/dist/js/flat-ui.js"></script>
    <style>
        #a1{
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<%@ include file="menu.jsp"%>

<div class="container" id="a1">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="carousel slide" id="carousel" data-ride="carousel" data-interval="2000">
                <ol class="carousel-indicators">
                    <li class="active" data-slide-to="0" data-target="#carousel"></li>
                    <li data-slide-to="1" data-target="#carousel"></li>
                    <li data-slide-to="2" data-target="#carousel"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="image/background01.jpg" height="375" width="1200"/>
                    </div>
                    <div class="item">
                        <img src="image/background02.jpg" height="375" width="1200"/>
                    </div>
                    <div class="item">
                        <img src="image/background03.jpg" height="375" width="1200"/>
                    </div>
                </div>
                <a class="left carousel-control" href="#carousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a class="right carousel-control" href="#carousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="container body-content">
    <div class="row">
        <div class="col-md-8">
            <div class="panel panel-default hidden-xs">
                <div class="panel-heading">
                    <div class="row">
                        <h6 class="pull-left col-xs-4"><i class="glyphicon glyphicon-tasks"></i> 最热家电</h6>
                        <div class="col-md-6 col-xs-8 pull-right">

                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="panel-body">

                    <c:forEach items="${hotlist}" var="n" end="7">
                        <div class="col-md-3 col-xs-6 mb10 mt10">
                            <a class="thumbnail text-center" href="product/show?id=${n.id}" title="${n.name}">
                                <img class="text-center" src="${n.image} "  height="150" width="150" alt="#">
                                <div class="caption">
                                    <strong class="text-center">${n.name}</strong> <br />
                                    <span class="text-muted fs-12 text-center" style="color: red">￥${n.shopPrice}</span><br />
<%--                                    <span class="text-muted fs-12 text-center">${n.description}</span> <br />--%>
                                </div>
                            </a>
                        </div>
                    </c:forEach>

                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#tab-weekvisit" data-toggle="tab">本月最新家电</a>
                </li>
            </ul>
            <div class="tab-content mt10">
                <div class="tab-pane active" id="tab-weekvisit">
                    <ul class="list-group list-top">
                        <c:forEach items="${newslist}" var="entry" varStatus="status" end="9">

                            <li class="list-group-item">
                            	<span>${status.count}</span>
                                <i class="glyphicon glyphicon-chevron-right"></i>
                                <a href="product/show?id=${entry.id}" title="${entry.name }">${entry.name }</a>
                            </li>

                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>