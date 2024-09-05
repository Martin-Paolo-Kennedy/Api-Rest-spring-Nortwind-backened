    package com.martin.demo.Entity;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

    import java.util.List;

    @Getter
    @Setter
    @Entity
    @Table(name = "Categories")
    public class Categoria {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int CategoryID;
        private String CategoryName;
        private String Description;

    }
