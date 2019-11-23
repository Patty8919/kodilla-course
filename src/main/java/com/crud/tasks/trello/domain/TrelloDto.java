package com.crud.tasks.trello.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloDto {
    @JsonProperty("board")
    private int board;
    @JsonProperty("card")
    private int card;
}
