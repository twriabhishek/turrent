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
@Table(name = "Turrent_ip")
public class AuditContactInfo {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="ip")
    private String ip;
    
    @Column(name="port")
    private String port;
    
    @Column(name="turrent_name")
    private String turrent_name;
    
    // @Column(name="status")
    // private String status;
    
    // @Column(name="date")
    // @Temporal(TemporalType.TIMESTAMP)
	// @CreationTimestamp
	// @DateTimeFormat(pattern = "dd-MM-yyyy")
	// private Date date;
    
    // @Column(name="monitorCrossRefID")
    // private String monitorCrossRefID;
    
    // @Column(name="callId")
    // private String callId;
    
    // @Column(name="queue_deviceIdentifier")
    // private String queueDeviceIdentifier;

}
