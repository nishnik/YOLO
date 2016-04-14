package kgp.tech.interiit.sos.Utils;

/**
 * Created by nishantiam on 14-04-2016.
 */

public class members {
    static double slope(int a,int b,int c,int d,int x){
        if(x < a)
        {
            return 0;
        }
        else if(x>=a && x< b)
        {
            return (double)(x-a)/(b-a);
        }
        else if(x>=b && x< c)
        {
            return 1;
        }
        else if(x >= c && x<=d)
        {
            return (double)(d-x)/(d-c);
        }
        else return 0;
    }
}
