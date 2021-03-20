package com.thecaveman.webclient.webclientgunslinger.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CowboyRequest {
    private Long cowboyId;
    private String name;
    private String famous;
    private String gun;
    private int money;
}
