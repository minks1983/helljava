<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="Board.Model.*" %>
<%
    BoardDto board = (BoardDto)request.getAttribute("boarddata");
%>

<html>
<head>
    <title>게시판</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <script type="text/javascript">
    function modifyboard(){
        modifyform.submit();
    }
    </script>
</head>

<body>
<!-- 게시판 수정 -->
<form action="BoardModifyAction.do" method="post" name="modifyform">
<input type="hidden" name="BOARD_NUM" value=<%=board.getBoard_num() %>>
<table class="table table-striped">
    <tr align="center" valign="middle">
        <td colspan="2">게시판</td>
    </tr>
    <tr>
        <td height="16" style="font-family:돋음; font-size:12">
            <div align="center">제 목</div>
        </td>
        <td>
            <input name="BOARD_SUBJECT" size="50" maxlength="100" 
                value="<%=board.getBoard_subject()%>">
        </td>
    </tr>
    <tr>
        <td style="font-family:돋음; font-size:12">
            <div align="center">내 용</div>
        </td>
        <td>
            <textarea name="BOARD_CONTENT" cols="67" rows="15"><%=board.getBoard_content() %></textarea>
        </td>
    </tr>
    <tr bgcolor="cccccc">
        <td colspan="2" style="height:1px;">
        </td>
    </tr>
    <tr><td colspan="2">&nbsp;</td></tr>
    
    <tr align="center" valign="middle">
        <td colspan="5">
            <font size=2>
            <a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
            <a href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp;
            </font>
        </td>
    </tr>
</table>
</form>
<!-- 게시판 수정 -->
</body>
</html>