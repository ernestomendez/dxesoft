package mx.com.dxesoft.dxesoft.domain.contacts;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ernesto on 5/19/15.
 * Represents a contact's phone number.
 *
 */
@Document
public class PhoneNumber {

    @NotNull
    @Size(max = 20)
    private String phoneType;

    @NotNull
    @Size(max = 15)
    private String phoneNumber;

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
