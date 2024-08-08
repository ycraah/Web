package ycraah.web.web.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
  private Statement stmt;
  private Connection con;
  private String url = "jdbc:oracle:thin:@//210.99.243.194:1521"; // URL 수정
  private String user = "C##scott";
  private String pwd = "tiger";

  public List<MemberVO> listMembers(){
    List<MemberVO> list = new ArrayList<MemberVO>();
    try{
      connDB();
      String query = "select * from t_member";
      System.out.println(query);
      ResultSet rs = stmt.executeQuery(query);
      while(rs.next()){
        String id = rs.getString("id");
        String pwd = rs.getString("pwd");
        String name = rs.getString("name");
        String email = rs.getString("email");
        Date joinDate = rs.getDate("joinDate");
        MemberVO vo = new MemberVO();
        vo.setId(id);
        vo.setPwd(pwd);
        vo.setName(name);
        vo.setEmail(email);
        vo.setJoinDate(joinDate);
        list.add(vo);
      }
      rs.close();
      stmt.close();
      con.close();
    } catch(Exception e){
      e.printStackTrace();
    }
    return list;
  }

  private void connDB() throws Exception{
    try{
      Class.forName("oracle.jdbc.OracleDriver");
      System.out.println("Oracle 드라이버 로딩 성공");
      con = DriverManager.getConnection(url, user, pwd);
      System.out.println("Connection 생성 성공");
      stmt = con.createStatement();
      System.out.println("Statement 생성 성공");
    } catch(Exception e){
      e.printStackTrace();
      throw e; // 원본 예외를 다시 던져서 호출자가 예외를 알 수 있게 함
    }
  }
}