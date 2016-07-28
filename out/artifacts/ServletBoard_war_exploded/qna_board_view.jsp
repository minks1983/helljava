<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="Board.Model.*" %>
<%
BoardDto board = (BoardDto)request.getAttribute("boardDto");
%>

<html>
<head>
    <title>게시판</title>
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
</head>

<body>
<!-- 게시판 수정 -->
<table class="table table-striped">
    <tr align="center" valign="middle">
        <td colspan="2">게시판</td>
    </tr>
    
    <tr>
        <td style="font-family:돋음; font-size:12" height="16">
            <div align="center">제 목&nbsp;&nbsp;</div>
        </td>
        
        <td style="font-family:돋음; font-size:12">
        <%=board.getBoard_subject() %>
        </td>
    </tr>
    
    <tr bgcolor="cccccc">
        <td colspan="2" style="height:1px;">
        </td>
    </tr>
    
    <tr>
        <td style="font-family:돋음; font-size:12">
            <div align="center">내 용</div>
        </td>
        <td style="font-family:돋음; font-size:12">
            <table border=0 width=490 height=250 style="table-layout:fixed">
                <tr>
                    <td valign=top style="font-family:돋음; font-size:12">
                    <%=board.getBoard_content() %>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr bgcolor="cccccc">
        <td colspan="2" style="height:1px;"></td>
    </tr>
    <tr><td colspan="2">&nbsp;</td></tr>
    
    <tr align="center" valign="middle">
        <td colspan="2">
            <span>
            <a href="./BoardModify.do?num=<%=board.getBoard_num() %>">
            [수정]
            </a>&nbsp;&nbsp;
            <a href="./BoardDelete.do?num=<%=board.getBoard_num() %>">
            [삭제]
            </a>&nbsp;&nbsp;
            <a href="./boardList.do">[목록]</a>&nbsp;&nbsp;
            </span>
        </td>
    </tr>
</table>
<!-- 게시판 수정 -->
</body>
</html>