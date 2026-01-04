package com.bit.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name= "service")
public class ServiceEntity {
    //@ID means this is the primary key. @GeneratedValue means it's auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="service_name")
    private String serviceName;

    @Column(name="price")
    private BigDecimal price;


    @Column(name="commission")
    private BigDecimal commission;

    @Column(name="color_code")
    private String colorCode;

    @Column(name="description")
    private String description;

    @Column(name="is_Active")
    private String isActive;

    //serviceCategory Column is joined with the id column of the service Category
    @ManyToOne
    @JoinColumn(name = "serviceCategory", referencedColumnName = "id")
    private ServiceCategoryEntity serviceCategory;

}
