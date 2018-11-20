package com.wemakeprice.makersmarket.service.impl;

import com.wemakeprice.makersmarket.model.ProductOption;
import com.wemakeprice.makersmarket.repository.ProductOptionRepository;
import com.wemakeprice.makersmarket.service.OptionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehay@naver.com on 2018-10-31
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Service(value = "ProductOptionServiceImpl")
@Transactional
public class ProductOptionServiceImpl implements OptionService<ProductOption> {

    private final ProductOptionRepository productOptionRepository;

    public ProductOptionServiceImpl(ProductOptionRepository productOptionRepository) {
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    public Iterable<ProductOption> getOptions(Integer productId) {
        List<ProductOption> list = productOptionRepository.findAll();

        List<ProductOption> result = new ArrayList<>();

        for (final ProductOption productOption : list) {
            if(productId == productOption.getProduct().getId()) result.add(productOption);
        }

        return result;
    }

    @Override
    public ProductOption save(ProductOption productOption) {
        return productOptionRepository.save(productOption);
    }
}
