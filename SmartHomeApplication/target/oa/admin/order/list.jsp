<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="${pageContext.request.contextPath }/"/>
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function showDetaila(oid){
				var but = document.getElementById("but"+oid);
				var div1 = document.getElementById("div"+oid);
				if(but.value == "订单详情"){
					// 1.创建异步对象
					var xhr =  xmlHttp=new XMLHttpRequest();//createXmlHttp();
					// 2.设置监听
					xhr.onreadystatechange = function(){
						if(xhr.readyState == 4){
							if(xhr.status == 200){
								div1.innerHTML = xhr.responseText;
							}
						}
					}
					// 3.打开连接
					xhr.open("GET","adminOrder/findOrderItem?id="+oid+"&time="+new Date().getTime(),true);
					// 4.发送
					xhr.send(null);
					but.value = "关闭";
				}else{
					div1.innerHTML = "";
					but.value="订单详情";
				} 
				
			}
			function createXmlHttp(){
				   var xmlHttp;
				   try{ // Firefox, Opera 8.0+, Safari
				        xmlHttp=new XMLHttpRequest();
				    }
				    catch (e){
					   try{// Internet Explorer
					         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
					      }
					    catch (e){
					      try{
					         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					      }
					      catch (e){}
					      }
				    }

					return xmlHttp;
				 }
				function fenye(curPage){
					var orderId=document.getElementById("orderId").value;
					location.href="adminOrder/list?curPage="+curPage+"&orderId="+orderId;
				}
		</script>
	</HEAD>
	<body>
	    <div>
	      请输入要查询的订单编号:<input type="text" name="orderId" id="orderId" value="${orderId}"/>
	      <button onclick="fenye(1)" >查询</button>
	    </div>
		<br>
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10%">
										序号
									</td>
									<td align="center" width="10%">
										订单编号
									</td>
									<td align="center" width="10%">
										订单金额
									</td>
									<td align="center" width="10%">
										收货人
									</td>
									<td align="center" width="10%">
										订单状态
									</td>
									<td align="center" width="50%">
										订单详情
									</td>
								</tr>
									<c:forEach items="${page.list}" var="entry" varStatus="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												${status.count}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${entry.id }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${entry.total }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${entry.name }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:if test="${entry.state==1}">
													未付款
												</c:if>
												<c:if test="${entry.state==2}">
													<a href="adminOrder/send/${entry.id}"><font color="blue">发货</font></a>
												</c:if>
												<c:if test="${entry.state==3}">
													等待确认收货
												</c:if>
												<c:if test="${entry.state==4}">
													订单完成
												</c:if>
											
											</td>
											<td align="center" style="HEIGHT: 22px">
												<input type="button" value="订单详情" id="but${entry.id}" onclick="showDetaila('${entry.id}')"/>
												<div id="div${entry.id}">
													
												</div>
											</td>
							
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
			<font>
    当前页:第${page.pageNum}页 | 总记录数:${page.total}条 | 每页显示:${page.pageSize}条 | 总页数:${page.pages}页</font>　
<c:forEach begin="1" end="${page.pages}" var="wp">
    <c:if test="${page.pageNum==wp}"><b><font color="red">${wp}</font></b></c:if>
    <c:if test="${page.pageNum!=wp}"><a href="javascript:fenye('${wp}')" class="a03">${wp}</a></c:if>
</c:forEach>
	</body>
</HTML>

