package jar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

public class Employee {
	//Variables
	@Id
	@Column(name="id", nullable =false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, length=45)
	@Size(max=45)
	@NotNull
	private String password_hash;
	
	//Employee constructor
	public Employee (int id, String password_hash) {
		
	}

	//Getters and setters
	public int getId() {
		return id;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	
	
}
