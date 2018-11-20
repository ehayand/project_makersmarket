package com.wemakeprice.makersmarket.controller;

import com.wemakeprice.makersmarket.model.Seller;
import com.wemakeprice.makersmarket.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Created by ehay@naver.com on 2018-10-30
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Slf4j
@RestController
@RequestMapping("/makersmarket/seller")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(final SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/popular")
    public @NotNull Iterable<Seller> getPopularSellers(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 2) Pageable pageable) {
        log.info("/makersmarket/seller/popular");
        return sellerService.getPopularSellers(pageable);
    }

    @GetMapping("/{seller_id}")
    public Optional<Seller> getSeller(@PathVariable(value = "seller_id") final int id) {
        log.info("/makersmarket/seller");
        return sellerService.getSeller(id);
    }

}
