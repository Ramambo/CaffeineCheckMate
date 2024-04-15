package customRecipeReply.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;
import customRecipeReply.dto.ReplyDto;
import customRecipeReply.service.ReplyWriteService;

public class ReplyWriteHandler implements CommandHandler {
	ReplyWriteService service = new ReplyWriteService();
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
    	System.out.println("ReplyWriteHandler 진입");
    	String writeReply = req.getParameter("writeReply");
    	ReplyDto replyDto = new ReplyDto();
    	
        try {
        	System.out.println("Try 실행");
        	replyDto.setCus_re_content(writeReply);
            service.writeReply(replyDto);
            return null; 
            //리턴값이 없어야 하는데 프론트에서 예외처리로 인한 500에러, 값은 DB에 잘 들어감
            //return "/views/screens/list.jsp"; //뷰페이지를 반환하면 페이지 코드 전체가 출력됨
            
        } catch (Exception e) {
        	System.out.println("예외 발생 ");
            req.setAttribute("errorMessage", "ReplyWriteHandler:Error!!");
            return null;
        }
    }
}