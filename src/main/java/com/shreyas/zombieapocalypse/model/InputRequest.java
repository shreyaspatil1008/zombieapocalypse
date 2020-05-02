package com.shreyas.zombieapocalypse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "input")
@Getter
@Setter
@Builder
public class InputRequest {

    @ApiModelProperty(position = 1, notes = "dimension of world", example = "4", required = true)
    private Integer dimension;
    @ApiModelProperty(position = 2, notes = "zombie position", example = "(2,1)", required = true)
    private String zombiePosition;
    @ApiModelProperty(position = 3, notes = "creature position separated by space", example = "(0,1) (1,2) (3,1)", required = true)
    private String creaturePosition;
    @ApiModelProperty(position = 4, notes = "movement of zombie", example = "DLUURR", required = true)
    private String movements;
}
