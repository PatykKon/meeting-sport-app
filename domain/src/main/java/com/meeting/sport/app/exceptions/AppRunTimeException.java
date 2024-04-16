package com.meeting.sport.app.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppRunTimeException extends RuntimeException {

    private final String businessMessage; //  "WALLETS_RETRIEVING_ERROR",
    private final String description; //  "Wallet with id: is not found in the database",
    private final Integer businessStatusCode; //  404,

    public AppRunTimeException(ErrorType error, String description) {
        super(error.getBusinessMessage());
        this.businessMessage = error.getBusinessMessage();
        this.businessStatusCode = error.getBusinessStatusCode();
        this.description = description;
    }
}
