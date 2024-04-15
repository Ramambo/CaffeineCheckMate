package customRecipeReply.service;

import java.util.List;

import customRecipeReply.dao.ReplyDao;
import customRecipeReply.dto.ReplyDto;

public class ReplyListService {

    public List<ReplyDto> getReplyList() {
        ReplyDao dao = ReplyDao.getInstance();
        return dao.getList();
    }
}
