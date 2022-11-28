package Data;

public class HotelController {

    public void checkMemberPhoneNum(){}

    public void addMember(){}
    public void checkAvailableRoomList(){}

    public void comparePriceWithMoney(){}

<<<<<<< Updated upstream
    public void addReservation(){}

    public void plusTotalMoney(){}

    public void minusMemberMoeny(){}
=======
        //멤버 찾고 충전금 더하기
        for (int i = 0; i < hotel.getMemberList().size(); i++) {
            if (hotel.getMemberList().get(i).getPhoneNumber().equals(phoneNumber)) {
                hotel.getMemberList().get(i).setMemberMoney(hotel.getMemberList().get(i).getMemberMoney() + moneyRecharge);
                System.out.println("내가 가진 총 금액 : " + hotel.getMemberList().get(i).getMemberMoney());
            }
        }
    }
>>>>>>> Stashed changes

    public void rechargeMoney(){}

<<<<<<< Updated upstream
    public void getReservationList(){}

    public void showMyReservation(){}
=======
    public void showMyReservation() {

    }


    public boolean cancelReservation(String reservationNumber, Hotel hotel, Member member, Room room) {

        ArrayList<Reservation> reservationsList = hotel.getReservation();
        ArrayList<Room> currentRoomlist = hotel.getRoomList();


        for(int i=0; i<reservationsList.size(); i++){
            if(reservationsList.get(i).getReservationNumber().equals(reservationNumber)){
                Reservation reservation = reservationsList.get(i);

                int hotelMinusMoney = rechargeMoney(String.valueOf(reservation.getMemberId()), reservation.getRoomNum(), hotel);
                int hotelTotalMoney = getHotelTotalMoney(hotel);

                hotel.setTotalMoney(hotelTotalMoney-hotelMinusMoney);

                reservationsList.remove(reservation);
                return true;
            }
        }
        return false;
    }
>>>>>>> Stashed changes

    public void cancelReservation(){}

    public void checkAdminPassword(){}

<<<<<<< Updated upstream
    public void getMemberList(){}
=======
    public void getHotelTotalMoney() {

    }

    public boolean getMyReservationNumber(String reservationNumber, Hotel hotel){

        ArrayList<Reservation> reservationList = hotel.getReservationList();

        for(int i=0; i<reservationList.size(); i++){
            if(reservationList.get(i).getReservationNumber().equals(reservationNumber)){
                return true;
            }
        }
        return false;
    }
    public int rechargeMoney(String memberId, int roomNum, Hotel hotel) {

        ArrayList<Member> memberList = hotel.getMemberList();
        int currentMemberMoney = 0;

        int plusMoney = getRoomPrice(String.valueOf(roomNum), hotel);

        for(int i=0; i<memberList.size(); i++){
            if(memberList.get(i).getMemberId().equals(memberId)){
                currentMemberMoney = memberList.get(i).getMemberMoney();
                memberList.get(i).setMemberMoney(currentMemberMoney + plusMoney);
            }
        }
        return plusMoney;
    }

    public int getRoomPrice(String selectRoomNumber, Hotel hotel){

        ArrayList<Room> currentRoomlist = hotel.getRoomList();
        int roomPrice = 0;

        for(int i=0; i<currentRoomlist.size(); i++){
            if(currentRoomlist.get(i).getSize().equals(selectRoomNumber)){
                roomPrice = currentRoomlist.get(i).getPrice();
            }
        }
        return roomPrice;
    }
>>>>>>> Stashed changes

    public void getHotelTotalMoney(){}
}
