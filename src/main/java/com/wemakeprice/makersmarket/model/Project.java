package com.wemakeprice.makersmarket.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by ehay@naver.com on 2018-10-28
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Builder
@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "project_seq_generator", sequenceName = "project_seq", allocationSize = 1)
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

    private Integer dDay;
    private Integer rate;
    private Integer sponsorCnt;
    private Integer sponAmount;
    private Integer sponTarget;


    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    private String[] mainImageUrl;
    private String[] detailsImageUrl;

}
