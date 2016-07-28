package Board.Action;

import Board.Model.UserDao;
import Board.Model.UserDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by minkyoungsoo on 2016. 7. 27..
 */
public class LoginAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        UserDao userDao = UserDao.getInstance();
        UserDto userDto = userDao.getUser(id);
        
        String path = "LoginView.wo";
        
        if(userDto != null && id.equals(userDto.getId()) && password.equals(userDto.getPassword())) {
            HttpSession session=request.getSession();
            session.setAttribute("id", id);
            
            path = "boardList.do";
        }
        
        ActionForward forward = new ActionForward();
        forward.setRedirect(true);
        forward.setPath(path);
        return forward;
    }
}
