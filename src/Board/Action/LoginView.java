package Board.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by minkyoungsoo on 2016. 7. 28..
 */
public class LoginView implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String path = "qna_board_login.jsp";

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath(path);
        return forward;
    }
}
