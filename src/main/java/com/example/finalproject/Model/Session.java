package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private double duration;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @NotEmpty
    @Pattern(regexp = "ZOOM|FACE_TO_FACE|VIDEO|DOCUMENT")
    private String learningMethod; // ZOOM, FACE_TO_FACE, VIDEO, DOCUMENT

    @NotNull
    private int maxParticipants;

    @NotNull
    @Positive
    private double price;

//    @ManyToOne
//    @JoinColumn(name = "student_id") // Ensure this matches the `mappedBy` value in the `Student` entity
//    private Student student;
//
//    @ManyToOne
//    @JoinColumn(name = "tutor_id")
//    private Tutor tutor;
//
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;
//
//    @OneToMany(mappedBy = "session")
//    private List<Review> reviews;

    @OneToOne(mappedBy = "session", cascade = CascadeType.ALL)
    private ZoomMeeting zoomMeeting;

    @OneToOne(mappedBy = "session", cascade = CascadeType.ALL)
    private FaceToFace faceToFace;
}


