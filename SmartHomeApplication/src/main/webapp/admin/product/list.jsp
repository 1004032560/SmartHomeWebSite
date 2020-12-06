<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/adminProduct/toAdd";
			}
			function fenye(curPage){
				var name=$("#name").val();
				window.location.href = "${pageContext.request.contextPath}/adminProduct/list?name="+name+"&curPage="+curPage;
			}
		</script>
</HEAD>
<body>
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<TBODY>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
				</TD>
			</tr>
			<tr>
				<td class="ta_01" align="right">
					<button type="button" id="add" name="add" value="添加"
						class="button_add" onclick="addProduct()">
						&#28155;&#21152;</button>

				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<div>
						请输入要查询的名字: <input type="text" name="name" id="name"
							value="${name}" />
						<button onclick="fenye(1)">查询</button>
					</div>
					<table cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

							<td align="center" width="18%">序号</td>
							<td align="center" width="17%">商品图片</td>
							<td align="center" width="17%">商品名称</td>
							<td align="center" width="17%">商品价格</td>
							<td align="center" width="17%">是否热门</td>
							<td align="center" width="17%">上架时间</td>
							<td width="7%" align="center">编辑</td>
							<td width="7%" align="center">删除</td>
						</tr>
						<c:forEach items="${pageInfo.list}" var="entry" varStatus="status">
							<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="18%">${status.count}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%"><a
									href="${pageContext.request.contextPath}/adminProduct/download.do?fileName=${fn:substring(entry.image,fn:indexOf(entry.image,'/')+1,fn:length(entry.image))}&isOnline=false">
										<img width="40" height="45"
										src="${pageContext.request.contextPath}/${entry.image}">
								</a></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">${entry.name }</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">${entry.shopPrice }</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%"><c:if test="${entry.isHot==1}">
													是
												</c:if> <c:if test="${entry.isHot==0}">
													否
												</c:if></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">
									<fmt:formatDate value="${entry.time}" pattern="yyyy-MM-dd hh:MM:ss"/>
								</td>	
								<td align="center" style="HEIGHT: 22px"><a
									href="${ pageContext.request.contextPath }/adminProduct/getById/${entry.id}">
										<img
										src="${pageContext.request.contextPath}/images/i_edit.gif"
										border="0" style="CURSOR: hand">
								</a></td>

								<td align="center" style="HEIGHT: 22px"><a
									href="${ pageContext.request.contextPath }/adminProduct/del/${entry.id}">
										<img src="${pageContext.request.contextPath}/images/i_del.gif"
										width="16" height="16" border="0" style="CURSOR: hand">
								</a></td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="10">${pageInfo.pageNum}/${pageInfo.pages}
								<button onclick="fenye(1)">首页</button>
								<button onclick="fenye(${pageInfo.prePage})">上一页</button>
								<button onclick="fenye(${pageInfo.nextPage})">下一页</button>
								<button onclick="fenye(${pageInfo.pages})">尾页</button>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</TBODY>
	</table>
</body>
</HTML>

