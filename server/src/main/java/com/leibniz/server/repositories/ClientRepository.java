package com.leibniz.server.repositories;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client")
public class ClientRepository extends AbstractRepository implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="client_id")
    private long id;

    @Column(name = "client_gender")
    private int gender;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_name")
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
