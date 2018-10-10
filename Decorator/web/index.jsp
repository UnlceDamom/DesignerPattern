<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/6/27
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/demo01" method="get">
      用户名：<input type="text" name="username"/><br/>
      <input type="submit"/>
    </form>
  </body>
</html>
