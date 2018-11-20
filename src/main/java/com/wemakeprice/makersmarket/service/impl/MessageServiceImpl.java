package com.wemakeprice.makersmarket.service.impl;

import com.wemakeprice.makersmarket.model.Message;
import com.wemakeprice.makersmarket.repository.MessageRepository;
import com.wemakeprice.makersmarket.service.MessageService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehay@naver.com on 2018-10-30
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Iterable<Message> getMessages(Integer sellerId) {
        Iterable<Message> messages = messageRepository.findAll(new Sort(Sort.Direction.ASC, "created"));
        List<Message> result = new ArrayList<>();

        for(final Message message : messages){
            if(sellerId == message.getSeller().getId()) result.add(message);
        }

        return result;
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }
}
