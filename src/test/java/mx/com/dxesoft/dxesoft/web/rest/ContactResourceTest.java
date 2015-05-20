package mx.com.dxesoft.dxesoft.web.rest;

import mx.com.dxesoft.dxesoft.Application;
import mx.com.dxesoft.dxesoft.domain.contacts.Contact;
import mx.com.dxesoft.dxesoft.repository.ContactRepository;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.joda.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ContactResource REST controller.
 *
 * @see ContactResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class ContactResourceTest {

    private static final String DEFAULT_NOMBRES = "SAMPLE_TEXT";
    private static final String UPDATED_NOMBRES = "UPDATED_TEXT";
    private static final String DEFAULT_APELLIDO_PATERNO = "SAMPLE_TEXT";
    private static final String UPDATED_APELLIDO_PATERNO = "UPDATED_TEXT";
    private static final String DEFAULT_APELLIDO_MATERNO = "SAMPLE_TEXT";
    private static final String UPDATED_APELLIDO_MATERNO = "UPDATED_TEXT";
    private static final String DEFAULT_GENDER = "SAMPLE_TEXT";
    private static final String UPDATED_GENDER = "UPDATED_TEXT";

    private static final LocalDate DEFAULT_BIRTH_DATE = new LocalDate(0L);
    private static final LocalDate UPDATED_BIRTH_DATE = new LocalDate();
    private static final String DEFAULT_COMPANY = "SAMPLE_TEXT";
    private static final String UPDATED_COMPANY = "UPDATED_TEXT";
    private static final String DEFAULT_TITLE = "SAMPLE_TEXT";
    private static final String UPDATED_TITLE = "UPDATED_TEXT";
    private static final String DEFAULT_EMAIL = "SAMPLE_TEXT";
    private static final String UPDATED_EMAIL = "UPDATED_TEXT";
    private static final String DEFAULT_PHONE_NUMBER = "SAMPLE_TEXT";
    private static final String UPDATED_PHONE_NUMBER = "UPDATED_TEXT";
    private static final String DEFAULT_ADDRESS = "SAMPLE_TEXT";
    private static final String UPDATED_ADDRESS = "UPDATED_TEXT";
    private static final String DEFAULT_FACEBOOK = "SAMPLE_TEXT";
    private static final String UPDATED_FACEBOOK = "UPDATED_TEXT";
    private static final String DEFAULT_TIWTTER = "SAMPLE_TEXT";
    private static final String UPDATED_TIWTTER = "UPDATED_TEXT";
    private static final String DEFAULT_LEGAL_ID = "SAMPLE_TEXT";
    private static final String UPDATED_LEGAL_ID = "UPDATED_TEXT";
    private static final String DEFAULT_OWNER = "SAMPLE_TEXT";
    private static final String UPDATED_OWNER = "UPDATED_TEXT";

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    private static final DateTime DEFAULT_CREATION_DATE = new DateTime(0L, DateTimeZone.UTC);
    private static final DateTime UPDATED_CREATION_DATE = new DateTime(DateTimeZone.UTC).withMillisOfSecond(0);
    private static final String DEFAULT_CREATION_DATE_STR = dateTimeFormatter.print(DEFAULT_CREATION_DATE);
    private static final String DEFAULT_DXESOFT_COMPANY = "SAMPLE_TEXT";
    private static final String UPDATED_DXESOFT_COMPANY = "UPDATED_TEXT";

    @Inject
    private ContactRepository contactRepository;

    private MockMvc restContactMockMvc;

    private Contact contact;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ContactResource contactResource = new ContactResource();
        ReflectionTestUtils.setField(contactResource, "contactRepository", contactRepository);
        this.restContactMockMvc = MockMvcBuilders.standaloneSetup(contactResource).build();
    }

    @Before
    public void initTest() {
        contactRepository.deleteAll();
        contact = new Contact();
        contact.setNombres(DEFAULT_NOMBRES);
        contact.setApellidoPaterno(DEFAULT_APELLIDO_PATERNO);
        contact.setApellidoMaterno(DEFAULT_APELLIDO_MATERNO);
        contact.setGender(DEFAULT_GENDER);
        contact.setBirthDate(DEFAULT_BIRTH_DATE);
        contact.setCompany(DEFAULT_COMPANY);
        contact.setTitle(DEFAULT_TITLE);
//        contact.setEmail(DEFAULT_EMAIL);
//        contact.setPhoneNumber(DEFAULT_PHONE_NUMBER);
//        contact.setAddress(DEFAULT_ADDRESS);
        contact.setFacebook(DEFAULT_FACEBOOK);
        contact.setTiwtter(DEFAULT_TIWTTER);
        contact.setLegalId(DEFAULT_LEGAL_ID);
        contact.setOwner(DEFAULT_OWNER);
        contact.setCreationDate(DEFAULT_CREATION_DATE);
        contact.setDxesoftCompany(DEFAULT_DXESOFT_COMPANY);
    }

    @Test
    public void createContact() throws Exception {
        // Validate the database is empty
        assertThat(contactRepository.findAll()).hasSize(0);

        // Create the Contact
        restContactMockMvc.perform(post("/api/contacts")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(contact)))
                .andExpect(status().isCreated());

        // Validate the Contact in the database
        List<Contact> contacts = contactRepository.findAll();
        assertThat(contacts).hasSize(1);
        Contact testContact = contacts.iterator().next();
        assertThat(testContact.getNombres()).isEqualTo(DEFAULT_NOMBRES);
        assertThat(testContact.getApellidoPaterno()).isEqualTo(DEFAULT_APELLIDO_PATERNO);
        assertThat(testContact.getApellidoMaterno()).isEqualTo(DEFAULT_APELLIDO_MATERNO);
        assertThat(testContact.getGender()).isEqualTo(DEFAULT_GENDER);
        assertThat(testContact.getBirthDate()).isEqualTo(DEFAULT_BIRTH_DATE);
        assertThat(testContact.getCompany()).isEqualTo(DEFAULT_COMPANY);
        assertThat(testContact.getTitle()).isEqualTo(DEFAULT_TITLE);
//        assertThat(testContact.getEmail()).isEqualTo(DEFAULT_EMAIL);
//        assertThat(testContact.getPhoneNumber()).isEqualTo(DEFAULT_PHONE_NUMBER);
//        assertThat(testContact.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testContact.getFacebook()).isEqualTo(DEFAULT_FACEBOOK);
        assertThat(testContact.getTiwtter()).isEqualTo(DEFAULT_TIWTTER);
        assertThat(testContact.getLegalId()).isEqualTo(DEFAULT_LEGAL_ID);
        assertThat(testContact.getOwner()).isEqualTo(DEFAULT_OWNER);
        assertThat(testContact.getCreationDate().toDateTime(DateTimeZone.UTC)).isEqualTo(DEFAULT_CREATION_DATE);
        assertThat(testContact.getDxesoftCompany()).isEqualTo(DEFAULT_DXESOFT_COMPANY);
    }

    @Test
    public void getAllContacts() throws Exception {
        // Initialize the database
        contactRepository.save(contact);

        // Get all the contacts
        restContactMockMvc.perform(get("/api/contacts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].id").value(contact.getId()))
                .andExpect(jsonPath("$.[0].nombres").value(DEFAULT_NOMBRES.toString()))
                .andExpect(jsonPath("$.[0].apellidoPaterno").value(DEFAULT_APELLIDO_PATERNO.toString()))
                .andExpect(jsonPath("$.[0].apellidoMaterno").value(DEFAULT_APELLIDO_MATERNO.toString()))
                .andExpect(jsonPath("$.[0].gender").value(DEFAULT_GENDER.toString()))
                .andExpect(jsonPath("$.[0].birthDate").value(DEFAULT_BIRTH_DATE.toString()))
                .andExpect(jsonPath("$.[0].company").value(DEFAULT_COMPANY.toString()))
                .andExpect(jsonPath("$.[0].title").value(DEFAULT_TITLE.toString()))
//                .andExpect(jsonPath("$.[0].email").value(DEFAULT_EMAIL.toString()))
//                .andExpect(jsonPath("$.[0].phoneNumber").value(DEFAULT_PHONE_NUMBER.toString()))
//                .andExpect(jsonPath("$.[0].address").value(DEFAULT_ADDRESS.toString()))
                .andExpect(jsonPath("$.[0].facebook").value(DEFAULT_FACEBOOK.toString()))
                .andExpect(jsonPath("$.[0].tiwtter").value(DEFAULT_TIWTTER.toString()))
                .andExpect(jsonPath("$.[0].legalId").value(DEFAULT_LEGAL_ID.toString()))
                .andExpect(jsonPath("$.[0].owner").value(DEFAULT_OWNER.toString()))
                .andExpect(jsonPath("$.[0].creationDate").value(DEFAULT_CREATION_DATE_STR))
                .andExpect(jsonPath("$.[0].dxesoftCompany").value(DEFAULT_DXESOFT_COMPANY.toString()));
    }

    @Test
    public void getContact() throws Exception {
        // Initialize the database
        contactRepository.save(contact);

        // Get the contact
        restContactMockMvc.perform(get("/api/contacts/{id}", contact.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(contact.getId()))
            .andExpect(jsonPath("$.nombres").value(DEFAULT_NOMBRES.toString()))
            .andExpect(jsonPath("$.apellidoPaterno").value(DEFAULT_APELLIDO_PATERNO.toString()))
            .andExpect(jsonPath("$.apellidoMaterno").value(DEFAULT_APELLIDO_MATERNO.toString()))
            .andExpect(jsonPath("$.gender").value(DEFAULT_GENDER.toString()))
            .andExpect(jsonPath("$.birthDate").value(DEFAULT_BIRTH_DATE.toString()))
            .andExpect(jsonPath("$.company").value(DEFAULT_COMPANY.toString()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE.toString()))
//            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL.toString()))
//            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER.toString()))
//            .andExpect(jsonPath("$.address").value(DEFAULT_ADDRESS.toString()))
            .andExpect(jsonPath("$.facebook").value(DEFAULT_FACEBOOK.toString()))
            .andExpect(jsonPath("$.tiwtter").value(DEFAULT_TIWTTER.toString()))
            .andExpect(jsonPath("$.legalId").value(DEFAULT_LEGAL_ID.toString()))
            .andExpect(jsonPath("$.owner").value(DEFAULT_OWNER.toString()))
            .andExpect(jsonPath("$.creationDate").value(DEFAULT_CREATION_DATE_STR))
            .andExpect(jsonPath("$.dxesoftCompany").value(DEFAULT_DXESOFT_COMPANY.toString()));
    }

    @Test
    public void getNonExistingContact() throws Exception {
        // Get the contact
        restContactMockMvc.perform(get("/api/contacts/{id}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateContact() throws Exception {
        // Initialize the database
        contactRepository.save(contact);

        // Update the contact
        contact.setNombres(UPDATED_NOMBRES);
        contact.setApellidoPaterno(UPDATED_APELLIDO_PATERNO);
        contact.setApellidoMaterno(UPDATED_APELLIDO_MATERNO);
        contact.setGender(UPDATED_GENDER);
        contact.setBirthDate(UPDATED_BIRTH_DATE);
        contact.setCompany(UPDATED_COMPANY);
        contact.setTitle(UPDATED_TITLE);
//        contact.setEmail(UPDATED_EMAIL);
//        contact.setPhoneNumber(UPDATED_PHONE_NUMBER);
//        contact.setAddress(UPDATED_ADDRESS);
        contact.setFacebook(UPDATED_FACEBOOK);
        contact.setTiwtter(UPDATED_TIWTTER);
        contact.setLegalId(UPDATED_LEGAL_ID);
        contact.setOwner(UPDATED_OWNER);
        contact.setCreationDate(UPDATED_CREATION_DATE);
        contact.setDxesoftCompany(UPDATED_DXESOFT_COMPANY);
        restContactMockMvc.perform(put("/api/contacts")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(contact)))
                .andExpect(status().isOk());

        // Validate the Contact in the database
        List<Contact> contacts = contactRepository.findAll();
        assertThat(contacts).hasSize(1);
        Contact testContact = contacts.iterator().next();
        assertThat(testContact.getNombres()).isEqualTo(UPDATED_NOMBRES);
        assertThat(testContact.getApellidoPaterno()).isEqualTo(UPDATED_APELLIDO_PATERNO);
        assertThat(testContact.getApellidoMaterno()).isEqualTo(UPDATED_APELLIDO_MATERNO);
        assertThat(testContact.getGender()).isEqualTo(UPDATED_GENDER);
        assertThat(testContact.getBirthDate()).isEqualTo(UPDATED_BIRTH_DATE);
        assertThat(testContact.getCompany()).isEqualTo(UPDATED_COMPANY);
        assertThat(testContact.getTitle()).isEqualTo(UPDATED_TITLE);
//        assertThat(testContact.getEmail()).isEqualTo(UPDATED_EMAIL);
//        assertThat(testContact.getPhoneNumber()).isEqualTo(UPDATED_PHONE_NUMBER);
//        assertThat(testContact.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testContact.getFacebook()).isEqualTo(UPDATED_FACEBOOK);
        assertThat(testContact.getTiwtter()).isEqualTo(UPDATED_TIWTTER);
        assertThat(testContact.getLegalId()).isEqualTo(UPDATED_LEGAL_ID);
        assertThat(testContact.getOwner()).isEqualTo(UPDATED_OWNER);
        assertThat(testContact.getCreationDate().toDateTime(DateTimeZone.UTC)).isEqualTo(UPDATED_CREATION_DATE);
        assertThat(testContact.getDxesoftCompany()).isEqualTo(UPDATED_DXESOFT_COMPANY);
    }

    @Test
    public void deleteContact() throws Exception {
        // Initialize the database
        contactRepository.save(contact);

        // Get the contact
        restContactMockMvc.perform(delete("/api/contacts/{id}", contact.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Contact> contacts = contactRepository.findAll();
        assertThat(contacts).hasSize(0);
    }
}
