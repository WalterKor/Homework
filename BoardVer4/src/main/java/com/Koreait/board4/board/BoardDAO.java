package com.Koreait.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Koreait.board4.DBUtils;

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
				+ " ON a.iuser = b.iuser ";
		
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
	
}
