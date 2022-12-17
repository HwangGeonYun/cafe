package Order;

public class PickUpFactory {

    static class PickUptoDelivery implements Order.PickUp{
        private String address;

        public void handle(){

        }

        public PickUptoDelivery(String address) {
            this.address = address;
        }
    }

    static class PickUptoTakeOut implements Order.PickUp{



        public void handle(){

        }

        public PickUptoTakeOut() {
        }
    }

    static class PickUptoDriveThru implements Order.PickUp{
        private String carNumber;

        public void handle(){

        }

        public PickUptoDriveThru(String carNumber) {
            this.carNumber = carNumber;
        }
    }

    public static PickUptoDelivery makePickUpDelivery(String address){

        return  new PickUptoDelivery(address);
    }

    public static PickUptoTakeOut makePickUpTakeOut(){
        return new PickUptoTakeOut();
    }

    public static PickUptoDriveThru PickUptoDriveThru(String carNumber){
        return new PickUptoDriveThru(carNumber);
    }
}
