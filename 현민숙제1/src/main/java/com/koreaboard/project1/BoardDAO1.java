package com.koreaboard.project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO1 {

	public static void insert(BoardVO1 vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql =" INSERT INTO t_board (title, ctnt) "
				+ " VALUES ( ? , ? ) ";
		     	
		
		try {
			
			con = DBUtilsBoard1.getCon(); //데이터 베이스야 준비해라
			ps = con.prepareStatement(sql); //실행문장 준비해라
			
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			
			System.out.println(ps.toString());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtilsBoard1.close(con, ps);
		}
		
	}
	
	public static List<BoardVO1> selBoardList(){
		
		List<BoardVO1> list = new ArrayList<BoardVO1>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		String sql = "SELECT iboard, title,regdt from t_board"
				   +" ORDER BY iboard DESC ";
		
		try {
			
			con = DBUtilsBoard1.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); //쿼리문 종료
			
			while(rs.next()) {
				BoardVO1 vo = new BoardVO1();
				list.add(vo);
				
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String ctnt = rs.getString("regdt");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(ctnt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtilsBoard1.close(con, ps, rs);//꼭 닫아주기
		}
		
		return list;
	}

	public static BoardVO1 selBoard(int iboard) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM t_board WHERE iboard = ?";
		
		try {
			con = DBUtilsBoard1.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardVO1 vo = new BoardVO1();
				
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				
				vo.setIboard(iboard);
				vo.setCtnt(ctnt);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				
				return vo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtilsBoard1.close(con, ps, rs);
		}
		
		
		return null;
	}

	public static void del(BoardVO1 vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM t_board WHERE iboard = ?";
		ResultSet rs = null;
		
		try {
			con = DBUtilsBoard1.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DBUtilsBoard1.close(con, ps);
	}

	public static void UPDATE(BoardVO1 vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE t_board "
				+ " SET title = ? "
				+ " , ctnt = ? "
				+ " WHERE iBoard = ? ";
		
		try {
			
			con = DBUtilsBoard1.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtilsBoard1.close(con, ps);
		}
				
				
		
	}




}

/*
 	public static void insert(BoardVO1 vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql =" INSERT INTO t_board (title, ctnt) VALUES "
			     	+" ( ? , ? ) ";
		try {
			DBUtilsBoard1.getCon();//실행준비
			ps = con.prepareStatement(sql);//문장준비
			
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			
			System.out.println(ps.toString());
			ps.executeUpdate(); //실행종료
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			DBUtilsBoard1.close(con, ps);
		}
	} 
*/