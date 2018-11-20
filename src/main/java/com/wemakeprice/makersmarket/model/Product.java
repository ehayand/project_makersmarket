package com.wemakeprice.makersmarket.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by ehay@naver.com on 2018-10-28
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Builder
@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_seq_generator", sequenceName = "product_seq", allocationSize = 1)
    private Integer id;
    @NotNull
    @Basic(optional = false)
    private String name;
    private Integer price;
    private String intro;
    private Integer likes;

    @CreatedDate
    private LocalDate start;
    private LocalDate finish;

    private Integer sales;
    private Integer remain;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    private String[] mainImageUrl;
    private String[] detailsImageUrl;
}
