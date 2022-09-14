package com.grupo27.library.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idUser")
    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private int sanctions;
    private double sanctionsAmount;


    /*
    @OneToMany(mappedBy = "user")//orphanRemoval = true
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Loan> loans = new ArrayList<>();
     */
}
