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
    
    @Lob
    private byte[] image;
    private String title;
    
    @Temporal(TemporalType.DATE)
    private Date cration_date;
    private int score;
    
    @ManyToMany(mappedBy = "productions")
    private List<Character> characters = new ArrayList<>();

    public Production(Long productionId, byte[] image, String title, Date cration_date, int score) {
        this.productionId = productionId;
        this.image = image;
        this.title = title;
        this.cration_date = cration_date;
        this.score = score;
    }
}
