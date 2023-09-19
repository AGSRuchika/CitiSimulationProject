package com.example.profileapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String occupation;
    private String workFrom;
    private String workTo;
    private String jobDescription;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
