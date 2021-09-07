 import java.util.HashSet;
    import java.util.Set;

    public class ServiceManagement {
        private Parking parking = new Parking();
        private CarWashServices carWashServices = new CarWashServices();
        private Set<Service> services = new HashSet<>();

        public ServiceManagement() {

        }

        public void addService(Service a) {
            services.add(a);
            if(a.isPrk()) { 
                parking.addCar(10, a.getCar());
            } else {
                carWashServices.addCar(a.getCar());
            }
        }

        public void closeService(Service a) {
               if(services.contains(a)){
                    System.out.println("Preço total: "+ a.getPrice()) ;
                    parking.removerCar(a.getCar());
                    carWashServices.removeCar(a.getCar());          
                    services.remove(a);
               }
        }

    }
