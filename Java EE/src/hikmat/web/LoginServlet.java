package hikmat.web;

import hikmat.dao.LoginDao;
import hikmat.dao.LoginDaoImpl;
import hikmat.model.Login;
import hikmat.service.LoginService;
import hikmat.service.LoginServiceImpl;
import hikmat.util.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "LoginServlet", urlPatterns = "/ls")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String address = "";
        String action = "";
        LoginDao loginDao = new LoginDaoImpl();
        LoginService loginService = new LoginServiceImpl(loginDao);

        try {
            if(request.getParameter("action") != null){
                action = request.getParameter("action");
            }
            if(action.equalsIgnoreCase("login")){
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
                    Login login = loginService.login(username, password);
                    if (login != null) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("login",login);
                        address = "index.jsp";
                    } else {
                        request.setAttribute("invalid", "Username or password is invalid!");
                        address = "login.jsp";
                    }
                } else {
                    request.setAttribute("invalid", "Username or password is empty!");
                    address = "login.jsp";
                }
            }else if(action.equalsIgnoreCase("forgotPassword")){
                address = "forgotPassword.jsp";
            }else if(action.equalsIgnoreCase("forgot")){
                String email = request.getParameter("email");
                Login login = loginService.checkEmail(email);
                String token = UUID.randomUUID().toString();
                if(login != null) {
                    boolean isUpdate = loginService.updateToken(token,login.getId());
                    if(isUpdate) {
                        String text = "http://localhost:8080/test/ls?action=changePassword?token="+token;

                    }else{
                        request.setAttribute("invalid","Generate token problem");

                    }
                } else{
                    request.setAttribute("invalid","User not found!");

                }
            }
            if(address != null ){
                RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
