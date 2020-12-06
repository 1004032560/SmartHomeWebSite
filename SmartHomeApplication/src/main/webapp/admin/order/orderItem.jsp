<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table width="100%" border="0">
    <tr>
		<td>产品图片</td>
		<td>名称</td>
		<td>数量</td>
		<td>小计</td>
	</tr>
	<c:forEach items="${list}" var="item">
	<tr>
		<td><img width="40" height="45" src="${pageContext.request.contextPath}/${item.product.image}"></td>
		<td>${item.product.name}</td>
		<td align="center">${item.count}</td>
		<td>${item.subtotal}</td>
	</tr>
	</c:forEach>
</table>