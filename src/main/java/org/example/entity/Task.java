package org.example.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.base.entity.BaseEntity;
import org.example.entity.enumeration.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue(value = "task")
public class Task extends BaseEntity<Long> {
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private User user;
}
