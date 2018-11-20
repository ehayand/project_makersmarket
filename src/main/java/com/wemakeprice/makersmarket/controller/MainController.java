package com.wemakeprice.makersmarket.controller;

import com.wemakeprice.makersmarket.model.Message;
import com.wemakeprice.makersmarket.model.Product;
import com.wemakeprice.makersmarket.repository.ProductRepository;
import com.wemakeprice.makersmarket.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ehay@naver.com on 2018-10-28
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Slf4j
@RestController
@RequestMapping("/makersmarket")
public class MainController {

    private final MessageService messageService;

    public MainController(final MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message/{seller_id}")
    public Iterable<Message> getMessages(@PathVariable(value = "seller_id") final int id) {
        log.info("/makersmarket/message");
        return messageService.getMessages(id);
    }

}
