package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.zaper;

public class AlternateSumNoTwoAdjesent {
    public static void main(String[] args){
        int[] arr ={1,2,1,3,2,3};
        System.out.println(maxPoints(arr));
    }

    static long maxPoints(int[] arr) {
        long incl = arr[0];
        long excl = 0;
        long excl_new;
        int i;

        for (i = 1; i < arr.length; i++)
        {
            excl_new = (incl > excl) ? incl : excl;
            incl = excl + arr[i];
            excl = excl_new;
        }
        return ((incl > excl) ? incl : excl);
    }

    int FindMaxSum(int arr[], int n)
    {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++)
        {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }
}
