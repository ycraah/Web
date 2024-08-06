package ycraah.web.web.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
  @Override
  public void init() throws ServletException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    String id = request.getParameter("user_id");
    String pw = request.getParameter("user_pw");
    String address = request.getParameter("user_address");

    String data = "<html>";
    data += "<body>";
    data += "<p>아이디 : " + id;
    data += "</p>";
    data += "<p>패스워드 : " + pw;
    data += "</p>";
    data += "</body>";
    data += "</html>";

    out.print(data);
  }

  @Override
  public void destroy() {
    
  }
}
