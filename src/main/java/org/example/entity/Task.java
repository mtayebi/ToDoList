package org.example.entity;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.base.entity.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorColumn(columnDefinition = "task_entity")
public class Task extends BaseEntity<Long> {
    private String title;
    private String description;

    @ManyToOne
    private User user;
}
