package com.lautajam.api_disney_catalog.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data @NoArgsConstructor 
@Entity @Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long characterId;
    
    @Lob
    private byte[] image;
    private String charName;
    private int age;
    private float weight;
    private String history;

    @ManyToMany
    @JoinTable(
        name = "character_production",
        joinColumns = @JoinColumn(name = "characterId", nullable=false),
        inverseJoinColumns = @JoinColumn(name = "productionId", nullable=false)
    )
    private List<Production> productions = new ArrayList<>();
    
    public Character(String charName, int age, float weight, String history) {
        this.charName = charName;
        this.age = age;
        this.weight = weight;
        this.history = history;
    }

    public Character(Long characterId, byte[] image, String charName, int age, float weight, String history) {
        this.characterId = characterId;
        this.image = image;
        this.charName = charName;
        this.age = age;
        this.weight = weight;
        this.history = history;
    }
}
