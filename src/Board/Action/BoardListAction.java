package Board.Action;

import Board.Model.BoardDao;
import Board.Model.BoardDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

//이 클래스는 Client 게시판 리스트에 대한 행위를 했을 경우 실행....

public class BoardListAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request,
         HttpServletResponse response) throws Exception {


      BoardDao boardDao = BoardDao.getInstance();
      List<BoardDto> boardlist = new ArrayList<BoardDto>();
      int listcount = 0;

      boardlist = boardDao.getBoardList();
      listcount = boardDao.getListCount();
      request.setAttribute("boardlist", boardlist);
      request.setAttribute("listcount", listcount); // 글 수

      // forward 대한 처리 로직///////////////////////////
      ActionForward forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath("qna_board_list.jsp");
      return forward;
   }

}





