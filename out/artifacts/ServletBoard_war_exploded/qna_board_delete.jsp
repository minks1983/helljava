<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
    int num=Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
<title>MVC 게시판</title>
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
</head>
<body>
<form name="deleteForm" action="./BoardDeleteAction.do?num=<%=num %>" 
    method="post">
<table class="table table-striped">
<tr>
    <td colspan=2 align=center>
        <a href="javascript:deleteForm.submit()">삭제</a>
        &nbsp;&nbsp;
        <a href="javascript:history.go(-1)">돌아가기</a>
    </td>
</tr>
</table>
</form>
</body>
</html>