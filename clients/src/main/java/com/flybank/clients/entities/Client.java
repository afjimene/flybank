package com.flybank.clients.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Short idType;
    Long idNumber;
    @NotBlank(message = "Names are required")
    String names;
    @NotBlank(message = "Surname is required")
    String surnames;
    String email;
    Date birthDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getIdType() {
        return idType;
    }

    public void setIdType(Short idType) {
        this.idType = idType;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public @NotBlank(message = "Names are required") String getNames() {
        return names;
    }

    public void setNames(@NotBlank(message = "Names are required") String names) {
        this.names = names;
    }

    public @NotBlank(message = "Surname is required") String getSurnames() {
        return surnames;
    }

    public void setSurnames(@NotBlank(message = "Surname is required") String surnames) {
        this.surnames = surnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
