package com.portfolio.www.dao;

import java.time.LocalDateTime;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JoinDao extends JdbcTemplate {
	
	public JoinDao() {}
	
	public JoinDao(DataSource ds) {
		super(ds);
		System.out.println("\n\n ds : " + ds + "\n\n");
	}
	public int join(HashMap<String,String> params) {
		
		String sql = "INSERT INTO forum.`member` "
				+ "( member_id, passwd, member_nm, email, auth_yn, pwd_chng_dtm, join_dtm) "
				+ "VALUES( '" + params.get("memberId") 
				+ "', '" + params.get("passwd")
				+ "', '', '" + params.get("email")
				+ "', '', '', DATE_FORMAT(now(),'%Y%m%d%H%i%s'))";
		
		return update(sql);
	}

}
