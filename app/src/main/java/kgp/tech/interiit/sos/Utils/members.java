package kgp.tech.interiit.sos.Utils;

/**
 * Created by nishantiam on 14-04-2016.
 */

public class members {
    static double slope(int a,int b,int c,int d,double x){
        if(x < (double)a)
        {
            return 0.0;
        }
        else if(x>=(double)a && x< (double)b)
        {
            return (double)(x-a)/(double)(b-a);
        }
        else if(x>=(double)b && x< (double)c)
        {
            return 1.0;
        }
        else if(x >= (double)c && x<=(double)d)
        {
            return (double)(d-x)/(double)(d-c);
        }
        else return 0;
    }
}
