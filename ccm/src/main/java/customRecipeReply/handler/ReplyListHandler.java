package customRecipeReply.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import customRecipeReply.dao.ReplyDao;
import customRecipeReply.dto.ReplyDto;
import customRecipeReply.service.ReplyListService;


public class ReplyListHandler implements CommandHandler {
	ReplyListService service = new ReplyListService();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("ReplyListHandler 진입");
    	List<ReplyDto> replyList = service.getReplyList();
        try {
        	System.out.println("Try 실행");
            req.setAttribute("replyList", replyList);
            return "/views/screens/list.jsp";
            
        } catch (Exception e) {
        	System.out.println("예외 발생");
            req.setAttribute("errorMessage", "ReplyListHandler:Error!!");
            return null;
        }
    }
}