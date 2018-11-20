package com.wemakeprice.makersmarket.service.impl;

import com.wemakeprice.makersmarket.model.Seller;
import com.wemakeprice.makersmarket.repository.SellerRepository;
import com.wemakeprice.makersmarket.service.SellerService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by ehay@naver.com on 2018-10-30
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Iterable<Seller> getPopularSellers(Pageable pageable) {
        return sellerRepository.findAll(pageable);
    }

    @Override
    public Optional<Seller> getSeller(Integer id) {
        return sellerRepository.findById(id);
    }

    @Override
    public Seller save(Seller seller) {
        return sellerRepository.save(seller);
    }
}
