<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
    <title>게시판</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <script language="javascript">
    function addboard(){
        boardform.submit();
    }
    </script>
</head>
<body>
<!-- 게시판 등록 -->
<form action="BoardAddAction.do" method="post" name="boardform">
<table class="table table-striped">
    <tr align="center" valign="middle">
        <td colspan="2">게시판</td>
    </tr>
    <tr>
        <td style="font-family:돋음; font-size:12" height="16">
            <div align="center">제 목</div>
        </td>
        <td>
            <input name="BOARD_SUBJECT" type="text" size="50" maxlength="100" 
                value=""/>
        </td>
    </tr>
    <tr>
        <td style="font-family:돋음; font-size:12">
            <div align="center">내 용</div>
        </td>
        <td>
            <textarea name="BOARD_CONTENT" cols="67" rows="15"></textarea>
        </td>
    </tr>
    <tr bgcolor="cccccc">
        <td colspan="2" style="height:1px;">
        </td>
    </tr>
    <tr><td colspan="2">&nbsp;</td></tr>
    
    <tr align="center" valign="middle">
        <td colspan="2">
            <a href="javascript:addboard()">[등록]</a>&nbsp;&nbsp;
            <a href="javascript:history.go(-1)">[뒤로]</a>
        </td>
    </tr>
</table>
</form>
<!-- 게시판 등록 -->
</body>
</html>