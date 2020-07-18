package co.wide.core.plan;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "plan")
public class PlanEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
