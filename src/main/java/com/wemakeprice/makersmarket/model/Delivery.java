package com.wemakeprice.makersmarket.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ehay@naver.com on 2018-10-29
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Builder
@Data
@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "delivery_seq_generator", sequenceName = "delivery_seq", allocationSize = 1)
    private Integer id;
    @NotNull
    @Basic(optional = false)
    private String name;
}
