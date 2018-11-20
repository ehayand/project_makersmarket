package com.wemakeprice.makersmarket.service.impl;

import com.wemakeprice.makersmarket.model.Product;
import com.wemakeprice.makersmarket.model.ProductOption;
import com.wemakeprice.makersmarket.model.Seller;
import com.wemakeprice.makersmarket.repository.ProductOptionRepository;
import com.wemakeprice.makersmarket.repository.ProductRepository;
import com.wemakeprice.makersmarket.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by ehay@naver.com on 2018-10-29
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductOptionRepository productOptionRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductOptionRepository productOptionRepository) {
        this.productRepository = productRepository;
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    public Iterable<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Iterable<Product> getAllProductsBySeller(Integer sellerId) {
        List<Product> list = productRepository.findAll();

        List<Product> result = new ArrayList<>();

        for (final Product product : list) {
            if(sellerId == product.getSeller().getId()) result.add(product);
        }

        return result;
    }

    @Override
    public Iterable<Product> getPlanExProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Iterable<Product> getPopularProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> getProduct(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
