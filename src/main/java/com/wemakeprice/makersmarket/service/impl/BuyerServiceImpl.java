package com.wemakeprice.makersmarket.service.impl;

import com.wemakeprice.makersmarket.model.Buyer;
import com.wemakeprice.makersmarket.repository.BuyerRepository;
import com.wemakeprice.makersmarket.service.BuyerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by ehay@naver.com on 2018-10-31
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;

    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public Buyer save(Buyer buyer) {
        return buyerRepository.save(buyer);
    }
}
