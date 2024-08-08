package ycraah.web.web.db;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class MemberVO {
  private String id;
  private String pwd;
  private String name;
  private String email;
  private Date joinDate;
}
