package com.wemakeprice.makersmarket.service.impl;

import com.wemakeprice.makersmarket.model.ProjectOption;
import com.wemakeprice.makersmarket.repository.ProjectOptionRepository;
import com.wemakeprice.makersmarket.service.OptionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehay@naver.com on 2018-10-31
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Service(value = "ProjectOptionServiceImpl")
@Transactional
public class ProjectOptionServiceImpl implements OptionService<ProjectOption> {

    private final ProjectOptionRepository projectOptionRepository;

    public ProjectOptionServiceImpl(ProjectOptionRepository projectOptionRepository) {
        this.projectOptionRepository = projectOptionRepository;
    }

    @Override
    public Iterable<ProjectOption> getOptions(Integer projectId) {
        List<ProjectOption> list = projectOptionRepository.findAll();

        List<ProjectOption> result = new ArrayList<>();

        for (final ProjectOption projectOption : list) {
            if(projectId == projectOption.getProject().getId()) result.add(projectOption);
        }

        return result;
    }

    @Override
    public ProjectOption save(ProjectOption projectOption) {
        return projectOptionRepository.save(projectOption);
    }
}
