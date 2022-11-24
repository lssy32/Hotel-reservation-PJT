package Application;

public class Member {

    private String memberId;
    private String name;
    public int phoneNumber;
    private int memberMoney;

    public Member(String memberId, String name, int phoneNumber, int memberMoney){
        this.memberId = memberId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.memberMoney = memberMoney;
    }
    public String getMemberId() { return memberId; }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getMemberMoney() {
        return memberMoney;
    }
}
