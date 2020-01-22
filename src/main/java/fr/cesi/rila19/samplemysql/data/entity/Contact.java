package fr.cesi.rila19.samplemysql.data.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private Integer id;
    private String lastname;
    private String firstname;
    private String tel;
    private String email;
    private String website;
}
