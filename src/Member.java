package src;

public class Member extends Customer {
    private String membershipId;
    private String mem;

    public Member() {
        super();
        this.membershipId = "";
        this.mem = "";
    }

    public Member(String name, String id, String contact, int duration, Vehicle vehicle, Valet val, String membershipId, String mem) {
        super(name, id, contact, duration, vehicle, val);
        this.membershipId = "";
        this.mem = "";
    } 

    public Member(String membershipId, String mem) {
        super();
        this.membershipId = membershipId;
        this.mem = mem;
    }
    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }
    public void setMem(String mem) {
        this.mem = mem;
    }
    public String getMembershipId() {
        return membershipId;
    }
    public String getMem() {
        return mem;
    }
}

