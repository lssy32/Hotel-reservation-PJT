package Application;

public class Member {

    private int memberId;
    private String name;
    private String phoneNumber;
    private int memberMoney;

    public Member(){

    }

    public Member(int memberId, String name, String phoneNumber, int memberMoney){
        this.memberId = memberId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.memberMoney = memberMoney;
    }


    public int getMemberId() { return memberId; }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getMemberMoney() {
        return memberMoney;
    }

    public void setMemberMoney(int memberMoney) {
        this.memberMoney = memberMoney;
    }
}
