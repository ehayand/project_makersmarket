package com.wemakeprice.makersmarket.controller;

import com.wemakeprice.makersmarket.model.Project;
import com.wemakeprice.makersmarket.model.ProjectOption;
import com.wemakeprice.makersmarket.service.OptionService;
import com.wemakeprice.makersmarket.service.ProjectService;
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
 * Created by ehay@naver.com on 2018-10-30
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Slf4j
@RestController
@RequestMapping("/makersmarket/project")
public class ProjectController {

    private final ProjectService projectService;
    private final OptionService optionService;

    public ProjectController(final ProjectService projectService,
                             @Qualifier("ProjectOptionServiceImpl") final OptionService optionService) {
        this.projectService = projectService;
        this.optionService = optionService;
    }

    @GetMapping("/list")
    public @NotNull Iterable<Project> getProjects(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 2) Pageable pageable) {
        log.info("/makersmarket/project/list");
        return projectService.getAllProjects(pageable);
    }

    @GetMapping("/list/{seller_id}")
    public Iterable<Project> getAllProjectsBySeller(@PathVariable(value = "seller_id") final int sellerId) {
        log.info("/makersmarket/project/list/byseller");
        return projectService.getAllProjectsBySeller(sellerId);
    }

    @GetMapping("/popular")
    public @NotNull Iterable<Project> getPopularProjects(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 2) Pageable pageable) {
        log.info("/makersmarket/project/popular");
        return projectService.getPopularProjects(pageable);
    }

    @GetMapping("/similar")
    public @NotNull Iterable<Project> getSimilarProjects(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 2) Pageable pageable) {
        log.info("/makersmarket/project/similar");
        return projectService.getPopularProjects(pageable);
    }

    @GetMapping("/{project_id}")
    public  Map<String, Object> getProject(@PathVariable(value = "project_id") final int id) {
        log.info("/makersmarket/project");
        Map<String, Object> project = new HashMap<>();

        Iterable<ProjectOption> projectOptions = optionService.getOptions(id);
        List<Map<String, Object>> options = new ArrayList<>();

        for(final ProjectOption projectOption : projectOptions){
            Map<String, Object> option = new HashMap<>();
            option.put("id", projectOption.getId());
            option.put("name", projectOption.getName());
            option.put("addtionalPrice", projectOption.getAdditionalPrice());

            options.add(option);
        }

        project.put("project", projectService.getProject(id));
        project.put("option", options);

        return project;
    }
}
