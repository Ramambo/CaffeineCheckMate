package customRecipeReply.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import customRecipeReply.service.ReplyDeleteService;

public class ReplyDeleteHandler implements CommandHandler {
	ReplyDeleteService service = new ReplyDeleteService();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("ReplyDeleteHandler 진입");
    	int cus_re_no = Integer.parseInt(req.getParameter("cus_re_no"));

    	try {
        	System.out.println("Try 실행");
            service.deleteReply(cus_re_no);
            return null;
            
        } catch (Exception e) {
        	System.out.println("예외 발생");
            req.setAttribute("errorMessage", "ReplyDeleteHandler:Error!!");
            return null;
        }
    }
}