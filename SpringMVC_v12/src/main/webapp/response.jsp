<%--
  Created by IntelliJ IDEA.
  User: yuyang
  Date: 2019/10/6
  Time: 10:48 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>

    <script>
        $(function(){
            $("#btn").click(function(){
                 alert("你好鸭, 恭喜你探索到这里, 继续努力! ");
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"羽扬","password":"password","age":13}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>

<br/>
    <button id="btn">发送ajax的请求</button>
</body>
</html>
