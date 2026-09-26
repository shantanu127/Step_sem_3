class ParkingTicket {
    private String vehicleNo;
    private double ratePerMinute;

    public ParkingTicket(String vehicleNo, double ratePerMinute) {
        this.vehicleNo = vehicleNo;
        this.ratePerMinute = ratePerMinute;
    }

    // Locked against being overridden using 'final'
    public final double calculateFine(int overstayMinutes) {
        return overstayMinutes * ratePerMinute;
    }

    // Locked against being overridden using 'final'
    public final void printReceipt(int overstayMinutes) {
        double fine = calculateFine(overstayMinutes);
        System.out.println(vehicleNo + " - Fine: Rs " + fine);
    }

    public String getVehicleNo() {
        return vehicleNo;
    }
}

public class MainA3 {
    public static void main(String[] args) {
        String[] vehicleNos = {"TN09AB1234", "TN22CD5678", "TN09EF9012", "TN10GH3456"};
        double[] ratePerMinute = {2, 2, 3, 2};
        int[] overstayMinutes = {15, 0, -5, 8};

        for (int i = 0; i < vehicleNos.length; i++) {
            ParkingTicket ticket = new ParkingTicket(vehicleNos[i], ratePerMinute[i]);
            
            if (overstayMinutes[i] > 0) {
                ticket.printReceipt(overstayMinutes[i]);
            } else {
                System.out.println(ticket.getVehicleNo() + " - No fine, within allotted time");
            }
        }
    }
}