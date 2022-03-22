package testdata;

import models.LoginModel;
import staticdata.SecretData;

public class GetLoginModel {
    public static LoginModel loginModel() {
        String password = SecretData.PASSWORD;
        LoginModel loginModel = LoginModel
                .builder()
                .email(SecretData.EMAIL)
                .password(password)
                .build();
        return loginModel;
    }
}
