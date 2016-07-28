package Board.Action;

import Board.Model.BoardDao;
import Board.Model.BoardDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardModifyView implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        int num =Integer.parseInt(request.getParameter("num"));
        BoardDao boardDao = BoardDao.getInstance();
        BoardDto boardDto = new BoardDto();
        boardDto =boardDao.getDetail(num);
        if(boardDto == null){
            System.out.println("수정 상세보기 실패");
            return null;
        }
        System.out.println("수정 상세보기 성공");
        
        request.setAttribute("boarddata", boardDto);
        
        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("qna_board_modify.jsp");
        return forward;
        
        
    }

}
