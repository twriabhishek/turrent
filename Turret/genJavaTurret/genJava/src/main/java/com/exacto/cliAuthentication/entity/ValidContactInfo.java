package com.exacto.cliAuthentication.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Turrent_transaction")
public class ValidContactInfo {


		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name="txn_id")
	    private String txn_id;
	    
	    @Column(name="ip")
	    private String ip;
	    
	    @Column(name="txn_name")
	    private String txn_name;

		@Column(name="state")
	    private String state;

		@Column(name="prty_no")
	    private String prty_no;

		@Column(name="prty_ph_no")
	    private String prty_ph_no;

		@Column(name="line_name")
	    private String line_name;

		@Column(name="prty_name")
	    private String prty_name;

		@Column(name="contact_name")
	    private String contact_name;

		@Column(name="call_id")
	    private String call_id;
	    
	    // @Column(name = "date") 
	    // @Temporal(TemporalType.TIMESTAMP)
		// @CreationTimestamp
		// @DateTimeFormat(pattern = "dd-MM-yyyy")
		// private Date date;
	    
	    // @Column(name="queue_device_identifier")
	    // private String queueDeviceIdentifier;
	    
	    // @Column(name="deflect_num")
	    // private String deflectNum;
	    
}
