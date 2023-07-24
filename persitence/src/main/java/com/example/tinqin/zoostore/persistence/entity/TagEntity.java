package com.example.tinqin.zoostore.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tags")
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @ManyToMany
    @JoinTable(
            name="item_tag",
            joinColumns=@JoinColumn(name = "tag_id"),
            inverseJoinColumns=@JoinColumn(name = "item_id")
    )
    private Set<ItemEntity> items;

    @Column(name = "is_archived")
    private Boolean isArchived;

}