package com.wemakeprice.makersmarket.controller;

import com.wemakeprice.makersmarket.model.Product;
import com.wemakeprice.makersmarket.model.ProductOption;
import com.wemakeprice.makersmarket.service.OptionService;
import com.wemakeprice.makersmarket.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Created by ehay@naver.com on 2018-10-29
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Slf4j
@RestController
@RequestMapping("/makersmarket/product")
public class ProductController {

    private final ProductService productService;
    private final OptionService optionService;

    public ProductController(final ProductService productService,
                             @Qualifier("ProductOptionServiceImpl") final OptionService optionService) {
        this.productService = productService;
        this.optionService = optionService;
    }

    @GetMapping("/list")
    public @NotNull Iterable<Product> getProducts(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 2) Pageable pageable) {
        log.info("/makersmarket/product/list");
        return productService.getAllProducts(pageable);
    }

    @GetMapping("/list/{seller_id}")
    public @NotNull Iterable<Product> getAllProductsBySeller(@PathVariable(value = "seller_id") final int sellerId) {
        log.info("/makersmarket/product/list/byseller");
        return productService.getAllProductsBySeller(sellerId);
    }

    @GetMapping("/plan")
    public @NotNull Iterable<Product> getPlanExProducts(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 2) Pageable pageable) {
        log.info("/makersmarket/product/plan");
        return productService.getPlanExProducts(pageable);
    }

    @GetMapping("/popular")
    public @NotNull Iterable<Product> getPopularProducts(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 2) Pageable pageable) {
        log.info("/makersmarket/product/popular");
        return productService.getPopularProducts(pageable);
    }

    @GetMapping("/{product_id}")
    public Map<String, Object> getProduct(@PathVariable(value = "product_id") final int id) {
        log.info("/makersmarket/product");

        Map<String, Object> product = new HashMap<>();

        Iterable<ProductOption> productOptions = optionService.getOptions(id);
        List<Map<String, Object>> options = new ArrayList<>();

        for(final ProductOption productOption : productOptions){
            Map<String, Object> option = new HashMap<>();
            option.put("id", productOption.getId());
            option.put("name", productOption.getName());
            option.put("addtionalPrice", productOption.getAdditionalPrice());

            options.add(option);
        }

        product.put("product", productService.getProduct(id));
        product.put("option", options);

        return product;
    }
}
