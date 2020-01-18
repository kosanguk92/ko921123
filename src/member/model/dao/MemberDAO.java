package member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;
import static common.JDBCTemplate.close;

public class MemberDAO {

	private Properties prop = new Properties();
	
	public MemberDAO() {
		
		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties").getPath();
		System.out.println("fileName@MemberDAO="+fileName);
		
		try {
			
			
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Member selectOne(Connection conn, String memberId) {
		Member m = null;
		PreparedStatement pstmt = null; // 타입
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
		System.out.println("query="+query);
		
		System.out.println("memberDAO@memberId="+memberId);
		//1.미완성 쿼리객체 생성
		try {
			pstmt = conn.prepareStatement(query);
			
			//2.미완성쿼리 값대입
			pstmt.setString(1, memberId);
			
			//3.실행
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("memberid"));
				m.setPassword(rset.getString("password"));
				m.setMemberName(rset.getString("membername"));
				m.setMemberRole(rset.getString("memberrole"));
				m.setGender(rset.getString("gender"));
				m.setBirthDay(rset.getDate("birthday"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enrolldate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			close(rset);
			close(pstmt);
		}
		//
		return m;
	}
	
}
