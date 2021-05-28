package Review.koreait.board.user;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Review.koreait.board.DBUtils;

public class UserDAO {

	public static void join(UserEntitiy vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_user (uid,upw,unm,gender,iuser) "
				   + " VALUES ( ?, ?, ?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			ps.setString(2, vo.getUpw());
			ps.setString(3, vo.getUnm());
			ps.setInt(3, vo.getGender());
			ps.setInt(4, vo.getIuser());
			ps.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		
	}

}
