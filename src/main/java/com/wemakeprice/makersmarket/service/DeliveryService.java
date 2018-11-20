package com.wemakeprice.makersmarket.service;

import com.wemakeprice.makersmarket.model.Delivery;

import java.util.Optional;

/**
 * Created by ehay@naver.com on 2018-10-31
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

public interface DeliveryService {
    Optional<Delivery> getDelivery(Integer id);
    Delivery save(Delivery delivery);
}
