package com.shreyas.zombieapocalypse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@ApiModel(description = "input")
@Getter
@Setter
@Builder
public class InputRequest {

    @Min(value = 1, message = "id must be greater than or equal to 1")
    @Max(value = 1000, message = "id must be lower than or equal to 1000")
    @NotNull(message = "Dimension is mandatory")
    @ApiModelProperty(position = 1, notes = "dimension of world", example = "4", required = true)
    private Integer dimension;

    @NotEmpty(message = "ZombiePosition field is mandatory")
    @ApiModelProperty(position = 2, notes = "zombie position", example = "(2,1)", required = true)
    @Pattern(regexp = "([(][0-9.]+[,][0-9.]+[)])",
            message = "zombiePosition value must be in '({digit},{digit})' format")
    private String zombiePosition;

    @NotEmpty(message = "CreaturePosition field is mandatory")
    @ApiModelProperty(position = 3, notes = "creature position separated by space", example = "(0,1) (1,2) (3,1)", required = true)
    @Pattern(regexp = "([(][0-9.]+[,][0-9.]+[)]\\s*)+",
                message = "creaturePosition value must be in '({digit},{digit})' format")
    private String creaturePosition;

    @NotEmpty(message = "Movements field is mandatory")
    @ApiModelProperty(position = 4, notes = "movement of zombie", example = "DLUURR", required = true)
    @Pattern(regexp = "(D*L*U*R*)",
            message = "movements value can only contain 'D', 'L', 'U', 'R' characters")
    private String movements;
}
