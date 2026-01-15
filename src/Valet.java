package src;
public class Valet extends User{
    private String rating;

    public Valet() {
        super();
        this.rating = "";
    }
    public Valet(String name, String id, String contact, String rating) {
        super(name, id, contact);
        this.rating = rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }
    @Override
    public String toString() {
        return super.toString() + 
               "\nRating  : " + rating;
    }
} 
    

