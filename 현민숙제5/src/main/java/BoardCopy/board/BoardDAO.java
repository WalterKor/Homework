package BoardCopy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.DbDoc;

import BoardCopy.DBUtils;

public class BoardDAO {

	public static void insboard(BoardVO bo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_board (title,ctnt,iuser) "
					+" VALUES (?, ?, ?) ";
		
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, bo.getTitle());
			ps.setString(2, bo.getCtnt());
			ps.setInt(3, bo.getIuser());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
			
		}
				
		
	}

	public static List<BoardVO> AllselList() {
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT a.iboard, a.title, a.iuser, a.regdt, b.unm "
				+ " FROM t_board a "
				+ " LEFT JOIN t_user b "
				+ " ON a.iuser = b.iuser "
				+ " ORDER BY a.iboard DESC ";
		
		
		try {
			
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("00000");
				BoardVO bo = new BoardVO();
				bo.setIboard(rs.getInt("iboard"));
				bo.setTitle(rs.getString("title"));
				bo.setIuser(rs.getInt("iuser"));
				bo.setRegdt(rs.getString("regdt"));
				bo.setUnm(rs.getString("unm"));
				
				
				list.add(bo);
			}
				return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			DBUtils.close(con, ps, rs);
			
		}
		return list;
	}

	public static BoardVO selBoard(int iboard) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT a.iboard, a.title, a.ctnt, a.regdt,a.iuser,b.unm "
				+ "FROM t_board a "
				+ "LEFT JOIN t_user b "
				+ "ON a.iuser = b.iuser "
				+ " where iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardVO bo = new BoardVO();
				bo.setIboard(iboard);
				bo.setTitle(rs.getString("title"));
				bo.setCtnt(rs.getString("ctnt"));
				bo.setRegdt(rs.getString("regdt"));
				bo.setIuser(rs.getInt("iuser"));
				bo.setUnm(rs.getString("unm"));
				
				return bo;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		return null;
	}


	public static void remove(BoardVO vo) {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql =" DELETE FROM t_board "
			     + " WHERE iboard = ? "
			     + " and iuser = ? ";
	
		
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		
	}

}
