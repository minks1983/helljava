package Board.Controller;

import Board.Action.Action;
import Board.Action.ActionForward;
import Board.Action.BoardAddAction;
import Board.Action.BoardDeleteAction;
import Board.Action.BoardDetailAction;
import Board.Action.BoardListAction;
import Board.Action.BoardModifyAction;
import Board.Action.BoardModifyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by minkyoungsoo on 2016. 7. 16..
 */
public class BoardController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Process(request, response);
    }
    
    private void Process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String RequestURI = request.getRequestURI();
        String ContextPath = request.getContextPath();
        String command = RequestURI.substring(ContextPath.length());

        System.out.println("RequestURI : " + RequestURI);
        System.out.println("ContextPath : " + ContextPath);
        System.out.println("command : " + command);

        // 일괄 처리를 위해서
        ActionForward forward = null;
        Action action = null;

        HttpSession httpSession = request.getSession(false);
        if(httpSession == null){
            System.out.println("로긴페이지 시작");
            // 로그인 화면으로 전환...
            forward = new ActionForward();
            forward.setRedirect(true);
            forward.setPath("LoginView.wo");
        } else {
            forward = Routing(request, response, forward, action, command);
        }
        
        if (forward != null) {
            if (forward.isRedirect()) {
                System.out.println("forward.isRedirect : " + forward.isRedirect());
                response.sendRedirect(forward.getPath());
            } else {
                System.out.println("forward.getPath() : " + forward.getPath());
                request.getRequestDispatcher(forward.getPath()).forward(request, response);
            }
        }
    }
    
    private ActionForward Routing(HttpServletRequest request, HttpServletResponse response, ActionForward forward, Action action, String command) {
        if(command.equals("/boardList.do")){
            System.out.println("BoardList Display");

            //필요한 Action
            action = new BoardListAction();

            try {
                forward = action.execute(request, response);
            } catch (Exception e) {

            }
        }else if(command.equals("/BoardWrite.do")){
            // 글쓰기 화면으로 전환...
            forward = new ActionForward();
            forward.setRedirect(true);
            forward.setPath("qna_board_write.jsp");
        }else if(command.equals("/BoardAddAction.do")){
            action = new BoardAddAction();

            try {
                forward = action.execute(request, response);
            } catch (Exception e) {

            }
        }else if(command.equals("/BoardDetailAction.do")){
            System.out.println("Before_BoardDetailAction");
            System.out.println("num : " + request.getParameter("num"));

            action = new BoardDetailAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {

            }
        }else if(command.equals("/BoardDelete.do")){
            // 글쓰기 화면으로 전환...
            forward = new ActionForward();
            forward.setRedirect(false);
            forward.setPath("qna_board_delete.jsp");
        }else if(command.equals("/BoardDeleteAction.do")){
            action = new BoardDeleteAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {

            }
        }else if(command.equals("/BoardModify.do")){
            action = new BoardModifyView();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {

            }
        }else if(command.equals("/BoardModifyAction.do")){
            action = new BoardModifyAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {

            }
        }
        
        return forward;
    }
}
