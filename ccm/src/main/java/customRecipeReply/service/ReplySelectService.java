package customRecipeReply.service;

import customRecipeReply.dao.ReplyDao;
import customRecipeReply.dto.ReplyDto;

public class ReplySelectService {

    public ReplyDto selectReply(int cus_re_no) {
        ReplyDao dao = ReplyDao.getInstance();
        return dao.select(cus_re_no);
    }
}