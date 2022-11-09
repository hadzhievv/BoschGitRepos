package com.malin.bosch.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepoInformation {
    private Long id;
    @JsonProperty("full_name")
    private String fullName;
    private String description;
    @JsonProperty("language")
    private String programmingLanguage;
    @JsonProperty("html_url")
    private String url;
}
