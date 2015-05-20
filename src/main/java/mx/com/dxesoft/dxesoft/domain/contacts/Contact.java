package mx.com.dxesoft.dxesoft.domain.contacts;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import mx.com.dxesoft.dxesoft.domain.util.CustomDateTimeDeserializer;
import mx.com.dxesoft.dxesoft.domain.util.CustomDateTimeSerializer;
import mx.com.dxesoft.dxesoft.domain.util.CustomLocalDateSerializer;
import mx.com.dxesoft.dxesoft.domain.util.ISO8601LocalDateDeserializer;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A Contact.
 */
@Document(collection = "T_CONTACT")
public class Contact implements Serializable {

    @Id
    private String id;

    @NotNull
    @Size(max = 200)
    @Field("nombres")
    private String nombres;

    @Size(max = 200)
    @Field("apellido_paterno")
    private String apellidoPaterno;

    @Size(max = 200)
    @Field("apellido_materno")
    private String apellidoMaterno;

    @Field("gender")
    private String gender;

    @JsonSerialize(using = CustomLocalDateSerializer.class)
    @JsonDeserialize(using = ISO8601LocalDateDeserializer.class)
    @Field("birth_date")
    private LocalDate birthDate;

    @Size(max = 250)
    @Field("company")
    private String company;

    @Size(max = 100)
    @Field("title")
    private String title;

    @Field("facebook")
    private String facebook;

    @Field("tiwtter")
    private String tiwtter;

    @Field("legal_id")
    private String legalId;

    @Field("owner")
    private String owner;

    @NotNull
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    @Field("creation_date")
    private DateTime creationDate;

    @NotNull
    @Field("dxesoft_Company")
    private String dxesoftCompany;

    private List<PhoneNumber> phoneList;

    private List<Email> emailList;

    private List<Address> addressList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTiwtter() {
        return tiwtter;
    }

    public void setTiwtter(String tiwtter) {
        this.tiwtter = tiwtter;
    }

    public String getLegalId() {
        return legalId;
    }

    public void setLegalId(String legalId) {
        this.legalId = legalId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getDxesoftCompany() {
        return dxesoftCompany;
    }

    public void setDxesoftCompany(String dxesoftCompany) {
        this.dxesoftCompany = dxesoftCompany;
    }

    public List<PhoneNumber> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<PhoneNumber> phoneList) {
        this.phoneList = phoneList;
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Contact contact = (Contact) o;

        if ( ! Objects.equals(id, contact.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", nombres='" + nombres + "'" +
                ", apellidoPaterno='" + apellidoPaterno + "'" +
                ", apellidoMaterno='" + apellidoMaterno + "'" +
                ", gender='" + gender + "'" +
                ", birthDate='" + birthDate + "'" +
                ", company='" + company + "'" +
                ", title='" + title + "'" +
                ", facebook='" + facebook + "'" +
                ", tiwtter='" + tiwtter + "'" +
                ", legalId='" + legalId + "'" +
                ", owner='" + owner + "'" +
                ", creationDate='" + creationDate + "'" +
                ", dxesoftCompany='" + dxesoftCompany + "'" +
                '}';
    }
}
