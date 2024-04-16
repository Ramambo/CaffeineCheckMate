package customRecipeReply.service;

import static jdbc.JdbcUtil.close;
import static jdbc.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionProvider;
import customRecipeReply.dao.CusReplyDao;
import customRecipeReply.dto.CusReplyDto;

public class CusReplyInsertService {
	
	/*댓글 삽입*/
	public int insertReply(CusReplyDto reply) throws SQLException {
		System.out.println("작성 서비스 왔슈");
		Connection conn = ConnectionProvider.getConnection();
		int result = new CusReplyDao().insertReply(conn, reply);
		
		if(result>0) {
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
}
