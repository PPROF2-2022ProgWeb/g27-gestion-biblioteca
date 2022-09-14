package com.grupo27.library.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idBook")
    private Long id;
    private String title;
    private String date;
    private String author;
    private String category;
    private String edit;
    private String lang;
    private String description;
    private int pages;
    private int stock;
    private int available;

    /*
    @OneToMany(mappedBy = "book")//orphanRemoval = true
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Loan> loans = new ArrayList<>();
*/
}
