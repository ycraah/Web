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

    out.print("<html><head><title>로그인 내용 확인창</title></head><body>");
    out.printf("<p style=\"font-size:20px\">입력된 아이디는 %s입니다.</p>", user_id);
    out.printf("<p style=\"font-size:30px\">입력된 비밀번호는 %s입니다.</p>", user_pw);
    out.print("</body></html>");
    out.close();
  }
}
