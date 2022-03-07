import java.util.HashMap;

public class Project extends RentItems {
    private HashMap<Integer, Integer> filmingDayAndHours;
    private int filmingHours;
    private int editingDays;
    private int editingHours;
    private boolean Sony;
    private boolean BMPCC;
    private boolean Drone;

    public Project(HashMap filmingDayAndHours, boolean Sony, boolean BMPCC, boolean drone, int editingHours) {
        this.filmingDayAndHours = filmingDayAndHours;
        this.editingHours = editingHours;
        this.Sony = Sony;
        this.BMPCC = BMPCC;
        this.Drone = drone;
    }

    public Project(int editingHours) {
        this.editingHours = editingHours;
    }

    public int calculateEditingPay() {
        int Pay = 0;
        Pay += editingHours * 15;
        return Pay;
    }

    public int calculatePay() {
        int under3Hours = 45;
        int Pay = 0;
        for (int i = 0; i < filmingDayAndHours.size(); i++) {
            filmingHours = filmingDayAndHours.get(i+1);
            if (filmingHours < 3) {
                Pay += under3Hours;
            } else {
//              Pay += filmingDayRate;
                Pay += filmingHours * 15;
            }
        }

        while (true) {
            if (Sony & BMPCC & Drone) {
                System.out.println("Sony + BMPCC + Drone");
                Pay += gearRentPriceWithSonyAndBMPCCAndDrone();
                break;
            }

            if (Sony & !(BMPCC) & Drone) {
                System.out.println("Sony + Drone");
                Pay += gearRentPriceWithSonyPlusDrone();
                break;
            }

            if (Sony & BMPCC & !(Drone)) {
                System.out.println("Sony + BMPCC Selected");
                Pay += gearRentPriceWithSonyPlusDrone();
                break;
            }

            if (Sony) {
                System.out.println("Only Sony");
                Pay += gearRentPriceWithSony();
                break;
            }

            if (BMPCC) {
                System.out.println("BMPCC only");
                Pay += gearRentPriceWithBMPCC();
                break;
            }
        }

        if (editingHours > 0) {
            Pay += editingHours * 15;
        }

        return Pay;
    }
}
