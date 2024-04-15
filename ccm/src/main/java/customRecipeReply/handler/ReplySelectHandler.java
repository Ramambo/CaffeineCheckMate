package customRecipeReply.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import customRecipeReply.dto.ReplyDto;
import customRecipeReply.service.ReplySelectService;

public class ReplySelectHandler implements CommandHandler {
	ReplySelectService service = new ReplySelectService();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("ReplySelectHandler 진입");
    	int cus_re_no = Integer.parseInt(req.getParameter("cus_re_no"));
    	ReplyDto replyDto = service.selectReply(cus_re_no);
    	
    	try {
        	System.out.println("Try 실행");
    	    //req.setAttribute("replyDto", replyDto);
    	    req.setAttribute("replyList", replyDto);
            return null;
    	    
    	} catch (Exception e) {
        	System.out.println("예외 발생");
    	    req.setAttribute("errorMessage", "ReplySelectHandler:Error!!");
            return null;
    	}
    }
}
