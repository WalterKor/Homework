package com.Koreait.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Koreait.board4.DBUtils;
import com.mysql.cj.result.SqlDateValueFactory;

public class BoardDAO {
	public static int insBoard(BoardVo param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " Insert Into t_board "
					+ "( title, ctnt, iuser )"
					+ " values "
					+ "(?, ?, ?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}finally {
			DBUtils.close(con, ps);
		}
		
	}
	
	public static List<BoardVo> selboard(){ 
		List<BoardVo> list = new ArrayList<BoardVo>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT a.iboard, a.title, a.iuser, a.regdt, b.unm "
				+ " FROM t_board a "
				+ " LEFT JOIN t_user b "
				+ " ON a.iuser = b.iuser "
				+ " ORDER BY a.iboard DESC ";
		
		try {
			con= DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
					
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
				
				list.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
		
	}

	public static  BoardVo pickboard(BoardVo param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = 	"SELECT a.iboard, a.title, a.ctnt, a.regdt,a.iuser,b.unm , if(c.iuser IS NULL, 0 , 1) AS isFav"
					+" FROM t_board a " 
					+" LEFT JOIN t_user b " 
					+" ON a.iuser = b.iuser " 
					+" LEFT JOIN t_board_fav C "
					+" ON a.iboard = c.iboard "
					+" AND c.iuser =  ? "
					+" WHERE a.iboard = ? "; 
			
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIuser());
			ps.setInt(2, param.getIboard());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				BoardVo bo = new BoardVo();
				//결과물의 컬럼명을 적어줘야한다. 결과물의 컬럼명!!!
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				int iuser = rs.getInt("iuser");
				String unm = rs.getString("unm");
				int isFav = rs.getInt("isFav");
				
				bo.setIboard(param.getIboard());
				bo.setTitle(title);
				bo.setCtnt(ctnt);
				bo.setRegdt(regdt);
				bo.setUnm(unm);
				bo.setIuser(iuser);
				bo.setIsFav(isFav);
				
				return bo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		return null;			
	}

	
	public static void remove(BoardVo bo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql =" DELETE FROM t_board "
				     + " WHERE iboard = ? "
				     + " and iuser = ? ";
		
		try {
			
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, bo.getIboard());
			ps.setInt(2, bo.getIuser());
			ps.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		
	}

	public static void updateBoard(BoardVo vo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " UPDATE t_board "
				+ " SET title = ? "
				+ " , ctnt = ? "
				+ " WHERE iBoard = ? "
				+ " AND Iuser = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			ps.setInt(4, vo.getIuser());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
	}
	
	
}
