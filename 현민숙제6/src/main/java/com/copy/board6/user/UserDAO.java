package com.copy.board6.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.copy.board6.DBUtils;

public class UserDAO {

	public static void join(UserVO vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql =" INSERT INTO t_user (uid,upw,unm,gender) "
			 + " VALUE ( ?, ?, ?, ?) ";
			 
		
		try {
			
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			ps.setString(2, vo.getUpw());
			ps.setString(3, vo.getUnm());
			ps.setInt(4, vo.getGender());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
			
		}
		
	}

	public static void login(UserVO vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT upw FROM t_user "
				+ " WHERE uid = ? ";
				
		try {
			
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
			
		}
		
	}

}
