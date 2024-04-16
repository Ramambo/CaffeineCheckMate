package customRecipeReply.service;

import static jdbc.JdbcUtil.close;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionProvider;
import customRecipeReply.dao.CusReplyDao;
import customRecipeReply.dto.CusReplyDto;

public class CusReplyListService {
	
	public ArrayList<CusReplyDto> selectReplyList(int cus_no) throws SQLException{
		System.out.println("조회 서비스 왔슈");
		
		Connection conn = ConnectionProvider.getConnection();
		conn.setAutoCommit(false);
		
		ArrayList<CusReplyDto> cus_re_list = new CusReplyDao().selectReplyList(conn,cus_no);
		
		close(conn);
		return cus_re_list;
	}
}
