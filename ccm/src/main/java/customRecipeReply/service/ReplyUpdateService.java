package customRecipeReply.service;

import customRecipeReply.dao.ReplyDao;
import customRecipeReply.dto.ReplyDto;

public class ReplyUpdateService {

    public void updateReply(ReplyDto replyDto) {
        ReplyDao dao = ReplyDao.getInstance();
        dao.update(replyDto.getCus_re_no(), replyDto.getCus_re_content());
    }
}