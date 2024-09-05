package com.lautajam.api_disney_catalog.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor 
@Entity @Table(name="Production")
public class Production {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productionId;
    
    private String title;
    
    @Temporal(TemporalType.DATE)
    private Date crationDate;
    
    private int score;
    private String image;
    
    
    @ManyToMany(mappedBy = "productions")
    private List<Character> characters = new ArrayList<>();

    public Production(Long productionId, String image, String title, Date crationDate, int score) {
        this.productionId = productionId;
        this.image = image;
        this.title = title;
        this.crationDate = crationDate;
        this.score = score;
    }
}
