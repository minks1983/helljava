package Board.Action;

import Board.Model.BoardDao;
import Board.Model.BoardDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class BoardModifyAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        
        boolean result = false;
        
        int num = Integer.parseInt(request.getParameter("BOARD_NUM"));

        BoardDao boardDao = BoardDao.getInstance();
        BoardDto boardDto = new BoardDto();

        //실수정 (글제목 , 글내용) => qna_board_Modify.jsp
        boardDto.setBoard_num(num);
        boardDto.setBoard_subject(request.getParameter("BOARD_SUBJECT"));
        boardDto.setBoard_content(request.getParameter("BOARD_CONTENT"));
        
        result = boardDao.boardModify(boardDto);
        
        if(result == false){
            System.out.println("게시판 수정 실패");
            return null;
        }
        System.out.println("게시판 수정 성공");
        
        ActionForward forward = new ActionForward();
        forward.setRedirect(true);
        forward.setPath("BoardDetailAction.do?num="+boardDto.getBoard_num());
        return forward;
    }

}
