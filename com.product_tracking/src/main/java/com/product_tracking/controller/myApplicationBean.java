package com.product_tracking.controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my")
@AllArgsConstructor
@NoArgsConstructor
public class myApplicationBean {


    private String savePath;
    private String appURL;
    private String appUser;
    private String appPassword;

    public String getSavePath() {
        return savePath;
    }

    public String getAppURL() {
        return appURL;
    }

    public void setAppURL(String appURL) {
        this.appURL = appURL;
    }

    public String getAppUser() {
        return appUser;
    }

    public void setAppUser(String appUser) {
        this.appUser = appUser;
    }

    public String getAppPassword() {
        return appPassword;
    }

    public void setAppPassword(String appPassword) {
        this.appPassword = appPassword;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
