public class RentItems {
    private int Ronin = 35;
    private int SonyIV = 55;
    private int Bmpcc4k = 50;
    private int VideoMicro = 5;
    private int Tamron = 20;
    private int Sigma = 11;
    private int Droon = 35; //Mavic Pro

    public int gearRentPriceWithSony() {
        int gearRentPriceWithSony = Ronin + SonyIV + VideoMicro + Tamron;
        return gearRentPriceWithSony;
    }

    public int gearRentPriceWithSonyPlusDrone() {
        int gearRentPriceWithSonyPlusDrone= Ronin + SonyIV + VideoMicro + Tamron + Droon;
        return gearRentPriceWithSonyPlusDrone;
    }

    public int gearRentPriceWithBMPCC() {
        int gearRentPriceWithBMPCC = Ronin + Bmpcc4k + VideoMicro + Sigma;
        return gearRentPriceWithBMPCC;
    }

    public int gearRentPriceWithBMPCCPlusDrone() {
        int gearRentPriceWithBMPCCPlusDrone = Ronin + Bmpcc4k + VideoMicro + Sigma + Droon;
        return gearRentPriceWithBMPCCPlusDrone;
    }

    public int gearRentPriceWithSonyAndBMPCC() {
        int gearRentPriceWithSonyAndBMPCC = Ronin + SonyIV + Bmpcc4k + VideoMicro + Tamron + Sigma;
        return gearRentPriceWithSonyAndBMPCC;
    }

    public int gearRentPriceWithSonyAndBMPCCAndDrone() {
        int gearRentPriceWithSonyAndBMPCCAndDrone = Ronin + SonyIV + Bmpcc4k + VideoMicro + Tamron + Sigma + Droon;
        return gearRentPriceWithSonyAndBMPCCAndDrone;
    }
}