package com.example.crudapi.models;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name ="password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel userModel)) return false;
        return Objects.equals(getId(), userModel.getId()) && Objects.equals(getEmail(), userModel.getEmail()) && Objects.equals(getPassword(), userModel.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getPassword());
    }
}

/*
* Implementar la Validación de Datos:

Asegúrate de agregar validaciones adecuadas para los datos de entrada. Puedes usar anotaciones de validación, como @NotNull, @NotBlank, @Email, etc., según tus requisitos.
Implementar la Paginación y Ordenación:

Si esperas tener grandes cantidades de datos, considera agregar paginación y ordenación a tus endpoints para mejorar la eficiencia y la usabilidad.
Añadir Seguridad:

Implementa la seguridad en tu aplicación. Puedes usar Spring Security para gestionar la autenticación y la autorización.
Documentar tu API:

Utiliza herramientas como Swagger o Springdoc para documentar tu API de manera clara y proporcionar una referencia fácil de usar para los consumidores de la API.
Manejar Excepciones de Manera Adecuada:

Implementa el manejo adecuado de excepciones para proporcionar respuestas significativas en caso de errores.
Agregar Pruebas Unitarias e Integración:

Desarrolla y ejecuta pruebas unitarias e integración para garantizar la calidad y la robustez de tu aplicación.
Implementar Auditoría: */