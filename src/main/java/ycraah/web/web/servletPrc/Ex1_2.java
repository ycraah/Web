package ycraah.web.web.servletPrc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginTest2")
public class Ex1_2 extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String user_id = request.getParameter("user_id");
    String user_pw = request.getParameter("user_pw");

    boolean idValid = (user_id != null && user_id.length() != 0);
    boolean pwValid = (user_pw != null && user_pw.length() != 0);
    boolean isAdmin = (user_id.equals("admin") && user_pw.equals("1234"));

    if(!idValid){
      out.print("<html><head><title>로그인 실패</title></head><body>");
      out.print("<p>아이디를 입력하세요!!</p><br>");
      out.print("<a href='http://localhost:8080/loginTest.html'>로그인 창으로 이동</a>");
      out.print("</body></html>");
    } else if(!pwValid){
      out.print("<html><head><title>로그인 실패</title></head><body>");
      out.print("<p>비밀번호를 입력하세요!!</p><br>");
      out.print("<a href='http://localhost:8080/loginTest.html'>로그인 창으로 이동</a>");
      out.print("</body></html>");
    } else if(isAdmin) {
      out.print("<html><head><title>관리자 페이지</title></head><body>");
      out.print("<p style=\"font-size:30px\">관리자로 로그인하셨습니다.</p>");
      out.print("<input type=\"button\" value=\"회원정보 수정하기\" style=\"margin-right:30px\">");
      out.print("<input type=\"button\" value=\"회원정보 삭제하기\">");
      out.print("</body></html>");
    } else {
      out.print("<html><head><title>로그인 성공</title></head><body>");
      out.printf("<p>%s님의 로그인을 환영합니다.</p>", user_id);
      out.print("</body></html>");
    }
  }
}
