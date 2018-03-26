package com.leibniz.server.repositories;

import javax.persistence.*;

@Entity
@Table(name = "service_appointment")
public class ServiceRepository extends AbstractRepository{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_appointement_id")
    private long id;
    private String name;
    private int statedDuration;

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

    public int getStatedDuration() {
        return statedDuration;
    }

    public void setStatedDuration(int statedDuration) {
        this.statedDuration = statedDuration;
    }
}
