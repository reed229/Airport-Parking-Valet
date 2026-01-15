package src;
public class Admin extends User {
    private String password;

    public Admin() {
        super();
        this.password = "";
    }

    public Admin(String name, String id, String contact, String password) {
        super(name, id, contact);
        this.password = password;
    }

    // TODO: Add Valet

    // TODO: Remove Valet

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean verifyCredentials(String id, String inputPassword) {
        return this.getId().equals(id) && this.password.equals(inputPassword);
    }

    @Override
    public String toString() {
        return super.toString() + 
               "Role    : " + password;
    }
}
 

    

