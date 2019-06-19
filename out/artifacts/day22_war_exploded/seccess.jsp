<%--
  Created by IntelliJ IDEA.
  User: blue
  Date: 2019/6/18
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>文件列表</title>
</head>
<body>
   <h3>文件上传成功</h3>
<table border="1" width="500px">
    <tr>
        <th>编号</th>
        <th>文件名</th>
        <th>大小</th>
        <th>类型</th>
        <th>上传时间</th>
    </tr>
   <c:forEach items="${fileList}" var="bean" varStatus="varSta">
       <tr>
           <td>${varSta.count }</td>
           <td>${bean.name }</td>
           <td>${bean.size }</td>
           <td>${bean.type }</td>
           <td>${bean.addTime }</td>
       </tr>


   </c:forEach>
</table>
</body>
</html>
