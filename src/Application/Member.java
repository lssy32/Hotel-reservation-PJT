package Application;

public class Member {

    private String memberId;
    private String name;
    private String phoneNumber;
    private int memberMoney;

    public Member(){

    }

    public Member(String memberId, String name, String phoneNumber, int memberMoney){
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
