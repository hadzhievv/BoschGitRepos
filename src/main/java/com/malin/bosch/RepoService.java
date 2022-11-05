package com.malin.bosch;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

@Service
public class RepoService {

    public static final String URL = "https://api.github.com/orgs/bosch-io/repos";

    public List<RepoInformation> getAllRepos() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<RepoInformation>> response = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){});

        return response.getBody();
    }

    public List<RepoInformation> filterRepos(String searchTerm) {



        return getAllRepos()
                .stream()
                .filter(repoInformation -> searchTermMatches(searchTerm, repoInformation.getFullName()) ||
                        searchTermMatches(searchTerm, repoInformation.getDescription()) ||
                        searchTermMatches(searchTerm, repoInformation.getProgrammingLanguage()))
                .toList();
    }

    private boolean searchTermMatches(String searchTerm, String matchingField) {

        return matchingField != null && matchingField.toLowerCase(Locale.ROOT).contains(searchTerm);
    }
}
