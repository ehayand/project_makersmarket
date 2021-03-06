package com.wemakeprice.makersmarket.repository;

import com.wemakeprice.makersmarket.model.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by ehay@naver.com on 2018-10-31
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Service
public interface ProductOptionRepository extends JpaRepository<ProductOption, Integer> {

}
