package Board.Action;

import Board.Model.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class BoardDeleteAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        boolean result = false;
        int num = Integer.parseInt(request.getParameter("num"));

        BoardDao boardDao = BoardDao.getInstance();
        result = boardDao.boardDelete(num);
        
        if(result == false){
            System.out.println("게시물 삭제 실패");
            return null;
        }
        System.out.println("게시물 삭제 성공");
        
        ///////////////////////////////////////////////////
        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("boardList.do");
        return forward;
        
        
    }

}
