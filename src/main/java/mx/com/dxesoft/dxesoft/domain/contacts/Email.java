package mx.com.dxesoft.dxesoft.domain.contacts;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ernesto on 5/20/15.
 *
 * Represents contact's email
 */
public class Email {

    @NotNull
    @Size(max = 20)
    private String emailType;

    @NotNull
    @Size(max = 254)
    private String email;

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
