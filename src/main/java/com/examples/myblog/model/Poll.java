package com.examples.ecommerce.model;

import com.examples.ecommerce.model.common.GenericModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "polls")
@Data
@EqualsAndHashCode(callSuper = true)
public class Poll extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 140)
    private String question;

    @Size(min = 2, max = 6)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 30)
    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Choice> choices = new ArrayList<>();

    @NotNull
    private Date expirationDateTime;

    public void addChoice(Choice choice) {
        choices.add(choice);
        choice.setPoll(this);
    }

    public void removeChoice(Choice choice) {
        choices.remove(choice);
        choice.setPoll(null);
    }
}
