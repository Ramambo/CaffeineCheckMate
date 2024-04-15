package customRecipeReply.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import customRecipeReply.dto.ReplyDto;
import customRecipeReply.service.ReplyUpdateService;


public class ReplyUpdateHandler implements CommandHandler {
	ReplyUpdateService service = new ReplyUpdateService();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("ReplyUpdateHandler 진입");
    	int cus_re_no = Integer.parseInt(req.getParameter("cus_re_no"));
    	String updatedContent = req.getParameter("updatedContent");
    	ReplyDto replyDto = new ReplyDto();
    	
        try {
        	System.out.println("Try 실행");
        	replyDto.setCus_re_no(cus_re_no);
        	replyDto.setCus_re_content(updatedContent);
            service.updateReply(replyDto);
            return null;
            
        } catch (Exception e) {
        	System.out.println("예외 발생");
            req.setAttribute("errorMessage", "ReplyUpdateHandler:Error!!");
            return null;
        }
    }
}