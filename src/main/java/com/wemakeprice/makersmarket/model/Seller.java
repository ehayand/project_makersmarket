package com.wemakeprice.makersmarket.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ehay@naver.com on 2018-10-28
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Builder
@Data
@Entity
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "seller_seq_generator", sequenceName = "seller_seq", allocationSize = 1)
    private Integer id;
    @NotNull
    @Basic(optional = false)
    private String name;
    private String intro;
    private Integer likes;

    private String imageUrl;

//    @OneToMany
//    @JoinColumn(name = "product_seller")
//    private Collection<Product> products;
//    @OneToMany
//    @JoinColumn(name = "project_seller")
//    private Collection<Project> projects;
}
