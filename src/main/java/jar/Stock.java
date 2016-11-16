package jar;

import javax.persistence.*;

@Entity
@Table(name="stock")
public class Stock {
	//Variables
	@Id
	@Column(name="id", nullable =false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//Stock constructor
	public Stock(int id) {
		
	}

	//Getters and setters
	public int getId() {
		return id;
	}

	
}
