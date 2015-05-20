package mx.com.dxesoft.dxesoft.domain.contacts;

/**
 * Created by ernesto on 5/20/15.
 *
 * Represents a contact's address.
 */
public class Address {

    private String addressType;
    private String street;
    private String number_ext;
    private String number_int;
    private String zipcode;

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber_ext() {
        return number_ext;
    }

    public void setNumber_ext(String number_ext) {
        this.number_ext = number_ext;
    }

    public String getNumber_int() {
        return number_int;
    }

    public void setNumber_int(String number_int) {
        this.number_int = number_int;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
