package com.wemakeprice.makersmarket.service.impl;

import com.wemakeprice.makersmarket.model.Project;
import com.wemakeprice.makersmarket.repository.ProjectRepository;
import com.wemakeprice.makersmarket.service.ProjectService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ehay@naver.com on 2018-10-30
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Iterable<Project> getAllProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Iterable<Project> getAllProjectsBySeller(Integer sellerId) {
        List<Project> list = projectRepository.findAll();

        List<Project> result = new ArrayList<>();

        for (final Project project : list) {
            if(sellerId == project.getSeller().getId()) result.add(project);
        }

        return result;
    }

    @Override
    public Iterable<Project> getPopularProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Iterable<Project> getSimilarProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Optional<Project> getProject(Integer id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project product) {
        return projectRepository.save(product);
    }
}
