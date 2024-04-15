package customRecipeReply.service;

import customRecipeReply.dao.ReplyDao;

public class ReplyDeleteService {

    public void deleteReply(int cus_re_no) {
        ReplyDao dao = ReplyDao.getInstance();
        dao.delete(cus_re_no);
    }
}