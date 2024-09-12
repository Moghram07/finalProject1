package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String title;

//    @NotEmpty
//    private String content;

    private double price;

//    @ManyToOne
//    @JoinColumn(name = "course_id")// like document to course
//    private Course course;
}

