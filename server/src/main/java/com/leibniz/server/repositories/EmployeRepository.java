package com.leibniz.server.repositories;

import javax.persistence.*;

@Entity
@Table(name = "service_provider")
public class EmployeRepository extends AbstractRepository{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_provider_id")
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
