package com.app.alpha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authorities", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username", "roleid"})
})
//UniqueConstraint ràng buộc đảm bảo tính duy nhất không bị trùng lặp
public class Authorities implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "username")
    private Accounts account;
    @ManyToOne
    @JoinColumn(name = "roleid")
    private Roles role;


}

