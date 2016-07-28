//기존에 작업했던 서비스 계층
//글을 쓰는 서비스 
//Action 패키지 안에 구현

package Board.Action;

import Board.Model.BoardDao;
import Board.Model.BoardDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class BoardAddAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        BoardDao boardDao = BoardDao.getInstance();
        BoardDto boardDto = new BoardDto();

        int maxBoardNum = boardDao.getMaxBoardNum();

        boardDto.setBoard_num(maxBoardNum);
        boardDto.setBoard_subject(request.getParameter("BOARD_SUBJECT"));
        boardDto.setBoard_content(request.getParameter("BOARD_CONTENT"));
        boardDto.setBoard_date(String.format("%s", LocalDate.now()));

        boolean result = false;
        try {
            // insert 할 객체를 구성
            result = boardDao.boardInsert(boardDto);
            if (result == false) {
                System.out.println("Insert Fail");
                return null;
            }
            System.out.println("Insert success");

            boardDao.BOARD_MAX_NUM++;
            // ////////////////////////////////////
            ActionForward forward = new ActionForward();
            forward.setRedirect(false);
            forward.setPath("boardList.do");
            return forward;
            // //////////////////////////////////

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
