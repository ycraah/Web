package ycraah.web.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String command = request.getParameter("command");
    String won = request.getParameter("won");
    String operator = request.getParameter("operator");

    if(command != null && command.equals("calculate")){
      String result = calculate(Float.parseFloat(won), operator);
      out.print("<html><head><title>환율 변환 계산 결과창</title></head><body><h1>변환 결과</h1>");
      out.print("<p style=\"font-size:25px\">" + "won" + " to " + operator + "</p>");
      out.print("<p style=\"font-size:50px\">" + result + "</p></body></html>");
      return;
    }

    out.print("<html><title>환율 계산기</title>");
    out.print("<p style=\"font-size:15px\"> 환율 계산기 </p><br>");
    out.print("<form name = 'frmCalc' method='get' action='/calc'>");
    out.print("원화 : <input type = 'text' name = 'won' size =10 />");
    out.print("<select name = 'operator'>");
    out.print("<option value='dollar'>달러</option>");
    out.print("<option value='en'>엔화</option>");
    out.print("<option value='wian'>위완</option>");
    out.print("<option value='pound'>파운드</option>");
    out.print("<option value='euro'>유로</option>");
    out.print("</select>");
    out.print("<input type='hidden' name='command' value='calculate' />");
    out.print("<input type='submit' value='변환' />");
    out.print("</form>");
    out.print("</body></html>");
    out.close();
  }

  private static String calculate(float won, String operator){
    String result = null;
    if(operator.equals("dollar")){
      result = String.format("%.6f", won/1376.30);
    } else if (operator.equals("en")){
      result = String.format("%.6f", won/943.96	);
    } else if (operator.equals("wian")){
      result = String.format("%.6f", won/192.65	);
    } else if (operator.equals("pound")){
      result = String.format("%.6f", won/1754.85	);
    } else if (operator.equals("euro")){
      result = String.format("%.6f", won/1504.85);
    }
    return result;
  }
}
