package com.app.alpha.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Accounts implements Serializable {
    @Id
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String photo;

//    @JsonIgnore
//    @OneToMany(mappedBy = "account")
//    List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    List<Authorities> authorities;

}
