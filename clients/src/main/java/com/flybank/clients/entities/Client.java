package com.flybank.clients.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String idType;
    String idNumber;
    @NotBlank(message = "Names are required")
    String names;
    @NotBlank(message = "Surname is required")
    String surnames;
    String email;
    String birthDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
