package com.crud.tasks.domain;

import com.crud.tasks.trello.domain.TrelloDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentByTypeDto {
    @JsonProperty("trello")
    TrelloDto trelloDto;

}
