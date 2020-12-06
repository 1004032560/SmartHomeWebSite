<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/css/Style1.css"
	type="text/css" rel="stylesheet">
<base href="${pageContext.request.contextPath}/">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
	$(function() {
		$("#form1").validate({
			rules : {
				name:{
					required:true,
					remote:"adminProduct/validName?oldName=${product.name}"
				},
			},
			messages : {
				name : {
					remote : "该名称已经存在"
				}
			}
		});
	});
</script>
</HEAD>

<body>
	<!--  -->
	<form id="form1" name="Form1"
		action="${pageContext.request.contextPath}/adminProduct/update"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${product.id}"> <input
			type="hidden" name="image" value="${product.image}"> &nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商品</STRONG> </strong></td>
			</tr>

			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="name" id="name" value="${product.name}" class="bg" /></td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					是否热门：</td>
				<td class="ta_01" bgColor="#ffffff"><select name="isHot">
						<option value="1" <c:if test="${product.isHot==1}">selected</c:if>>是</option>
						<option value="0" <c:if test="${product.isHot==0}">selected</c:if>>否</option>
				</select></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					市场价格：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="marketPrice" value="${product.marketPrice}" class="bg" /></td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商城价格：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="shopPrice" value="${product.shopPrice}" class="bg" /></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品图片：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><input
					type="file" name="photo" /> <c:if test="${!empty product.image}">
						<img src="${pageContext.request.contextPath}/${product.image}" />
					</c:if></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					所属的二级分类：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><select
					name="scid">
						<c:forEach items="${seconds}" var="second">
							<option value="${second.id}"
								<c:if test="${second.id==product.scid}">selected</c:if>>${second.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品描述：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><textarea
						name="description" rows="5" cols="30">${product.description}</textarea>
				</td>
			</tr>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					<button type="submit" id="userAction_save_do_submit" value="确定"
						class="button_ok">&#30830;&#23450;</button> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>