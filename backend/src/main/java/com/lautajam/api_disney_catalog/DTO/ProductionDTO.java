/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lautajam.api_disney_catalog.DTO;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ProductionDTO {
    
    private long charDtoId;
    private String charDtoName;
    private String charDtoImage;
    private Date cration_date;

    public ProductionDTO(long charDtoId, String charDtoName, String charDtoImage, Date cration_date) {
        this.charDtoId = charDtoId;
        this.charDtoName = charDtoName;
        this.charDtoImage = charDtoImage;
        this.cration_date = cration_date;
    }
    
}