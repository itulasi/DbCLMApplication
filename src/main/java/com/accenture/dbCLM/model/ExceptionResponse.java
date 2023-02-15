package com.accenture.dbCLM.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class ExceptionResponse {

    private String errorMessage;
    private String requestedURI;
}
