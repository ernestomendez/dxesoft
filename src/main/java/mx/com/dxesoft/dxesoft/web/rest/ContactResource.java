package mx.com.dxesoft.dxesoft.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.com.dxesoft.dxesoft.domain.contacts.Contact;
import mx.com.dxesoft.dxesoft.repository.ContactRepository;
import mx.com.dxesoft.dxesoft.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Contact.
 */
@RestController
@RequestMapping("/api")
public class ContactResource {

    private final Logger log = LoggerFactory.getLogger(ContactResource.class);

    @Inject
    private ContactRepository contactRepository;

    /**
     * POST  /contacts -> Create a new contact.
     */
    @RequestMapping(value = "/contacts",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Contact> create(@Valid @RequestBody Contact contact) throws URISyntaxException {
        log.debug("REST request to save Contact : {}", contact);
        contactRepository.save(contact);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    /**
     * PUT  /contacts -> Updates an existing contact.
     */
    @RequestMapping(value = "/contacts",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> update(@Valid @RequestBody Contact contact) throws URISyntaxException {
        log.debug("REST request to update Contact : {}", contact);
        contactRepository.save(contact);
        return ResponseEntity.ok().build();
    }

    /**
     * GET  /contacts -> get all the contacts.
     */
    @RequestMapping(value = "/contacts",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<Contact>> getAll(@RequestParam(value = "page" , required = false) Integer offset,
                                  @RequestParam(value = "per_page", required = false) Integer limit)
        throws URISyntaxException {
        Page<Contact> page = contactRepository.findAll(PaginationUtil.generatePageRequest(offset, limit));
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/contacts", offset, limit);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /contacts/:id -> get the "id" contact.
     */
    @RequestMapping(value = "/contacts/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Contact> get(@PathVariable String id) {
        log.debug("REST request to get Contact : {}", id);
        return Optional.ofNullable(contactRepository.findOne(id))
            .map(contact -> new ResponseEntity<>(
                contact,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /contacts/:id -> delete the "id" contact.
     */
    @RequestMapping(value = "/contacts/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void delete(@PathVariable String id) {
        log.debug("REST request to delete Contact : {}", id);
        contactRepository.delete(id);
    }

    /**
     * GET /contacts?nombre={nombre} -> search contacts by name.
     *
     * @param offset    page offset
     * @param limit     limit of contacts by page
     * @param nombre    nombre to search
     * @return          list of contacts
     * @throws URISyntaxException
     */
    @RequestMapping(value = "/contacts",
                    params = {"nombre"},
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<Contact>> findByName(@RequestParam(value = "page" , required = false) Integer offset,
                                                    @RequestParam(value = "per_page", required = false) Integer limit,
                                                    @RequestParam("nombre") String nombre) throws URISyntaxException {
        log.debug("REST request to get Contact by name");
//        Page<Contact> page = contactRepository.findByNombresContainingIgnoreCaseOrApellidoPaternoContainingIgnoreCaseOrApellidoMaternoContainingIgnoreCase(nombre, nombre, nombre, PaginationUtil.generatePageRequest(offset, limit));
        Page<Contact> page = contactRepository.findByNombresContainingOrApellidoPaternoContainingOrApellidoMaternoContainingQuery(nombre, nombre, nombre, PaginationUtil.generatePageRequest(offset, limit));
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/contacts", offset, limit);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
