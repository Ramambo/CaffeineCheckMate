package customRecipeReply.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConnectionProvider;
import controller.CommandHandler;
import customRecipeReply.dto.CusReplyDto;
import customRecipeReply.service.CusReplyInsertService;
import jdbc.JdbcUtil;

public class CusReplyInsertHandler implements CommandHandler{
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("작성 핸들러 왔슈--1");
		
		Connection conn = null;
		conn = ConnectionProvider.getConnection();
		
		int cus_no = Integer.parseInt(req.getParameter("cus_no"));
        System.out.println(cus_no);
//        String cus_re_regdate = req.getParameter("cus_re_regdate");
//        System.out.println(cus_re_regdate);
        String cus_re_content = req.getParameter("cus_re_content");
        System.out.println(cus_re_content);

        System.out.println("작성 핸들러 왔슈--2");
        CusReplyDto reply = new CusReplyDto();
        reply.setCus_no(cus_no);
//        reply.setCus_re_regdate(cus_re_regdate);
        reply.setCus_re_content(cus_re_content);
        System.out.println("작성 핸들러 왔슈--3");

        int result = new CusReplyInsertService().insertReply(reply);
        res.getWriter().print(result);
        System.out.println("result:"+result);
        System.out.println("작성 핸들러 왔슈--4");
        
        JdbcUtil.close(conn);

        return "CusReplyList.do";
	}
}
