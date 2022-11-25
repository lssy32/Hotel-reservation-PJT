package Application;

public class Member {

    private String memberId;
    private String name;
    public String phoneNumber;
    private int memberMoney;

    public Member(){
        this.memberId = memberId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.memberMoney = memberMoney;
    }
    public String getMemberId() { return memberId; }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getMemberMoney() {
        return memberMoney;
    }
}
