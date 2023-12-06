package com.exacto.cliAuthentication.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exacto.cliAuthentication.entity.AuditContactInfo;
import com.exacto.cliAuthentication.entity.ValidContactInfo;
import com.exacto.cliAuthentication.repo.AuditContactRepo;
import com.exacto.cliAuthentication.repo.ValidNumRepo;

@Service
public class ContactInfoService {
	
	    @Autowired
	    private ValidNumRepo validRepo;
	    
	    @Autowired
	    private AuditContactRepo auditContactRepo;
	    
	    
	  
	    public ContactInfoService(ValidNumRepo validRepo , AuditContactRepo auditContactRepo) {
	        this.validRepo = validRepo;
	        this.auditContactRepo=auditContactRepo;
	    }

	    public List<ValidContactInfo> getAllValidContacts() {
	        return validRepo.findAll();
	    }

	    public Optional<ValidContactInfo> getValidContactById(Long id) {
	        return validRepo.findById(id);
	    }

	    public ValidContactInfo saveValidContact(ValidContactInfo contact) {
	        return validRepo.save(contact);
	    }

		public void updateValidContact(ValidContactInfo updatedContact) {
	        ValidContactInfo existingContact = validRepo.findById(updatedContact.getId()).orElse(null);
	        if (existingContact != null) {
	            // Update the fields of the existing contact with the new values
	            existingContact.setTxn_id(updatedContact.getTxn_id());
				existingContact.setIp(updatedContact.getIp());
				existingContact.setTxn_name(updatedContact.getTxn_name());
				existingContact.setState(updatedContact.getState());
				existingContact.setPrty_no(updatedContact.getPrty_no());
				existingContact.setPrty_ph_no(updatedContact.getPrty_ph_no());
				existingContact.setLine_name(updatedContact.getLine_name());
				existingContact.setPrty_name(updatedContact.getPrty_name());
				existingContact.setContact_name(updatedContact.getContact_name());
				existingContact.setCall_id(updatedContact.getCall_id());
	            // Update other fields as needed
	            validRepo.save(existingContact);
	        }
	    }

		public void deleteValidContactById(Long id) {
			// TODO Auto-generated method stub
			System.out.println("inside delete service .................");
			  validRepo.deleteById(id);
		}
	    
	    
	    public List<AuditContactInfo> getAllContacts() {
	        return auditContactRepo.findAll();
	    }

	    public Optional<AuditContactInfo> getContactById(Long id) {
	        return auditContactRepo.findById(id);
	    }

	    public AuditContactInfo saveInvalidContact(AuditContactInfo contact) {
	        return auditContactRepo.save(contact);
	    }
	    
	    // public List<AuditContactInfo> getAuditDetailsByPhoneNo(String phoneNumber) {
	    //     return auditContactRepo.findByPhoneNum(phoneNumber);
	    // }
	    
	    // public List<AuditContactInfo> getAuditDetailsByStatus(String status) {
	    //     return auditContactRepo.findByStatus(status);
	    // }

	    // public List<AuditContactInfo> getAuditDetailsByName(String name) {
	    //     return auditContactRepo.findByPhoneName(name);
	    // }

	    // public List<AuditContactInfo> getAuditDetailsBetweenDate(Date startDate, Date endDate) {
	    //     return auditContactRepo.findByDateBetween(startDate, endDate);
	    // }

	    public void updateAuditContact(AuditContactInfo updatedContact) {
	        AuditContactInfo existingContact = auditContactRepo.findById(updatedContact.getId()).orElse(null);
	        if (existingContact != null) {
	            // Update the fields of the existing contact with the new values
	            existingContact.setIp(updatedContact.getIp());
	            existingContact.setPort(updatedContact.getPort());
				existingContact.setTurrent_name(updatedContact.getTurrent_name());
	            // Update other fields as needed
	            auditContactRepo.save(existingContact);
	        }
	    }

	
	   
		public void deleteAuditContactById(Long id) {
			// TODO Auto-generated method stub
			auditContactRepo.deleteById(id);
			
		}
		
		public void addCallDetails(AuditContactInfo contactInfo) {
		    // String displayNumber = contactInfo.getDisplayNum();
		    // Optional<ValidContactInfo> contact = validRepo.findByDisplayNum(displayNumber);
		    // if (contact.isPresent()) {
		    //     contactInfo.setStatus("valid");
		    // } else {
		    //     contactInfo.setStatus("invalid");
		    // }
		    auditContactRepo.save(contactInfo);
		}
	    }


	    
