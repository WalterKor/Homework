package BoardCopy.Cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import BoardCopy.DBUtils;

public class CmtDAO {

	public static void insertCmt(CmtVo c) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_board_cmt "
				+ " (iboard, iuser, cmt) "
				+ " VALUES (?, ?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, c.getIboard());
			ps.setInt(2, c.getIuser());
			ps.setString(3, c.getCmt());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		
	}

	public static void updCmt(CmtVo c) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " UPDATE t_board_cmt "
				+ " SET cmt = ? "
				+ " WHERE icmt = ? "
				+ " AND Iuser = ? ";

		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, c.getCmt());
			ps.setInt(2, c.getIcmt());
			ps.setInt(3, c.getIuser());
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
	}

	public static List<CmtVo> selCmtList(int iboard) {
		List<CmtVo> list = new ArrayList<CmtVo>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT B.unm, A.iuser "
				+ " , A.icmt, A.cmt, A.regdate "
				+ " FROM t_board_cmt A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " WHERE iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CmtVo vo = new CmtVo();
				vo.setIcmt(rs.getInt("icmt"));
				vo.setCmt(rs.getString("cmt"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				
				list.add(vo);
			}
					
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	

}
