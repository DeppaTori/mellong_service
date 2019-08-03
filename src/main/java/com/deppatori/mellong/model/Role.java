package com.deppatori.mellong.model;

import javax.persistence.*;

@Entity
@Table(name="mel_auth_role")
public class Role {

    @Id
    @GeneratedValue(generator = "role_generator")
    @SequenceGenerator(
            name = "role_generator",
            sequenceName = "role_sequence",
            initialValue = 2000
    )
    private Long id;

    @Column(name="name", unique = true)
    private String name;

    public Role(){
        super();
    }

    public Role(Long id) {
        super();
        this.id = id;
    }

    public Role(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
