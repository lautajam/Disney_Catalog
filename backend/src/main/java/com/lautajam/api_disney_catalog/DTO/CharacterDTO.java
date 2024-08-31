
package com.lautajam.api_disney_catalog.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CharacterDTO {
    
    private long charDtoId;
    private String charDtoName;
    private String charDtoImage;

    public CharacterDTO(long charDtoId, String charDtoName, String charDtoImage) {
        this.charDtoId = charDtoId;
        this.charDtoName = charDtoName;
        this.charDtoImage = charDtoImage;
    }
}
