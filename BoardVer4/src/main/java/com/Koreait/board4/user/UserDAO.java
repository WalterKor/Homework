package com.Koreait.board4.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.Koreait.board4.DBUtils;

public class UserDAO {
	public  static  int joinUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_user (uid,upw,unm,gender) "
				   + " VALUES ( ? , ? , ? , ? ) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			DBUtils.close(con, ps);
		}
		
	}
	
	
	//로그인 성공 : 1, 아이디 없음 : 2, 비밀번호 틀림 : 3, 에러 : 0	
	public static int loginUser(UserVO param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM t_user " 
			 +"	WHERE uid = ? ";
		
		
		try {
			
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				//암호화가 된거 
				String dbpw = rs.getString("upw"); //rs.getString 레코드에서 달라고한다.
								//암호화가 안된거 	  //된거
				if(BCrypt.checkpw(param.getUpw(), dbpw)){					
					int iuser = rs.getInt("iuser");
					String unm = rs.getString("unm");
					
					param.setIuser(iuser);
					param.setUnm(unm);
					
					return 1;
				}else {
					return 3; //비밀번호가 다름 
				}
			}else {
				return 2; //아이디가 없음
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	
	 
}
