package com.wemakeprice.makersmarket.service;

import com.wemakeprice.makersmarket.model.Seller;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by ehay@naver.com on 2018-10-30
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

public interface SellerService {
    Iterable<Seller> getPopularSellers(Pageable pageable);
    Optional<Seller> getSeller(Integer id);
    Seller save(Seller seller);
}
