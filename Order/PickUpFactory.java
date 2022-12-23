package Order;

public class PickUpFactory {

    static class PickUptoDelivery implements Order.PickUp{
        private final String address;

        public void handle(Order order){
            System.out.println("---배달 관리 화면---\n"+
                    "배달의 민족으로 주문을 전달합니다!\n"+
                    "배송주소:"+address+"\n");
        }

        public PickUptoDelivery(String address) {
            this.address = address;
        }
    }

    static class PickUptoTakeOut implements Order.PickUp{

        public void handle(Order order){
            System.out.println("---테이크 아웃 화면---\n"+
                    "주문번호:"+order.getOrderNumber()+"\n"+
                    "주문하신 음료가 준비 되었습니다!\n");
        }

        public PickUptoTakeOut() {
        }
    }

    static class PickUptoDriveThru implements Order.PickUp{
        private final String carNumber;

        public void handle(Order order){
            System.out.println("---드라이브쓰루 관리 화면---\n"+
                    "차량번호"+carNumber+"\n"+
                    "주문이 완료되었습니다!\n");
        }

        public PickUptoDriveThru(String carNumber) {
            this.carNumber = carNumber;
        }
    }

    public static Order.PickUp makePickUpDelivery(String address){

        return  new PickUptoDelivery(address);
    }

    public static Order.PickUp makePickUpTakeOut(){
        return new PickUptoTakeOut();
    }

    public static Order.PickUp makePickUpDriveThru(String carNumber){
        return new PickUptoDriveThru(carNumber);
    }
}
