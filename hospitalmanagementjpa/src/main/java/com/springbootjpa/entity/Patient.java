package com.springbootjpa.entity;

import com.springbootjpa.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Table(
        name="patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email",columnNames = "email"),
                @UniqueConstraint(name="unique_patient_name_birthdate",columnNames = {"name","birthDate"})
        },
        indexes={
             @Index(name = "idx_patient_birth_date",columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(name="patient_name",length = 30,nullable = false)
    @Column(length = 30,nullable = false)
    private String name;
    //@ToString.Exclude
    private LocalDate birthDate;
    @Column(unique = true, nullable = false)
    private String email;

    //@CreatedTimeStamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    private String gender;

}
