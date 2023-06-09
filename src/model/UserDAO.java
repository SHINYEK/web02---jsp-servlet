package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	//사용자 정보
	public UserVO read(String uid) {
		UserVO vo = new UserVO();
		try {
			String sql = "select * from users where uid = ?";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setUid(rs.getString("uid"));
				vo.setUpass(rs.getString("upass"));
				vo.setUname(rs.getString("uname"));
			}
		}catch(Exception e) {
			System.out.println("사용자정보오류"+e.toString());
		}
		return vo;
	}
}
