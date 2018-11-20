package com.wemakeprice.makersmarket.service;

import com.wemakeprice.makersmarket.model.Product;
import com.wemakeprice.makersmarket.model.Seller;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by ehay@naver.com on 2018-10-29
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

public interface ProductService {
    Iterable<Product> getAllProducts(Pageable pageable);
    Iterable<Product> getAllProductsBySeller(Integer sellerId);
    Iterable<Product> getPlanExProducts(Pageable pageable);
    Iterable<Product> getPopularProducts(Pageable pageable);
    Optional<Product> getProduct(Integer id);
    Product save(Product product);
}
