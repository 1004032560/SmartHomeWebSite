<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${pageContext.request.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="Flat-UI-master/dist/css/flat-ui.css" />
<link rel="stylesheet"
	href="bootstrapvalidator-0.4.5/dist/css/bootstrapValidator.css" />
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<script src="bootstrapvalidator-0.4.5/dist/js/bootstrapValidator.js"></script>
    <script>
        $(function(){
            $('#form1')

                .bootstrapValidator({
                        message: 'This value is not valid',
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        fields: {
                            username: {
                                message: 'The username is not valid',
                                validators: {
                                    notEmpty: {
                                        message: '用户名不能为空'
                                    },
                                    threshold: 5,
                                    remote: {
                                        url: 'user/validLoginUsername',
                                        delay: 5000,
                                        type: 'POST',
                                        message: '用户名不存在'
                                    },
                                    regexp: {
                                        regexp: /^\w{5,8}$/,
                                        message: '用户名必须是5到8位的字母数字或者下划线组成'
                                    }
                                }
                            },
                            password: {
                                message: '密码无效',
                                validators: {
                                    notEmpty: {
                                        message: '密码不能为空'
                                    },
                                    threshold: 5,
                                    remote: {
                                        url: 'user/validPassword',
                                        delay: 5000,
                                        type: 'POST',
                                        data: function(validator) {
                                            return {
                                                password: $('[name="password"]').val(),
                                                username: $('[name="username"]').val()
                                            };
                                        },
                                        message: '密码错误'
                                    },
                                    regexp: {
                                        regexp: /^\w{5,8}$/,
                                        message: '密码必须是 5到8位的字母数字或者下划线组成'
                                    }
                                }
                            }
                        }
                    }
                )

            .on('success.form.bv', function(e) {
                    e.preventDefault();

                    // Get the form instance
                    var $form = $(e.target);

                    // Get the BootstrapValidator instance
                    var bv = $form.data('bootstrapValidator');

                    // Use Ajax to submit form data 提交至form标签中的action，result自定义
                    $.post($form.attr('action'), $form.serialize(), function(result) {
                    });
                });
        });

    </script>
</head>
<body>

	<%@ include file="menu.jsp"%>

	<div class="container">
		<div class="jumbotron col-md-12">
			<form class="form-horizontal" id="form1" action="user/login"
				method="post">
				<div class="form-group">
					<label for="inputUsername" class="col-sm-5 control-label">用户名：</label>
					<div class="col-sm-3">
						<input type="text" name="username" class="form-control"
							id="inputUsername" />
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="col-sm-5 control-label">密
						码：</label>
					<div class="col-sm-3">
						<input type="password" name="password" class="form-control"
							id="inputPassword" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-1">
						<button type="submit" class="btn btn-success">登 录</button>
					</div>
					<div class="col-sm-1">
						<a href="jsp/regist.jsp">
							<button type="button" class="btn btn-default">注 册</button>
						</a>
					</div>
				</div>
			</form>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

</body>
</html>