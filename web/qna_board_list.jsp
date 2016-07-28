<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="Board.Model.*" %>
<%
   List<BoardDto> boardList=(List<BoardDto>)request.getAttribute("boardlist");
   int listcount=(Integer)request.getAttribute("listcount");
%>

<html>
<head>
   <title>MVC 게시판</title>
   <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
</head>

<body>
<!-- 게시판 리스트 -->

<table class="table table-striped">
<%
if(listcount > 0){
%>
   <tr align="center" valign="middle">
      <td colspan="3">게시판</td>
      <td align=right>
         <span>글 개수 : ${listcount }</span>
      </td>
   </tr>
   
   <tr align="center" valign="middle" bordercolor="#333333">
      <td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
         <div align="center">번호</div>
      </td>
      <td style="font-family:Tahoma;font-size:8pt;" width="50%">
         <div align="center">제목</div>
      </td>
      <td style="font-family:Tahoma;font-size:8pt;" width="17%">
         <div align="center">날짜</div>
      </td>
   </tr>
   
   <%
      for(int i=0;i<boardList.size();i++){
         BoardDto bl=(BoardDto)boardList.get(i);
   %>
   <tr align="center" valign="middle" bordercolor="#333333"
      onmouseover="this.style.backgroundColor='F8F8F8'"
      onmouseout="this.style.backgroundColor=''">
      <td height="23" style="font-family:Tahoma;font-size:10pt;">
         <%=bl.getBoard_num()%>
      </td>
      
      <td style="font-family:Tahoma;font-size:10pt;">
         <div align="left">
         <a href="BoardDetailAction.do?num=<%=bl.getBoard_num()%>">
            <%=bl.getBoard_subject()%>
         </a>
         </div>
      </td>
      <td style="font-family:Tahoma;font-size:10pt;">
         <div align="center"><%=bl.getBoard_date() %></div>
      </td>   
   </tr>
   <%} %>
   <%
    }
   else
   {
   %>
   <tr align="center" valign="middle">
      <td colspan="3">게시판</td>
      <td align=right>
         <span>등록된 글이 없습니다.</span>
      </td>
   </tr>
   <%
   }
   %>
   <tr align="right">
      <td colspan="3">
            <a href="BoardWrite.do">[글쓰기]</a>
      </td>
   </tr>
</table>

</body>
</html>