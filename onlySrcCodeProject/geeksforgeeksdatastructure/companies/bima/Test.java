package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.bima;

public class Test 
{
    public static void main(String [] args) 
    {
        Test p = new Test();
        p.start();
    }

    void start() 
    {
        String s1 = "step";
        String s2 = fix(s1);
        System.out.println(s1 + " " + s2);
    }

    String fix(String s1) 
    {
        s1 = s1 + "steem";
        System.out.print(s1 + " ");
        return "steem";
    }
}