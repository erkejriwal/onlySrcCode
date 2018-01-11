package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.companies.zaper;

public class Triangle {
    static int INF = 10000;
    public static void main(String[] args){
        int[] arr ={1,2,1,3,2,3};
        System.out.println(pointsBelongToTriangle(0,0,2,0,4,0,2,0,4,0));
    }
    static int pointsBelongToTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int xP, int yP, int xQ, int yQ) {
        double[] x = {x1,x2,x3};
        double[] y = {y1,y2,y3};
        double area = polygonArea(x,y,3);
        if(area == 0){
            return 0;
        }
        Point[] triangle = {new Point(x1,y1),new Point(x2,y2),new Point(x3,y3)};
        Point p = new Point(xP,yQ);
        boolean insideP = isInside(triangle,3,p) || eq(triangle,p);
        Point q = new Point(xQ,yQ);
        boolean insideQ = isInside(triangle,3,q) || eq(triangle,q);
        if(insideP && !insideQ){
            return 1;
        }else if(!insideP && insideQ){
            return 2;
        }else if(insideP && insideQ){
            return 3;
        }else{
            return 4;
        }
    }
    public static double polygonArea(double X[], double Y[], int n)
    {

        double area = 0.0;
        int j = n - 1;
        for (int i = 0; i < n; i++)
        {
            area += (X[j] + X[i]) * (Y[j] - Y[i]);
            j = i;
        }
        return Math.abs(area / 2.0);
    }

    public static boolean isInside(Point polygon[], int n, Point p)
    {
        if (n < 3)  return false;

        Point extreme = new Point(INF, p.y);

        int count = 0, i = 0;
        do
        {
            int next = (i+1)%n;

            if (doIntersect(polygon[i], polygon[next], p, extreme))
            {
                if (orientation(polygon[i], p, polygon[next]) == 0)
                    return onSegment(polygon[i], p, polygon[next]);
                count++;
            }
            i = next;
        } while (i != 0);

        return (count%2 == 1);  // Same as (count%2 == 1)
    }

    public static boolean onSegment(Point p, Point q, Point r)
    {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
            return true;
        return false;
    }

    public static int orientation(Point p, Point q, Point r)
    {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0;  // colinear
        return (val > 0)? 1: 2; // clock or counterclock wise
    }

    public static boolean doIntersect(Point p1, Point q1, Point p2, Point q2)
    {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        if (o1 != o2 && o3 != o4)
            return true;
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;

        if (o2 == 0 && onSegment(p1, q2, q1)) return true;

        if (o3 == 0 && onSegment(p2, p1, q2)) return true;

        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        return false; // Doesn't fall in any of the above cases
    }

   static  class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x= x;
            this.y = y;
        }
    }

    public static boolean eq(Point[] points, Point p){
        for (int i = 0; i <points.length ; i++) {
            if(p.x == points[i].x && p.y == points[i].y ){
                return true;
            }
        }
        return false;
    }
}
