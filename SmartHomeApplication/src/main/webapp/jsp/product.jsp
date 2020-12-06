<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>智慧家电商场</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-theme.css" />
<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<link rel="stylesheet" href="Flat-UI-master/dist/css/flat-ui.css"/>
<script src="Flat-UI-master/dist/js/flat-ui.js"></script>
<script>
	function saveCart(){
		var count = document.getElementById("count").value;
		var i = parseInt(count);
		if(i<=0){
			alert("购买数量不能小于1");
			return;
		}else{
			document.getElementById("cartForm").submit();
		}
	}
</script>

</head>
<body>

<%@ include file="menu.jsp"%>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default">
				<div class="navbar-header">
					<a class="navbar-brand" href="index.jsps">SmartHome</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<c:forEach items="${categories}" var="category">
							<c:forEach items="${category.secondCategories}" var="second">
								<c:if test="${category.id==second.cid && second.id == product.scid }">
									<li><a href="product/list?scid=${second.id}">${category.name}</a></li>
									<li><a>/</a></li>
									<li><a href="product/list?scid=${second.id}">${second.name}</a></li>
								</c:if>
							</c:forEach>
						</c:forEach>
					</ul>
				</div>
				</nav>
			</div>
		</div>
	</div>

<div class="container body-content">

    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">
                <div class="col-md-2 col-xs-4 hidden-xs">
                    <img class="img-thumbnail" alt="#" src="${product.image}" title="${product.image}" width="140" height="180" />
                </div>
                <div class="col-md-10">
                    <h2 class="bookTitle">${product.name}</h2>
                    <p>
                        描述：</a><span class="hidden-xs" title="描述：${product.description}">${product.description}</span>
                    </p>
                    <p>
                        价钱：</a>
                        <span class="text-muted fs-12 text-center" style="color: red">￥${product.shopPrice}</span><br />
                        <%--<span class="hidden-xs" title="作者：${product.description}">${product.description}</span>--%>
                    </p>
                    <p>
                        上架时间：</a><span class="hidden-xs" >
                        <fmt:formatDate value="${product.time}" pattern="yyyy-MM-dd hh:MM:ss"></fmt:formatDate>
                        </span>
                    </p>
                    <div class="row">
                        <form class="form-horizontal" action="cart/add" method="post">
                        	<input type="hidden" name="id" value="${product.id}" />
                            <span class="col-md-8">
                                <div class="row">
                                    <label class="control-label col-md-2">购买数量：</label>
                                    <div class="form-group col-md-2">
                                        <input type="text" class="form-control" value="1" name="count">
                                    </div>
                                </div>
                                <div class="row">
                                    <input type="submit" class="btn btn-danger col-md-offset-1" value="加入购物车">
                                </div>
							</span>
                        </form>

                        <div class="clear"></div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>