<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<base href="${pageContext.request.contextPath}/" />
<title>订单页面</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<link rel="stylesheet" href="Flat-UI-master/dist/css/flat-ui.css"/>
</head>
<body>

<%@ include file="menu.jsp"%>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
                <h4><i class="glyphicon glyphicon-list-alt"></i>生成订单成功</h4>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th colspan="5">订单编号：${order.id}</th>
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
                            <td class="text-center"><a target="_blank">${item.product.name}</a></td>
                            <td>￥${item.product.shopPrice}</td>
                            <td class="quantity text-center" width="60">${item.count}</td>
                            <td class="text-center" width="140"><span class="subtotal">￥${item.subtotal}</span>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <thead>
                    <tr>
                        <th colspan="5" style="text-align: right">商品金额: <strong style="color: red">￥${order.total}元</strong></th>
                    </tr>
                    </thead>
                </table>
                <div class="clear"></div>
            </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form class="form-horizontal" action="order/payOrder" method="post">
            	<div class="form-group">
                    <div class="col-sm-4">
                        <input type="hidden" name="id" value="${order.id}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">收货地址：</label>
                    <div class="col-sm-4">
                        <input type="text" name="addr" value="${order.addr}"  class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">收货人：</label>
                    <div class="col-sm-4">
                        <input type="text" name="name" value="${order.name}" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">联系方式：</label>
                    <div class="col-sm-4">
                        <input type="text" name="phone" value="${order.phone}"  class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                <div class="radio col-md-offset-1">
                    <label class="radio-inline">
                        <input type="radio" name="inlineRadioOptions" checked="checked" value="option1"> 农业银行
                        <img src="bank_img/abc.bmp"/></label>
                    <label class="radio-inline col-md-offset-1">
                        <input type="radio" name="inlineRadioOptions" value="option2"> 工商银行
                        <img src="bank_img/icbc.bmp"/></label>
                    <label class="radio-inline col-md-offset-1">
                        <input type="radio" name="inlineRadioOptions" value="option3"> 中国银行
                        <img src="bank_img/bc.bmp"/>
                    </label>
                </div>
                </div>
                <div class="form-group">
                    <div class="radio col-md-offset-1">
                        <label class="radio-inline">
                            <input type="radio" name="inlineRadioOptions" value="option1"> 农业银行
                            <img src="bank_img/bcc.bmp"/></label>
                        <label class="radio-inline col-md-offset-1">
                            <input type="radio" name="inlineRadioOptions" value="option2"> 交通银行
                            <img src="bank_img/bcc.bmp"/></label>
                        <label class="radio-inline col-md-offset-1">
                            <input type="radio" name="inlineRadioOptions" value="option3"> 平安银行
                            <img src="bank_img/pingan.bmp"/>
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="radio col-md-offset-1">
                        <label class="radio-inline">
                            <input type="radio" name="inlineRadioOptions" value="option1"> 建设银行
                            <img src="bank_img/ccb.bmp"/></label>
                        <label class="radio-inline col-md-offset-1">
                            <input type="radio" name="inlineRadioOptions" value="option2"> 光大银行
                            <img src="bank_img/guangda.bmp"/></label>
                        <label class="radio-inline col-md-offset-1">
                            <input type="radio" name="inlineRadioOptions" value="option3"> 招商银行
                            <img src="bank_img/cmb.bmp"/>
                        </label>
                    </div>
                </div>
                <div class="col-md-12 column">
                    <div class="progress">
                        <div class="progress-bar progress-success">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-1">
                        <button type="submit" class="btn btn-default btn-danger"><h4>确认订单</h4></button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>