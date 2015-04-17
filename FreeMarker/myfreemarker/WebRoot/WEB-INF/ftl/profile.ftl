<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"]/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>freemarkerDemo</title>
</head>
<body>
姓名：${username}
<br/>
密码：${password}
<br/>
年龄：${userInfo.age}
<br/>
登录时间：${userInfo.signinTime?string("yyyy-MM-dd HH:mm:ss")}
<br/>
QQ：${userInfo.qq!}
<br/>
地址：${userInfo.addr}
<hr/>
我的书籍：
<#list userInfo.books as book>
 ${book}&nbsp;
</#list>
</body>
</html>