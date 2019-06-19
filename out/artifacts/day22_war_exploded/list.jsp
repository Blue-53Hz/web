<%--
  Created by IntelliJ IDEA.
  User: blue
  Date: 2019/6/19
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head> 
    <title>可以下载的文件列表</title>  
  </head>
  
  <body>
    <table border="1" width="700px">
    	<tr>
    		<th>编号</th>
    		<th>文件名</th>
    		<th>大小</th>
    		<th>类型</th>
    		<th>上传时间</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${list}" var="bean" varStatus="varSta">
    	<tr>
    		<td>${varSta.count }</td>
    		<td>${bean.name }</td>
    		<td>${bean.size }</td>
    		<td>${bean.type }</td>
    		<td>${bean.addTime }</td>
    		<td><a href="${pageContext.request.contextPath }/DownServlet?id=${bean.id}">下载该资源</a></td>
    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
