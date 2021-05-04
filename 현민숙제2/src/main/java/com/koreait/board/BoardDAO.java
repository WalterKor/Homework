package com.koreait.board;

import java.security.DrbgParameters.Reseed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	public static void insert(BoardVO2 bo) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_board " + " (title,ctnt) " + " VALUES " + " (? , ?) ";

		try {

			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, bo.getTitle());
			ps.setString(2, bo.getTitle());
			System.out.println(ps.toString());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DBUtils.close(con, ps);
		}

	}
	
	public static List<BoardVO2> AllSelect(){
		
		List<BoardVO2> list = new ArrayList<BoardVO2>();//BoardVO만 들어갈수있는 리스트를 생성한다. 
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT iboard,title,regdt FROM t_board "
					+ " ORDER BY iboard DESC ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				BoardVO2 vo = new BoardVO2();
				list.add(vo);
				
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt= rs.getString("regdt");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}

	public static BoardVO2 selBoard(int iboard) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM t_board "
					+" WHERE iboard = ? ";
				
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				BoardVO2 vo = new BoardVO2();
				
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setRegdt(regdt);
				
				return vo;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		return null;
	}

	public static void delBoard(BoardVO2 vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " DELETE FROM t_board "
					+ " WHERE iboard = ? ";

		try {
			
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		
	}

	public static void UpdateBoard(BoardVO2 bo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " UPDATE t_board "
				+ " SET title = ? "
				+ " , ctnt = ? "
				+ " WHERE iBoard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, bo.getTitle());
			ps.setString(2, bo.getCtnt());
			ps.setInt(3, bo.getIboard());
			
			ps.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		
		}
		
		
	}
	

}
