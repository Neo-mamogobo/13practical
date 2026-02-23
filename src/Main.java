

public class Main {
    public static void main(String[] args) {
        int[] X = new int[32654];

        int lin = linearsearch(X,70);
        int ban = binarysearch(X,45);

        System.out.println(lin);

    }

    private static int binarysearch(int[] X, int target) {
        int low = 0;
        int high = X.length - 1;

        while(low<=high){
            int mid = (low+high)/2;

            if(X[mid]==target) return mid;
            else if(X[mid]<target){
                high = mid - 1;
            }else low = mid + 1;
        }
        return -1;
    }

    private static int linearsearch(int[] X, int target) {

        for(int i = 0; i < X.length; i++){
            if(X[i]==target){
                return i;
            }
        }
        return -1;
    }
}