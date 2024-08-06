package ycraah.web.web.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  @Override
  public void init() throws ServletException {
    System.out.println("init 메서드 호출");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String user_id = request.getParameter("user_id");
    String user_pw = request.getParameter("user_pw");
    System.out.println("아이디: " + user_id);
    System.out.println("패스워드: " + user_pw);
  }

  @Override
  public void destroy() {
    System.out.println("destroy 메서드 호출");
  }
}
