<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<body>
<h2>Hello ${requestScope.name}</h2>
<div>
    <form action="image" method="POST" enctype="multipart/form-data">
        <table>
            <tr>日期：<input name="date" type="datetime" style="width: 100px;"></tr>
            <tr>选择文件：<input  name="imageFile" type="file" style="widows: 100px;"></tr>
            <tr><input type="submit" style="width:50px" value="提交"/></tr>
        </table> 
    </form>
</div>
</body>
</html>