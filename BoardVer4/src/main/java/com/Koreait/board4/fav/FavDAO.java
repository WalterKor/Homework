package com.Koreait.board4.fav;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Koreait.board4.DBUtils;

public class FavDAO {
	
	public static void insFav(int iboard, int iuser) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_board_fav(iboard,iuser) "
					+" VALUES (?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			ps.setInt(2, iuser);
			
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static void delFav(int iboard, int iuser) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " DELETE FROM t_board_fav " 
					+" WHERE iboard =? AND iuser =? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			ps.setInt(2, iuser);		
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtils.close(con, ps);
		}
	}
}
