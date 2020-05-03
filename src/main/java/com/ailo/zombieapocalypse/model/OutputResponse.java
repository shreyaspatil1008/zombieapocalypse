package com.ailo.zombieapocalypse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "output")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class OutputResponse {

    @ApiModelProperty(position = 1, notes = "zombie score", example = "3", required = true)
    private Integer zombieScore;

    @ApiModelProperty(position = 2, notes = "zombie positions", example = "(3,0) (2,1) (1,0) (0,0)", required = true)
    private String zombiePosition;
}
