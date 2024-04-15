package customRecipeReply.dao;
//m_id 빼놓음
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionProvider;
import customRecipeReply.dto.ReplyDto;
import jdbc.JdbcUtil;

public class ReplyDao {

    private static ReplyDao instance = new ReplyDao();

    public static ReplyDao getInstance() {
        return instance;
    }
    
    // 댓글 추가
    public int insert(ReplyDto replyDto) {
    	System.out.println("댓글 추가 메서드 호출됨");
    	int result = 0;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
    		conn = ConnectionProvider.getConnection();
    		String sql = "INSERT INTO CUSTOM_REPLY(cus_no, cus_re_regdate, cus_re_no, cus_re_content) VALUES (?, ?, ?, ?)";
    		pstmt = conn.prepareStatement(sql);
    		
    		LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formatDateTime = now.format(format);
    		
    		//pstmt.setString(1, replyDto.getM_id());
    		pstmt.setInt(1, replyDto.getCus_no());
    		pstmt.setString(2, formatDateTime);
    		pstmt.setInt(3, replyDto.getCus_re_no());
    		pstmt.setString(4, replyDto.getCus_re_content());
    		result = pstmt.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
    	}
    	return result;
    }
    
    // 모든 댓글 리스트 가져오기
    public List<ReplyDto> getList() {
    	System.out.println("댓글 리스트 가져오기 메서드 호출됨");
    	List<ReplyDto> replyList = new ArrayList<>();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
    		conn = ConnectionProvider.getConnection();
    		String sql = "SELECT cus_no, cus_re_no, cus_re_regdate, cus_re_content FROM CUSTOM_REPLY";
    		pstmt = conn.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		while (rs.next()) {
    			ReplyDto replyDto = new ReplyDto();
    			//replyDto.setM_id(rs.getString("m_id"));
    			replyDto.setCus_no(rs.getInt("cus_no"));
    			replyDto.setCus_re_no(rs.getInt("cus_re_no"));
    			replyDto.setCus_re_regdate(rs.getString("cus_re_regdate"));
    			replyDto.setCus_re_content(rs.getString("cus_re_content"));
    			replyList.add(replyDto);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
    	}
    	
    	return replyList;
    }
    
    // 댓글 번호 가져오기
    public int getCus_re_no(ReplyDto replyDto) {
    	System.out.println("댓글 번호 가져오기 메서드 호출됨");
    	int cus_re_no = 0;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
    		conn = ConnectionProvider.getConnection();
    		String sql = "SELECT cus_re_no FROM CUSTOM_REPLY";
    		pstmt = conn.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		if (rs.next()) {
    			cus_re_no = rs.getInt(1);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		JdbcUtil.close(conn);
    		JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
    	}
    	
    	return cus_re_no;
    }

    // 댓글 선택
    public ReplyDto select(int cus_re_no) {
    	System.out.println("댓글 선택 메서드 호출됨");
    	ReplyDto replyDto = null;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
    		conn = ConnectionProvider.getConnection();
    		String sql = "SELECT * FROM CUSTOM_REPLY WHERE cus_re_no=?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setInt(1, cus_re_no);
    		rs = pstmt.executeQuery();
    		if (rs.next()) {
    			replyDto = new ReplyDto();
    			//replyDto.setM_id(rs.getString("m_id"));
    			replyDto.setCus_no(rs.getInt("cus_no"));
    			replyDto.setCus_re_no(rs.getInt("cus_re_no"));
    			replyDto.setCus_re_regdate(rs.getString("cus_re_regdate"));
    			replyDto.setCus_re_content(rs.getString("cus_re_content"));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		JdbcUtil.close(conn);
    		JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
    	}
    	
    	return replyDto;
    }

  
    // 댓글 수정
    public int update(int cus_re_no, String cus_re_content) {
    	System.out.println("댓글 수정 메서드 호출됨");
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
        	conn = ConnectionProvider.getConnection();
            String sql = "UPDATE CUSTOM_REPLY SET cus_re_content=? WHERE cus_re_no=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cus_re_content);
            pstmt.setInt(2, cus_re_no);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
    		JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
        }

        return result;
    }

// 댓글 삭제
public int delete(int cus_re_no) {
	System.out.println("댓글 삭제 메서드 호출됨");
	int result = 0;
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		conn = ConnectionProvider.getConnection();
		String sql = "DELETE FROM CUSTOM_REPLY WHERE cus_re_no=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cus_re_no);
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(conn);
		JdbcUtil.close(pstmt);
	}
	
	return result;
	}
}