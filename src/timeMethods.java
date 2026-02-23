import java.text.*;

public class timeMethods{
    public static int N =20;
    public static void main(String[] args){
        int[] X = new int[32654];
        for(int i = 0; i < X.length; i++){
            X[i] = i;
        }

        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        long start, finish;
        double runTime = 0, runTime2 = 0, time;
        double totalTime = 0.0;
        int n = N;
        int repetition, repetitions = 30;

        runTime = 0;
        for(repetition = 0; repetition < repetitions; repetition++) {
            start = System.nanoTime();

            // call the procedures to time here:
            LinearSearch(X, n);
            BinarySearch (X, n);
            // Figure out how to alter this guideline here,

            finish = System.nanoTime();

            time = (double)(finish - start);
            runTime += time;
            runTime2 += (time*time); }

        double aveRuntime = runTime/repetitions;
        double stdDeviation =
                Math.sqrt(runTime2 - repetitions*aveRuntime*aveRuntime)/(repetitions-1);

        System.out.printf("\n\n\fStatistics\n");
        System.out.println("________________________________________________");
        System.out.println("Total time   =           " + runTime/1000 + "s.");
        System.out.println("Total time²  =           " + runTime2);
        System.out.println("Average time =           " + fiveD.format(aveRuntime/1000)
                + "s. " + '±' + " " + fourD.format(stdDeviation) + "ms.");
        System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
        System.out.println("n            =           " + n);
        System.out.println("Average time / run =     " + fiveD.format(aveRuntime/n*1000)
                + 'µ' + "s. ");

        System.out.println("Repetitions  =             " + repetitions);
        System.out.println("________________________________________________");
        System.out.println();
        System.out.println(); }

    public static void BinarySearch(int[] X, int target) {
        int low = 0;
        int high = X.length - 1;

        while(low<=high){
            int mid = (low+high)/2;

            if(X[mid]==target) return;
            else if(X[mid]<target){
                low = mid + 1;
            }else high = mid - 1;
        }
    }

    public static void LinearSearch(int[] X, int target) {

        for(int i = 0; i < X.length; i++){
            if(X[i]==target){
                return;
            }
        }
    }
}