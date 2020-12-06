<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${pageContext.request.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会员注册</title>

<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="Flat-UI-master/dist/css/flat-ui.css" />
<link rel="stylesheet" href="bootstrapvalidator-0.4.5/dist/css/bootstrapValidator.css"/>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<script src="bootstrapvalidator-0.4.5/dist/js/bootstrapValidator.js"></script>

<script>
        $(function(){
            $('#registerForm')
                .bootstrapValidator({
                    message: 'This value is not valid',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {/*验证：规则*/
                        username: {
                            message: 'The username is not valid',
                            validators: {
                                notEmpty: {//非空验证：提示消息
                                    message: '用户名不能为空'
                                },
                                threshold :  5 , //有5字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，5字符以上才开始）
                                remote: {//ajax验证
                                    url: 'user/validUsername',//验证地址             
                                    delay :  5000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置5秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                                    type: 'POST',//请求方式
                                   	message: '此用户名已存在'
                                },
                                regexp: {
                                    regexp: /^\w{5,8}$/,
                                    message: '用户名必须是5到8位的字母数字或者下划线组成'
                                }
                            }
                        },
                        password: {
                            message:'密码无效',
                            validators: {
                                notEmpty: {
                                    message: '密码不能为空'
                                },
                                regexp: {
                                    regexp: /^\w{5,8}$/,
                                    message: '密码必须是 5到8位的字母数字或者下划线组成'
                                }
                            }
                        },
                        repassword: {
                            message: '密码无效',
                            validators: {
                                notEmpty: {
                                    message: '用户名不能为空'
                                },
                                identical: {//相同
                                    field: 'password',
                                    message: '两次密码不一致'
                                },
                                regexp: {//匹配规则
                                    regexp: /^\w{5,8}$/,
                                    message: '密码必须是 5到8位的字母数字或者下划线组成'
                                }
                            }
                        },
                        name: {
                            message: '姓名必填',
                            validators: {
                                notEmpty: {
                                    message: '手机号码不能为空'
                                }
                            }
                        },
                        phone: {
                            message: 'The phone is not valid',
                            validators: {
                                notEmpty: {
                                    message: '手机号码不能为空'
                                },
                                regexp: {
                                    regexp: /^1[3578]\d{9}$/,
                                    message: '手机号码格式不正确'
                                }
                            }
                        },
                        addr: {
                            message: '不能为空',
                            validators: {
                                notEmpty: {
                                    message: '地址不能为空'
                                }
                            }
                        },
                        email: {
                            validators: {
                                notEmpty: {
                                    message: '邮件不能为空'
                                },
                                emailAddress: {
                                    message: '邮箱格式不正确'
                                }
                            }
                        },
                        checkcode: {
                            message: '验证码',
                            validators: {
                                notEmpty: {
                                    message: '验证码不能为空'
                                },
                                threshold : 4, 
                                remote: {
                                    url: 'user/validCode',
                                    message: '验证码不正确',
                                    delay :  5000,
                                    type: 'POST'
                                }
                            }
                        },
                    }
                })
                .on('success.form.bv', function(e) {//点击提交之后
                    // Prevent form submission
                    e.preventDefault();

                    // Get the form instance
                    var $form = $(e.target);

                    // Get the BootstrapValidator instance
                    var bv = $form.data('bootstrapValidator');

                    // Use Ajax to submit form data 提交至form标签中的action，result自定义
                    $.post($form.attr('action'), $form.serialize(), function(result) {
//do something...
                    });
                });
        });

    </script>
</head>
<body>

	<%@ include file="menu.jsp"%>

	<div class="container">
		<div class="jumbotron col-md-12">

			<div class="col-md-12">
				<h2 style="text-align: center; margin-bottom: 30px">注&nbsp;&nbsp;册</h2>
			</div>

			<form class="form-horizontal" id="registerForm" action="user/regist"
				method="post">
				<div class="form-group">
					<label class="col-sm-5 control-label">用户名：</label>
					<div class="col-sm-3">
						<input type="text" name="username" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">密码：</label>
					<div class="col-sm-3">
						<input type="password" name="password" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">确认密码：</label>
					<div class="col-sm-3">
						<input type="password" name="repassword" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">邮箱：</label>
					<div class="col-sm-3">
						<input type="text" name="email" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">姓名：</label>
					<div class="col-sm-3">
						<input type="text" name="name" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">手机号：</label>
					<div class="col-sm-3">
						<input type="text" name="phone" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">地址：</label>
					<div class="col-sm-3">
						<input type="text" name="addr" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">验证码：</label>
					<div class="col-sm-3">
						<input type="text" name="checkcode" class="form-control" /> <img
							id="checkImg" class="captchaImage" src="validCode"
							onclick="this.src='validCode?time='+new Date().getTime()"
							title="点击更换验证码" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-1">
						<button type="submit" class="btn btn-success">立即注册</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

</body>
</html>