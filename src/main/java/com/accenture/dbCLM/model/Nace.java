package com.accenture.dbCLM.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Nace {

    @Id
    private Long orderid;
    @NonNull
    private int level;
    private String code;
    private String parent;
    private String description;
    private String thisItemIncludes;
    private String thisItemAlsoIncludes;
    private String rulings;
    private String thisItemExcludes;
    private String referenceToISICRev;

}
