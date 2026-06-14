package FundamentalJava.TipeDataPrimitif.Latihan;

// Compute distance light travels using long variables.
public class KecepatanCahaya {
    public static void main(String[] args) {

        int lightspeed;
        long days;
        long second;
        long distance;

        // approximate speed of light in miles per second
        lightspeed = 186000;

        days = 1000; // specify number of days here
        second = days * 24 * 60 * 60; // convert to second
        distance = lightspeed * second; // compute distance

        System.out.print("In " + days);
        System.out.print(" days light will travel about ");
        System.out.println(distance + " miles.");


    }
}
