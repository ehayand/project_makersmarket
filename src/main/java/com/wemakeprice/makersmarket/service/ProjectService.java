package com.wemakeprice.makersmarket.service;

import com.wemakeprice.makersmarket.model.Project;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by ehay@naver.com on 2018-10-30
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

public interface ProjectService {
    Iterable<Project> getAllProjects(Pageable pageable);
    Iterable<Project> getAllProjectsBySeller(Integer sellerId);
    Iterable<Project> getPopularProjects(Pageable pageable);
    Iterable<Project> getSimilarProjects(Pageable pageable);
    Optional<Project> getProject(Integer id);
    Project save(Project project);
}
