package com.bhanu.courseenrollement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {
    @SequenceGenerator(
            name = "student_id_sequence",
            sequenceName = "student_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_sequence"
    )
    @Id
    private Long studentId;
   private  String name;
    private String email;
   private String contactNumber;
    private String address;
}
