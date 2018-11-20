package com.wemakeprice.makersmarket.service.impl;

import com.wemakeprice.makersmarket.model.Delivery;
import com.wemakeprice.makersmarket.repository.DeliveryRepository;
import com.wemakeprice.makersmarket.service.DeliveryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by ehay@naver.com on 2018-10-31
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Optional<Delivery> getDelivery(Integer id) {
        return deliveryRepository.findById(id);
    }

    @Override
    public Delivery save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }
}
