package com.schoolplatform.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true)
    private Long id;

    @Column(name = "rating", nullable = false)
    @NotNull
    @Min(value = 1 , message = "Minimum rating is 1 star")
    @Max(value = 5 , message = "Maximum rating is 5 stars")
    private int rating;

    @Column(name="comment")
    @Size(min = 0, max = 256)
    @ColumnDefault("")
    private String comment;

    @Column(name="time_of_posting")
    @NotNull
    private Timestamp timeOfPosting;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "course_id")
    @NotNull
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;
}