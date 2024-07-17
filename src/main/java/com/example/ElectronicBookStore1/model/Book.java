package com.example.ElectronicBookStore1.model;

import com.example.ElectronicBookStore1.util.ValueOfEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank(message = "Укажите название книги")
    @Column(name = "name")
    private String name;


    @NotBlank(message = "Укажите автора книги")
    @Column(name="author")
    private String author;


    @ValueOfEnum(enumClass = Lang.class, message = "-")
    @Column(name="language")
    private String language;


    @NotNull(message = "Укажите год издания книги")
    @Min(value = 1800, message = "Некорректно указан год издания книги")
    @Max(value = 2024, message = "Некорректно указан год издания книги")
    @Column(name = "year")
    private Integer year;


    @ValueOfEnum(enumClass = Genre.class, message = "-")
    @Column(name="genre")
    private String genre;


    @Length(max = 100, message = "Допускается не более 100 символов")
    @Column(name = "annotation")
    private String annotation;


    @NotBlank(message = "Укажите ISBN")
    @Column(name="isbn")
    private String ISBN;


    @NotNull(message = "Укажите количество страниц")
    @Min(value = 5, message = "Некорректно указано количество страниц")
    @Max(value = 10000, message = "Некорректно указано количество страниц")
    @Column(name="pagecount")
    private Integer pageCount;


    @Min(value = 1, message = "Некорректно указан рейтинг")
    @Max(value = 10, message = "Некорректно указан рейтинг")
    @Column(name = "rating")
    private double rating;


    @Column(name = "novelty")
    private Boolean novelty;


    @Min(value = 1, message = "Некорректно указана стоимость книги")
    @NotNull(message = "Укажите стоимость книги")
    @Column(name = "price")
    private Double price;


    @Min(value = 0, message = "Некорректно указано количество книг на складе")
    @NotNull(message = "Укажите количество книг на складе")
    @Column(name = "quantity")
    private Integer quantity;


    @Column(name="url")
    private String url;
}

