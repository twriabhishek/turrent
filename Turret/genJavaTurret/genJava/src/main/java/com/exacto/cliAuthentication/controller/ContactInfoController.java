package com.exacto.cliAuthentication.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exacto.cliAuthentication.entity.AuditContactInfo;
import com.exacto.cliAuthentication.entity.ValidContactInfo;
import com.exacto.cliAuthentication.service.ContactInfoService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contactInfo")
public class ContactInfoController {

	    @Autowired
	    private ContactInfoService contactInfoService;

	    // Get all valid contacts
	    @GetMapping("/validContacts")
	    public List<ValidContactInfo> getAllValidContacts() {
	        return contactInfoService.getAllValidContacts();
	    }

	    // Get a valid contact by ID
	    @GetMapping("/validContact/{id}")
	    public Optional<ValidContactInfo> getValidContactById(@PathVariable Long id) {
	        return contactInfoService.getValidContactById(id);
	    }

	    // Save valid contact
	    @PostMapping("/addValidContact")
	    public void addValidCallDetails(@RequestBody ValidContactInfo contactInfo) {
	    	contactInfoService.saveValidContact(contactInfo);
	    	
	    }

	    // Update an valid contact
	    @PutMapping("/validContact")
	    public void updateValidContact(@RequestBody ValidContactInfo updatedContact) {
	        contactInfoService.updateValidContact(updatedContact);
	    }
		//Delete an Valid Contact
		@DeleteMapping("/validContact/{id}")
	    public void deleteValidContactById(@PathVariable Long id) {
			System.out.println("Inside delete");
	        contactInfoService.deleteValidContactById(id);
	    }

	    //check in db valid num if present then save in audit db as valid if not save details as invalid
	    @PostMapping("/addauditContact")
	    public void checkDbData(@RequestBody AuditContactInfo contactInfo) {
			System.out.println("Hello");
	    	contactInfoService.addCallDetails(contactInfo);
	    }
	

	    // Get all audit contacts
	    @GetMapping("/auditContacts")
	    public List<AuditContactInfo> getAllAuditContacts() {
	        return contactInfoService.getAllContacts();
	    }

	    // Get an audit contact by ID
	    @GetMapping("/auditContact/{id}")
	    public Optional<AuditContactInfo> getAuditContactById(@PathVariable Long id) {
	        return contactInfoService.getContactById(id);
	    }

	    // // Get audit details by phone number
	    // @GetMapping("/auditContactsByPhoneNo/{phoneNumber}")
	    // public List<AuditContactInfo> getAuditDetailsByPhoneNo(@PathVariable String phoneNumber) {
	    //     return contactInfoService.getAuditDetailsByPhoneNo(phoneNumber);
	    // }

	    // // Get audit details by status
	    // @GetMapping("/auditContactsByStatus/{status}")
	    // public List<AuditContactInfo> getAuditDetailsByStatus(@PathVariable String status) {
	    //     return contactInfoService.getAuditDetailsByStatus(status);
	    // }

	    // Get audit details by name
	    // @GetMapping("/auditContactsByName/{name}")
	    // public List<AuditContactInfo> getAuditDetailsByName(@PathVariable String name) {
	    //     return contactInfoService.getAuditDetailsByName(name);
	    // }

	    // Get audit details between two dates
	    // @GetMapping("/auditContactsBetweenDates")
	    // public List<AuditContactInfo> getAuditDetailsBetweenDates(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
	    //                                                         @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
	    //     return contactInfoService.getAuditDetailsBetweenDate(startDate, endDate);
	    // }

	    // Delete an audit contact by ID
	    @DeleteMapping("/auditContact/{id}")
	    public void deleteAuditContactById(@PathVariable Long id) {
	        contactInfoService.deleteAuditContactById(id);
	    }

	    // Update an audit contact
	    @PutMapping("/auditContact")
	    public void updateAuditContact(@RequestBody AuditContactInfo updatedContact) {
	        contactInfoService.updateAuditContact(updatedContact);
	    }
	}



