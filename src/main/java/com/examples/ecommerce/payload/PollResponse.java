package com.examples.ecommerce.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PollResponse {

    private Long id;

    private String question;

    private List<ChoiceResponse> choices;

    private UserSummary createdBy;

    private Date creationDateTime;

    private Date expirationDateTime;

    private Boolean isExpired;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long selectedChoice;

    private Long totalVotes;
}
