package com.korea.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	public static void insertBoard(BoardVO3 bo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT into t_board (title,ctnt) "
					+" VALUES( ? , ? ) ";


		
		try {
			
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, bo.getTitle());
			ps.setString(2, bo.getCtnt());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			DBUtils.close(con, ps);
		}
				
				
	}

	public static List<BoardVO3> AllSelect() {
		
		List<BoardVO3> list = new ArrayList<BoardVO3>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT iboard,title,regdt FROM t_board "
				+" ORDER BY iboard DESC ";
		
		try {
			
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO3 vo = new BoardVO3();
				list.add(vo);
				
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String date = rs.getString("regdt");
				
				vo.setDate(date);
				vo.setIboard(iboard);
				vo.setTitle(title);
				
								
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
	
		
		return list;
	}

	public static BoardVO3 selBoard(int iboard) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_board WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardVO3 bo = new BoardVO3();
				
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String date = rs.getString("regdt");
				
				bo.setTitle(title);
				bo.setIboard(iboard);
				bo.setCtnt(ctnt);
				bo.setDate(date);
				
				return bo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		return null;
	}

	public static void Upload(BoardVO3 vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE t_board "
				+ " SET title = ? "
				+ " , ctnt = ? "
				+ " WHERE iBoard = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		
		
	}

	public static void remove(int iboard) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql =" DELETE FROM t_board "
				+ " WHERE iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
	}
	
	
	

}
