package com.wemakeprice.makersmarket.service;

/**
 * Created by ehay@naver.com on 2018-10-31
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

public interface OptionService<T> {
    Iterable<T> getOptions(Integer id);
    T save(T option);
}
