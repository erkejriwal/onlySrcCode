package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.zaper;

public class Possible {
    public static void main(String[] args){
        System.out.println(isPossible(1,4,5,9));
    }
    static String isPossible(int a, int b, int c, int d) {
        if(c== a && b == d){
            return "Yes";
        }
        while (c!= 0 && d != 0 && (c != a || d != b)){

            if(c>d){
                c=c-d;
            }else{
                d=d-c;
            }
            if(c== a && b == d){
                return "Yes";
            }
        }
        return "No";
    }
}
