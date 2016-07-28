package Board.Action;

import Board.Model.BoardDao;
import Board.Model.BoardDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDetailAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        //view 단 구성
        //글번호를 가지고 와서 
        int num =Integer.parseInt(request.getParameter("num"));
        BoardDao boardDao = BoardDao.getInstance();
        BoardDto boardDto = new BoardDto();

        boardDto = boardDao.getDetail(num);
        
        if(boardDto == null){
            System.out.println("게시판 글이 null인디??");
            return null;
        }
        System.out.println("boardbean Data 완료");
        
        request.setAttribute("boardDto",boardDto);
        System.out.println(">>>>>>"+request.toString());
        System.out.println("검증: " +request.getAttribute("gogo"));
        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("qna_board_view.jsp");
        return forward;
    
    }

}
