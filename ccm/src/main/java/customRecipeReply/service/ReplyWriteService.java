package customRecipeReply.service;

import customRecipeReply.dao.ReplyDao;
import customRecipeReply.dto.ReplyDto;

public class ReplyWriteService {

    public void writeReply(ReplyDto replyDto) {
    	System.out.println("서비스 진입");
        ReplyDao dao = ReplyDao.getInstance();
        dao.insert(replyDto);
    }
}