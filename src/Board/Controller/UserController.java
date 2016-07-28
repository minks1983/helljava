package Board.Controller;

import Board.Action.Action;
import Board.Action.ActionForward;
import Board.Action.LoginAction;
import Board.Action.LoginView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by minkyoungsoo on 2016. 7. 27..
 */
public class UserController extends HttpServlet {

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

        ActionForward forward = null;
        Action action = null;

        if(command.equals("/LoginView.wo")){
            System.out.println("LoginView");

            //필요한 Action
            action = new LoginView();

            try {
                forward = action.execute(request, response);
            } catch (Exception e) {

            }
        } else if(command.equals("/LoginAction.wo")){
            System.out.println("LoginAction");

            //필요한 Action
            action = new LoginAction();

            try {
                forward = action.execute(request, response);
            } catch (Exception e) {

            }
        }

        if(forward != null){
            if(forward.isRedirect()){
                System.out.println("forward.isRedirect : " + forward.isRedirect());
                response.sendRedirect(forward.getPath());
            }else{
                System.out.println("forward.getPath() : " + forward.getPath());
                request.getRequestDispatcher(forward.getPath()).forward(request, response);
            }
        }
    }
}
