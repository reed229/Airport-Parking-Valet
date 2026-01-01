public class Admin extends User{
    private String role;

    public Admin(String name, String id, String contact, String role) {
        super(name, id, contact);
        this.role = role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "Role    : " + role;
    }
}
 {

    
}
