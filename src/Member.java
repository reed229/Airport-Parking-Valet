package src;

public class Member extends Customer {
    private String membershipId;
    

    public Member() {
        super();
        this.membershipId = "";
   
    }

    public Member(String name, String id, String contact, int duration, Vehicle vehicle, Valet val, String membershipId, String membership) {
        super(name, id, contact, duration, vehicle, val, membership);
        this.membershipId = membershipId;
        
    } 

    public Member(String membershipId, String mem) {
        super();
        this.membershipId = membershipId;
    }
    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }
    public String getMembershipId() {
        return membershipId;
    }


    @Override
    public String toString() {
        return super.toString() + "\nMembership ID: " + membershipId;
    }
}