package com.wemakeprice.makersmarket.service;

import com.wemakeprice.makersmarket.model.Message;

/**
 * Created by ehay@naver.com on 2018-10-30
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

public interface MessageService {
    Iterable<Message> getMessages(Integer sellerId);
    Message save(Message message);
}
