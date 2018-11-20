package com.wemakeprice.makersmarket.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ehay@naver.com on 2018-10-31
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Builder
@Data
@Entity
public class ProjectOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Basic(optional = false)
    private String name;
    private Integer additionalPrice;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
