<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"]/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>freemarkerDemo</title>
</head>
<body>
<@s.form action="users/users_login.action">
  ${"用户名"}:<@s.textfield name="username"/><br/>
  ${"密码"}:<@s.password name="password"/><br/>
  <@s.submit value="sign on"/>
</@s.form>
</body>
</html>





