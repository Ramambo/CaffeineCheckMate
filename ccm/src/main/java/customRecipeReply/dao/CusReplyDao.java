package customRecipeReply.dao;

import static jdbc.JdbcUtil.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import customRecipeReply.dto.CusReplyDto;

public class CusReplyDao {
	private Properties prop = new Properties();
	
	public CusReplyDao() {
		try {
			prop.loadFromXML(new FileInputStream(CusReplyDao.class.getResource("/WEB-INF/reply-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*글 삽입*/
	public int insertReply(Connection conn, CusReplyDto reply) {
		System.out.println("작성 DAO 왔슈");
	    int result = 0;
	    PreparedStatement pstmt = null;
	    String sql = prop.getProperty("insertReply");
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, reply.getCus_no());
	        pstmt.setString(2, reply.getCus_re_regdate());
	        pstmt.setString(3, reply.getCus_re_content());
	        
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
		String sql = prop.getProperty("selectReplyList");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cus_no);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
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
		
		return cus_re_list;
		
	}
}
