package customRecipeReply.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controller.CommandHandler;
import customRecipeReply.dto.CusReplyDto;
import customRecipeReply.service.CusReplyListService;

public class CusReplyListHandler implements CommandHandler{
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("조회 핸들러 왔슈");
		
		int cus_no = Integer.parseInt(req.getParameter("cus_no"));
		ArrayList <CusReplyDto> selectReplyList = new CusReplyListService().selectReplyList(cus_no);
		
		res.setContentType("application/json;charset=utf-8");
		new Gson().toJson(selectReplyList,res.getWriter());
		return null;
	}
}
