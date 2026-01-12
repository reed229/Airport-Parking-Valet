public class Admin extends User{
    private String password;

    public Admin(String name, String id, String contact, String password) {
        super(name, id, contact);
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "Role    : " + password;
    }
<<<<<<< HEAD
}
 

    

=======
}
>>>>>>> be30fd64cb4cb848ccc77d284f5b36495e3ddf33
