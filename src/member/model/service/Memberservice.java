package member.model.service;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;
import static common.JDBCTemplate.*;

public class Memberservice {

	public Member selectOne(String memberId) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Member m = new MemberDAO().selectOne(conn,memberId);
		close(conn);
		return m;
	}

}
