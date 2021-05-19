package BoardCopy.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import BoardCopy.DBUtils;

public class UserDAO {

	public static void join(UserVo vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_user (uid,upw,unm,gender) "
					+" VALUES(?, ?, ?, ?) ";
		
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

	public static int login(UserVo vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM t_user " 
				 	+"	WHERE uid = ? ";
		
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String password = rs.getString("upw");
				
				if(BCrypt.checkpw(vo.getUpw(), password)) {
					
					int iuser = rs.getInt("iuser");
					String unm = rs.getString("unm");
					
					vo.setIuser(iuser);
					vo.setUnm(unm);
					
					return 1; //로그인이 성공
				}else {
					return 3; //비밀번호가 다르다
				}
				
			}else {
				return 2;//아이디가 없다. 
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;//에러메세지
		}finally {
			DBUtils.close(con, ps, rs);
			
		}
	
		
	}

}
