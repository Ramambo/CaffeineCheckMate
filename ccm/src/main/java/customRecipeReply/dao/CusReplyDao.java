package customRecipeReply.dao;

import static jdbc.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import customRecipeReply.dto.CusReplyDto;

public class CusReplyDao {
	
	public CusReplyDao() {

	}
	
	
	/*글 삽입*/
	public int insertReply(Connection conn, CusReplyDto reply) {
		System.out.println("작성 DAO 왔슈");
	    int result = 0;
	    PreparedStatement pstmt = null;
	   
	    String sql = "INSERT INTO CUSTOM_REPLY(CUS_NO, CUS_RE_CONTENT) VALUES(?, ?)";
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, reply.getCus_no());
	        //pstmt.setString(1, reply.getCus_re_regdate());
	        pstmt.setString(2, reply.getCus_re_content());
	        System.out.println("작성 DAO try 왔슈");
	        
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}
	
	/*글 전체 목록*/
	public ArrayList <CusReplyDto> selectReplyList(Connection conn, int cus_no){
		System.out.println("조회 DAO 왔슈");
		ArrayList<CusReplyDto> cus_re_list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT CUS_NO, CUS_RE_NO, CUS_RE_REGDATE, CUS_RE_CONTENT FROM CUSTOM_REPLY WHERE CUS_NO = ? ORDER BY CUS_RE_REGDATE DESC";
		
		try {
			System.out.println("조회 DAO try 왔슈");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cus_no);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println("조회 DAO while 왔슈");
				cus_re_list.add(new CusReplyDto(
						rset.getInt("CUS_NO"),
						rset.getInt("CUS_RE_NO"),
						rset.getString("CUS_RE_REGDATE"),
						rset.getString("CUS_RE_CONTENT")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("cus_re_list:"+cus_re_list);
		return cus_re_list;
		
	}
}
