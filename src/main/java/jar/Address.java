/**
 * 
 */
package jar;

/**
 * @author Administrator
 *
 */
public class Address {
////////////////////////////////////////////////Attributes/////////////////////////////////////////////////////	
	private int id;
	private int house_number;
	private String line_1;
	private String line_2;
	private String postcode;
	private String city;



/////////////////////////////////////////// Constructor////////////////////////////////////////////////////////	
public Address (int id, int house_number, String line_1, String line_2,String postcode, String city)
	{
		this.id = id;
		this.house_number = house_number;
		this.line_1 = line_1;
		this.line_2 =line_2;
		this.postcode = postcode;
		this.city = city;
   
	}
///////////////////////////////////////////Default Constructor/////////////////////////////////////////////////	
public Address()
		{
	
		}


///////////////////////////////////////////Getters & Setters/////////////////////////////////////////////////

		public int getId() {
				return id;
			}
		public void setId(int id) {
				this.id = id;
			}
		public int getHouse_number() {
				return house_number;
			}
		public void setHouse_number(int house_number) {
				this.house_number = house_number;
			}
		public String getLine_1() {
				return line_1;
			}
		public void setLine_1(String line_1) {
				this.line_1 = line_1;
			}
		public String getLine_2() {
				return line_2;
			}
		public void setLine_2(String line_2) {
				this.line_2 = line_2;
			}
		public String getPostcode() {
				return postcode;
			}
		public void setPostcode(String postcode) {
				this.postcode = postcode;
			}
		public String getCity() {
				return city;
			}
		public void setCity(String city) {
				this.city = city;
			}
			






}