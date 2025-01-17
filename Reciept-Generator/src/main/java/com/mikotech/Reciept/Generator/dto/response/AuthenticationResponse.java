package com.mikotech.Reciept.Generator.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuthenticationResponse {
    private String token;
    private boolean MFAEnabled;
    private String refreshToken;
    private String secretImageUri;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isMFAEnabled() {
        return MFAEnabled;
    }

    public void setMFAEnabled(boolean MFAEnabled) {
        this.MFAEnabled = MFAEnabled;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getSecretImageUri() {
        return secretImageUri;
    }

    public void setSecretImageUri(String secretImageUri) {
        this.secretImageUri = secretImageUri;
    }
}
