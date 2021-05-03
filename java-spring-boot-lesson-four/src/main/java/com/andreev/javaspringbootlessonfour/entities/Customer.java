package com.andreev.javaspringbootlessonfour.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "customers")
@Component
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "purchases",
            joinColumns = @JoinColumn(name = "customers_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
