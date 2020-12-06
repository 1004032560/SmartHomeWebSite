<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>智慧家电商场</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-theme.css" />
<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<link rel="stylesheet" href="Flat-UI-master/dist/css/flat-ui.css"/>
<script src="Flat-UI-master/dist/js/flat-ui.js"></script>
<script>
	function fenye(curPage) {
		location.href = "product/list?curPage=" + curPage + "&cid=${cid}&scid=${scid}";
	}
</script>
</head>
<body>

<%@ include file="menu.jsp"%>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover">
                <tbody>
                <c:forEach items="${categories}" var="category" end="3">
					<tr>
						<th>
							<a href="product/list?cid=${category.id}">${category.name}</a>
                    	</th>
						<c:forEach items="${category.secondCategories}" var="second" end="4">
							<td>
                        		<a href="product/list?&scid=${second.id}">${second.name}</a>
                    		</td>
						</c:forEach>
                	</tr>
                	<tr>
						<th></th><td></td><td></td><td></td><td></td><td></td>
                	</tr>
				</c:forEach>               
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="container body-content">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default hidden-xs">
                <div class="panel-heading">
                    <div class="row">
                        <h5 class="pull-left col-xs-4"><i class="glyphicon glyphicon-tasks"></i> 
                        
                        <c:forEach items="${categories}" var="category">
							<c:if test="${cid == category.id }">
									${category.name }
							</c:if>
                			<c:forEach items="${category.secondCategories}" var="second" end="4">
								
								<c:if test="${cid != category.id }">
									<c:if test="${scid == second.id }">
										${second.name}
									</c:if>
								</c:if>
                        			
							</c:forEach>
						</c:forEach>

                        </h5>
                        <div class="col-md-6 col-xs-8 pull-right">

                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="panel-body">

                    <c:forEach items="${page.list}" var="n" end="9">
                        <div class="col-md-3 col-xs-6 mb10 mt10">

                            <a class="thumbnail text-center" href="product/show?id=${n.id}" title="${n.name}">
                                <img class="text-center" src="${n.image} " style="height: 182px;" alt="${n.name}" style="height: 182px;">
                                <div class="caption">
                                    <strong class="text-center">${n.name}</strong> <br /> 
                                    <span class="text-muted fs-12 text-center">商城价：<span style="color: red">￥${n.shopPrice}</span></span> <br />
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                    
                <div class="clear"></div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="row">
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