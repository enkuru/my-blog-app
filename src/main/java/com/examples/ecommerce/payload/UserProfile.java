package com.examples.ecommerce.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserProfile {

    private Long id;

    private String username;

    private String name;

    private Date joinedAt;

    private Long pollCount;

    private Long voteCount;
}
