package ycraah.web.web.servletPrc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/loginTest")
public class Ex1_1 extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String user_id = request.getParameter("user_id");
    String user_pw = request.getParameter("user_pw");

    System.out.println("아이디 : " + user_id);
    System.out.println("비밀번호 : " + user_pw);

    if((user_id != null || user_id.length() != 0) || (user_pw != null || user_pw.length() != 0)){
      out.print("<html><head><title>로그인 성공</title></head><body>");
      out.printf("<p>%s님의 로그인을 환영합니다.</p>", user_id);
      out.print("</body></html>");
    } else {
      out.print("<html><head><title>로그인 실패</title></head><body>");
      out.print("<p>아이디를 입력하세요!!</p><br>");
      out.print("<a href='http://localhost:8080/loginTest.html'>로그인 창으로 이동</a>");
      out.print("</body></html>");
    }

  }
}
