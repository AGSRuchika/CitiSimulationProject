package com.example.profileapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String college;
    private String studyFrom;
    private String studyTo;
    private String department;
    private String percentage;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
