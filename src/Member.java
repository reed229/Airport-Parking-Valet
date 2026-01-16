package src;

public class Member extends Customer {
    private String membershipId;

    public Member() {
        this.membershipId = "";
    }
    public Member(String membershipId) {
        this.membershipId = membershipId;
    }
    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }
    public String getMembershipId() {
        return membershipId;
    }

}

