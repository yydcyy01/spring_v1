<%--
  Created by IntelliJ IDEA.
  User: yuyang
  Date: 2019/10/9
  Time: 10:32 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<br/><h3>测试查询</h3>
<a href="account/findAll">测试查询</a>

<br/><h3>测试添加</h3>
<form action="account/save" method="post">
    姓名：<input type="text" name="name" /><br/>
    金额：<input type="text" name="money" /><br/>
    <input type="submit" value="保存"/><br/>
</form>
</body>
</html>
