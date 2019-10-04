<%--
  Created by IntelliJ IDEA.
  User: yuyang
  Date: 2019/10/4
  Time: 7:01 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="anno/testRequestParam?name=哈哈">RequestParam</a>

        <br/><h3>@RequestBody Demo</h3>
        <form action="anno/testRequestBody" method="post">
            用户姓名：<input type="text" name="username" /><br/>
            用户年龄：<input type="text" name="age" /><br/>
            <input type="submit" value="提交" />
        </form>

    <br/><h3>@PathVariable Demo</h3>
    <a href="anno/testPathVariable/10">testPathVariable</a>

    <br/><h3>@RequestHeader Demo</h3>
    <a href="anno/testRequestHeader">RequestHeader</a>

    <br/><h3> CookieValue注解 Demo</h3>
    <a href="anno/testCookieValue">CookieValue</a>


    <br/><h3> ModelAttribute Demo</h3>
    <form action="anno/testModelAttribute" method="post">
        用户姓名：<input type="text" name="uname" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        <input type="submit" value="提交" />
    </form>

    <br/><h3>testSessionAttributes</h3>
    <a href="anno/testSessionAttributes">testSessionAttributes</a>

    <br/><h3>getSessionAttributes</h3>
    <a href="anno/getSessionAttributes">getSessionAttributes</a>

    <br/><h3>delSessionAttributes</h3>
    <a href="anno/delSessionAttributes">delSessionAttributes</a>
</body>
</html>
