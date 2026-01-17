package src;
public class User{
	protected String name;
	protected String id;
	protected String contact;

	public User(){
		this.name = "";
		this.id = "";
		this.contact = "";
	}
	
	
	public User(String name, String id, String contact){
		this.name = name;
		this.id = id;
		this.contact = contact;
	}
	
	public void setName (String name){
		this.name = name;
	}
	public void setId (String id){
		this.id = id;
	}
	public void setContact (String contact){
		this.contact = contact;
	}
	
	public String getName(){
		return name;
	}
	public String getId(){
		return id;
	}
	public String getContact(){
		return contact;
	}

	@Override
	public String toString(){
		return 	"Name: " + name +
				"\nId: " + id +
				"\nContact: " +contact;
	}

}
