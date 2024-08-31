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
    
    private String charName;
    private int age;
    private float weight;
    private String history;
    private String image;

    @ManyToMany
    @JoinTable(
        name = "character_production",
        joinColumns = @JoinColumn(name = "characterId", nullable=false),
        inverseJoinColumns = @JoinColumn(name = "productionId", nullable=false)
    )
    private List<Production> productions = new ArrayList<>();
    

    public Character(Long characterId, String image, String charName, int age, float weight, String history) {
        this.characterId = characterId;
        this.image = image;
        this.charName = charName;
        this.age = age;
        this.weight = weight;
        this.history = history;
    }
}
