package co.il.emet.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.hibernate.annotations.IndexColumn;

/**
 * 
 * @author Oleg B.
 *
 */
@JsonAutoDetect
@Entity
@Table(name="CC_OLEG")
public class L7ServiceConfig {
//  Oracle demo for seq. like auto_incrematal in MySql  ///////////	
//	@Id
//	@SequenceGenerator(name = "SOMETHING_SEQ")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOMETHING_SEQ")
//	@Column(name = "SOMETHING", nullable = false)
//	private Long id;
////////////////////////////////////////////////////////////////	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
	@SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "L7_SERVICE_CONFIG_ID_SEQ")
	@Column(name="CONTACT_ID")
	private int id;
	
	@Column(name="CONTACT_NAME", nullable=false)
	private String name;
	
	@Column(name="CONTACT_PHONE", nullable=false)
	private String phone;
	
	@Column(name="CONTACT_EMAIL", nullable=false)
	private String email;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
