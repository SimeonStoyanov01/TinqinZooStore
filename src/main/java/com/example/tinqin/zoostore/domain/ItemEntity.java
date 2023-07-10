package com.example.tinqin.zoostore.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    private String title;
    @ManyToOne
    @JoinColumn(referencedColumnName = "items",nullable = false)
    private VendorEntity vendor;
    @ManyToMany
    private Set<TagEntity> tag;
    @OneToMany
    private Set<MultimediaEntity> multimedia;

}
