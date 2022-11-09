package com.malin.bosch.controllers;

import com.malin.bosch.models.RepoInformation;
import com.malin.bosch.services.RepoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RepoController {

    private final RepoService repoService;

    public RepoController(RepoService repoService) {
        this.repoService = repoService;
    }

    @GetMapping(value = "/bosch-repos")
    public List<RepoInformation> getRepos() {
        return repoService.getAllRepos();
    }

    @GetMapping(value = "/bosch-repos/filter")
    public List<RepoInformation> filterRepos(@RequestParam String searchTerm) {
        return repoService.filterRepos(searchTerm);
    }
}
