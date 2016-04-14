package kgp.tech.interiit.sos.Utils;

/**
 * Created by nishantiam on 14-04-2016.
 */
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.String;
import java.util.Iterator;
import java.util.Scanner;

public class ssoft{
    static int s_home_input;
    static int s_work_input;
    static int s_fitness_input;
    static int s_social_input;
    static int s_others_input;

    static int s_home_hectic_a = 0;
    static int s_home_hectic_b = 0;
    static int s_home_hectic_c = 420;
    static int s_home_hectic_d = 480;

    static int s_home_ideal_a = 420;
    static int s_home_ideal_b = 600;
    static int s_home_ideal_c = 720;
    static int s_home_ideal_d = 780;

    static int s_home_lazy_a = 720;
    static int s_home_lazy_b = 780;
    static int s_home_lazy_c = 900;
    static int s_home_lazy_d = 960;

    static int s_home_vlazy_a = 900;
    static int s_home_vlazy_b = 960;
    static int s_home_vlazy_c = 1440;
    static int s_home_vlazy_d = 1440;

    static int s_work_less_a = 0;
    static int s_work_less_b = 0;
    static int s_work_less_c = 180;
    static int s_work_less_d = 300;

    static int s_work_avg_a = 180;
    static int s_work_avg_b = 360;
    static int s_work_avg_c = 420;
    static int s_work_avg_d = 480;

    static int s_work_good_a = 420;
    static int s_work_good_b = 480;
    static int s_work_good_c = 600;
    static int s_work_good_d = 720;

    static int s_work_hectic_a = 660;
    static int s_work_hectic_b = 720;
    static int s_work_hectic_c = 1440;
    static int s_work_hectic_d = 1440;

    static int s_fitness_less_a = 0;
    static int s_fitness_less_b = 0;
    static int s_fitness_less_c = 30;
    static int s_fitness_less_d = 60;

    static int s_fitness_good_a = 45;
    static int s_fitness_good_b = 60;
    static int s_fitness_good_c = 90;
    static int s_fitness_good_d = 120;

    static int s_fitness_vgood_a = 90;
    static int s_fitness_vgood_b = 120;
    static int s_fitness_vgood_c = 150;
    static int s_fitness_vgood_d = 180;

    static int s_fitness_excess_a = 175;
    static int s_fitness_excess_b = 180;
    static int s_fitness_excess_c = 1440;
    static int s_fitness_excess_d = 1440;

    static int s_social_less_a = 0;
    static int s_social_less_b = 0;
    static int s_social_less_c = 45;
    static int s_social_less_d = 90;

    static int s_social_good_a = 60;
    static int s_social_good_b = 90;
    static int s_social_good_c = 150;
    static int s_social_good_d = 210;

    static int s_social_excess_a = 180;
    static int s_social_excess_b = 300;
    static int s_social_excess_c = 1440;
    static int s_social_excess_d = 1440;

    static int s_others_accepted_a = 0;
    static int s_others_accepted_b = 0;
    static int s_others_accepted_c = 120;
    static int s_others_accepted_d = 180;

    static int s_others_excess_a = 120;
    static int s_others_excess_b = 180;
    static int s_others_excess_c = 1440;
    static int s_others_excess_d = 1440;

    static location place[] = new location[100];

    static int find_place(String find){
        int j;
        for(j = 0;j < 100;j++)
        {
            if((find).equals(place[j].name))
            {
                return j;
            }
        }
        return 0;

    }

    static double max_fn(double a,double b,double c,double d){
        return Math.max(Math.max(Math.max(a,b),c),d);
//
//        if(a>=b){
//            if(a>=c){
//                if(a>=d){
//                    return a;
//                }
//                else return d;
//            }
//            else{
//                if(c>=d){
//                    return c;
//                }
//                else return d;
//            }
//        }
//        else{
//            if(b>=c){
//                if(b>=d){
//                    return b;
//                }
//                else return d;
//            }
//            else{
//                if(c>=d){
//                    return c;
//                }
//                else return d;
//            }
//        }
    }

    public static JSONObject run(JSONObject in_json){
//        Scanner in = new Scanner(System.in);
//
//

        location place0 =  new location("null","null",0,1,0);place[0] = place0;
        location place1 =  new location("accounting","others",30,1,0);place[1] = place1;
        location place2 =  new location("airport","others",50,1,0);place[2] = place2;
        location place3 =  new location("amusement_park","social_leisure",100,0.3,0);place[3] = place3;
        location place4 =  new location("aquarium","leisure",40,1,0);place[4] = place4;
        location place5 =  new location("art_gallery","leisure",40,1,0);place[5] = place5;
        location place6 =  new location("atm","others",10,1,0);place[6] = place6;
        location place7 =  new location("bakery","others",15,1,0);place[7] = place7;
        location place8 =  new location("bank","work",30,1,0);place[8] = place8;
        location place9 =  new location("bar","social_leisure",60,0.6,0);place[9] = place9;
        location place10 =  new location("beauty_salon","leisure",20,1,0);place[10] = place10;
        location place11 =  new location("bicycle_store","others",50,1,0);place[11] = place11;
        location place12 =  new location("book_store","others",20,1,0);place[12] = place12;
        location place13 =  new location("bowling_alley","social",50,1,0);place[13] = place13;
        location place14 =  new location("bus_station","others",10,1,0);place[14] = place14;
        location place15 =  new location("cafe","social",60,1,0);place[15] = place15;
        location place16 =  new location("campground","social_leisure",80,0.7,0);place[16] = place16;
        location place17 =  new location("car_dealer","others",50,1,0);place[17] = place17;
        location place18 =  new location("car_rental","others",50,1,0);place[18] = place18;
        location place19 =  new location("car_repair","others",30,1,0);place[19] = place19;
        location place20 =  new location("car_wash","others",20,1,0);place[20] = place20;
        location place21 =  new location("casino","leisure",80,1,0);place[21] = place21;
        location place22 =  new location("cemetery","social",-100,1,0);place[22] = place22;
        location place23 =  new location("church","social_leisure",40,0.85,0);place[23] = place23;
        location place24 =  new location("city_hall","social",100,1,0);place[24] = place24;
        location place25 =  new location("clothing_store","leisure",40,1,0);place[25] = place25;
        location place26 =  new location("convenience_store","others",15,1,0);place[26] = place26;
        location place27 =  new location("courthouse","work_social",-70,0.4,0);place[27] = place27;
        location place28 =  new location("dentist","health",-30,1,0);place[28] = place28;
        location place29 =  new location("department_store","others",15,1,0);place[29] = place29;
        location place30 =  new location("doctor","health",-50,1,0);place[30] = place30;
        location place31 =  new location("electrician","others",40,1,0);place[31] = place31;
        location place32 =  new location("electronics_store","others",50,1,0);place[32] = place32;
        location place33 =  new location("embassy","others",100,1,0);place[33] = place33;
        location place34 =  new location("establishment","others",30,1,0);place[34] = place34;
        location place35 =  new location("finance","work",30,1,0);place[35] = place35;
        location place36 =  new location("fire_station","social",-50,1,0);place[36] = place36;
        location place37 =  new location("florist","social",10,1,0);place[37] = place37;
        location place38 =  new location("food","social",60,1,0);place[38] = place38;
        location place39 =  new location("funeral_home","social",-100,1,0);place[39] = place39;
        location place40 =  new location("furniture_store","leisure",30,1,0);place[40] = place40;
        location place41 =  new location("gas_station","others",10,1,0);place[41] = place41;
        location place42 =  new location("general_contractor ","others",30,1,0);place[42] = place42;
        location place43 =  new location("grocery_or_supermarket","others",15,1,0);place[43] = place43;
        location place44 =  new location("gym","health",100,1,0);place[44] = place44;
        location place45 =  new location("hair_care","leisure",20,1,0);place[45] = place45;
        location place46 =  new location("hardware_store","others",30,1,0);place[46] = place46;
        location place47 =  new location("health","health",90,1,0);place[47] = place47;
        location place48 =  new location("hindu_temple","social_leisure",40,0.85,0);place[48] = place48;
        location place49 =  new location("home_goods_store","leisure",40,1,0);place[49] = place49;
        location place50 =  new location("hospital","health",-100,1,0);place[50] = place50;
        location place51 =  new location("insurance_agency","work",20,1,0);place[51] = place51;
        location place52 =  new location("jewelry_store","leisure",40,1,0);place[52] = place52;
        location place53 =  new location("laundry","others",15,1,0);place[53] = place53;
        location place54 =  new location("lawyer","work_social",0.4,-40,0);place[54] = place54;
        location place55 =  new location("library","work",80,1,0);place[55] = place55;
        location place56 =  new location("liquor_store","others",25,1,0);place[56] = place56;
        location place57 =  new location("local_government_office","work",30,1,0);place[57] = place57;
        location place58 =  new location("locksmith","others",60,1,0);place[58] = place58;
        location place59 =  new location("lodging","social",50,1,0);place[59] = place59;
        location place60 =  new location("meal_delivery","leisure",25,1,0);place[60] = place60;
        location place61 =  new location("meal_takeaway","leisure",25,1,0);place[61] = place61;
        location place62 =  new location("mosque","social_leisure",40,0.85,0);place[62] = place62;
        location place63 =  new location("movie_rental","leisure",50,1,0);place[63] = place63;
        location place64 =  new location("movie_theater","leisure",70,1,0);place[64] = place64;
        location place65 =  new location("moving_company","others",50,1,0);place[65] = place65;
        location place66 =  new location("museum","leisure",40,1,0);place[66] = place66;
        location place67 =  new location("night_club","leisure",80,1,0);place[67] = place67;
        location place68 =  new location("painter","others",70,1,0);place[68] = place68;
        location place69 =  new location("park","social_health",65,0.3,0);place[69] = place69;
        location place70 =  new location("parking","others",10,1,0);place[70] = place70;
        location place71 =  new location("pet_store","leisure",10,1,0);place[71] = place71;
        location place72 =  new location("pharmacy","health",-10,1,0);place[72] = place72;
        location place73 =  new location("physiotherapist","health",-30,1,0);place[73] = place73;
        location place74 =  new location("place_of_worship","social_leisure",40,0.85,0);place[74] = place74;
        location place75 =  new location("plumber","others",40,1,0);place[75] = place75;
        location place76 =  new location("police","work_social",-100,0.25,0);place[76] = place76;
        location place77 =  new location("post_office","others",30,1,0);place[77] = place77;
        location place78 =  new location("real_estate_agency","others",40,1,0);place[78] = place78;
        location place79 =  new location("restaurant","social_leisure",60,0.7,0);place[79] = place79;
        location place80 =  new location("roofing_contractor","others",40,1,0);place[80] = place80;
        location place81 =  new location("rv_park","others",20,1,0);place[81] = place81;
        location place82 =  new location("school","work",70,1,0);place[82] = place82;
        location place83 =  new location("shoe_store","leisure",30,1,0);place[83] = place83;
        location place84 =  new location("shopping_mall","social_leisure",50,0.2,0);place[84] = place84;
        location place85 =  new location("spa","leisure",40,1,0);place[85] = place85;
        location place86 =  new location("stadium","health_leisure",0.4,60,0);place[86] = place86;
        location place87 =  new location("storage","others",30,1,0);place[87] = place87;
        location place88 =  new location("store","others",15,1,0);place[88] = place88;
        location place89 =  new location("subway_station","others",10,1,0);place[89] = place89;
        location place90 =  new location("synagogue","social",100,1,0);place[90] = place90;
        location place91 =  new location("taxi_stand","others",10,1,0);place[91] = place91;
        location place92 =  new location("train_station","others",10,1,0);place[92] = place92;
        location place93 =  new location("transit_station","others",10,1,0);place[93] = place93;
        location place94 =  new location("travel_agency","others",50,1,0);place[94] = place94;
        location place95 =  new location("university","work",70,1,0);place[95] = place95;
        location place96 =  new location("veterinary_care","others",70,1,0);place[96] = place96;
        location place97 =  new location("zoo","social_leisure",60,0.6,0);place[97] = place97;
        location place98 =  new location("home_bookmark","home",100,1,0);place[98] = place98;
        location place99 =  new location("work_bookmark","work",100,1,0);place[99] = place99;

		/*System.out.println("Enter your home,working,fitness,social and others minutes);
	scanf("%d%d%d%d%d",&s_home_input,&s_work_input,&s_fitness_input,&s_social_input,&s_others_input);*/

		/*System.out.println("home : ");
		s_home_input = input.nextInt();
		System.out.println("working : ");
		s_work_input = input.nextInt();
		System.out.println("fitness : ");
		s_fitness_input = input.nextInt();
		System.out.println("social : ");
		s_social_input = input.nextInt();
		System.out.println("others : ");
		s_others_input = input.nextInt();

		System.out.println("Membership values of you home lifestyle are" );
		System.out.println("Home hectic values are : " + members.slope(s_home_hectic_a,s_home_hectic_b,s_home_hectic_c,s_home_hectic_d,s_home_input));
		System.out.println("Home Ideal values are : " + members.slope(s_home_ideal_a,s_home_ideal_b,s_home_ideal_c,s_home_ideal_d,s_home_input) );
		System.out.println("Home Lazy Values are : " + members.slope(s_home_lazy_a,s_home_lazy_b,s_home_lazy_c,s_home_lazy_d,s_home_input));
		System.out.println("Home Very Lazy values are : " + members.slope(s_home_vlazy_a,s_home_vlazy_b,s_home_vlazy_c,s_home_vlazy_d,s_home_input));
		System.out.println("");

		System.out.println("Membership values of you work lifestyle are");
		System.out.println("Work less values are : " + members.slope(s_work_less_a,s_work_less_b,s_work_less_c,s_work_less_d,s_work_input));
		System.out.println("Work average values are : " + members.slope(s_work_avg_a,s_work_avg_b,s_work_avg_c,s_work_avg_d,s_work_input));
		System.out.println("Work good values are : " + members.slope(s_work_good_a,s_work_good_b,s_work_good_c,s_work_good_d,s_work_input) );
		System.out.println("work Hectic values are : " + members.slope(s_work_hectic_a,s_work_hectic_b,s_work_hectic_c,s_work_hectic_d,s_work_input));
		System.out.println("");

		System.out.println("Membership values of you fitness lifestyle are ");
		System.out.println("Fitness less values are : " + members.slope(s_fitness_less_a,s_fitness_less_b,s_fitness_less_c,s_fitness_less_d,s_fitness_input));
		System.out.println("Fitness good values are : " + members.slope(s_fitness_good_a,s_fitness_good_b,s_fitness_good_c,s_fitness_good_d,s_fitness_input));
		System.out.println("Fitness very good values are : " + members.slope(s_fitness_vgood_a,s_fitness_vgood_b,s_fitness_vgood_c,s_fitness_vgood_d,s_fitness_input) );
		System.out.println("Fitness excess values are : " + members.slope(s_fitness_excess_a,s_fitness_excess_b,s_fitness_excess_c,s_fitness_excess_d,s_fitness_input));
		System.out.println("");

		System.out.println("Membership values of you social lifestyle are");
		System.out.println("Social less values are : " + members.slope(s_social_less_a,s_social_less_b,s_social_less_c,s_social_less_d,s_social_input));
		System.out.println("Social good values are : " + members.slope(s_social_good_a,s_social_good_b,s_social_good_c,s_social_good_d,s_fitness_input));
		System.out.println("Social excess values are : " + members.slope(s_social_excess_a,s_social_excess_b,s_social_excess_c,s_social_excess_d,s_fitness_input));
		System.out.println("");

		System.out.println("Membership values of you wastage of your times are ");
		System.out.println("Wastage of your time other is fine : " + members.slope(s_others_accepted_a,s_others_accepted_b,s_others_accepted_c,s_others_accepted_d,s_others_input));
		System.out.println("Wastage of your time other is excess : " + members.slope(s_others_excess_a,s_others_excess_b,s_others_excess_c,s_others_excess_d,s_others_input));
		System.out.println("");

		for(int i=0;i<100;i++){
			System.out.println(place[i].name + place[i].type + place[i].score);
		}
		*/

        int j,k,t;
        //System.out.println("Enter the number of inputs.");
        j= in_json.length();
        //System.out.println("Enter the location and time spent.");
        long input[] = new long[100];
        for(int i=0;i<input.length; i++)
        {
            input[i] = 0;
        }
        String b;
        Iterator<String> iter = in_json.keys();
        while (iter.hasNext()) {
            String key = iter.next();
            k = find_place(key);
            try {
                input[k] =  input[k] + in_json.getLong(key);
            } catch (JSONException e) {
                e.printStackTrace();
                // Something went wrong!
            }
        }
//        for(int i = 0;i < j;i++)
//        {
//            b = in.nextLine();
//            t = Integer.parseInt(in.nextLine());
//            k = find_place(b);
//            input[k] = input[k]+t;
//        }
        double social_score = 0;double social_time = 0;double fuzzy_social_score = 0;
        double leisure_score = 0;double leisure_time = 0;double fuzzy_leisure_score = 0;
        double health_score = 0;double health_time = 0;double fuzzy_health_score = 0;
        double work_score = 0;double work_time = 0;double fuzzy_work_score = 0;
        double others_score = 0;double others_time = 0;double fuzzy_others_score = 0;

        double sleep_time = 436.25;
        double fuzzy_social_score_unit = 43.79;
        double negative_fuzzy_social_score_unit=-91.025;
        double fuzzy_leisure_score_unit = 51.872;
        double negative_fuzzy_leisure_score_unit = 0;
        double fuzzy_health_score_unit = 51.69;
        double negative_fuzzy_health_score_unit=-30.34;
        double fuzzy_work_score_unit = 63.01;
        double negative_fuzzy_work_score_unit = -24.1;
        double fuzzy_others_score_unit = 17.12;
        double negative_fuzzy_others_score_unit = 0;

        double work_efficiency ;

        for(int i=0 ; i < 100;i++)
        {
            if(input[i] != 0)
            {
                if(i != 98 && i!=99)
                {
                    if((place[i].type).equals("social"))
                    {
                        social_score += 1.0*input[i]*place[i].score;
                        social_time += input[i];
                        if(place[i].score > 0)
                        {
                            fuzzy_social_score += input[i]*fuzzy_social_score_unit;
                        }
                        else fuzzy_social_score += input[i]*negative_fuzzy_social_score_unit;
                        //System.out.println(social_score);
                    }
                    if((place[i].type).equals("work"))
                    {
                        work_score += 1.0*input[i]*place[i].score;
                        work_time += input[i];
                        if(place[i].score > 0)
                        {
                            fuzzy_work_score += input[i]*fuzzy_work_score_unit;
                        }
                        else fuzzy_work_score += input[i]*negative_fuzzy_work_score_unit;
                    }
                    if((place[i].type).equals("leisure"))
                    {
                        leisure_score += 1.0*input[i]*place[i].score;
                        leisure_time += input[i];
                        fuzzy_leisure_score += fuzzy_leisure_score_unit*input[i];
                    }
                    if((place[i].type).equals("health") )
                    {
                        health_score += 1.0*input[i]*place[i].score;
                        health_time += input[i];
                        if(place[i].score > 0)
                        {
                            fuzzy_health_score += input[i]*fuzzy_health_score_unit;
                        }
                        else fuzzy_health_score += input[i]*negative_fuzzy_health_score_unit;
                    }
                    if((place[i].type).equals("others"))
                    {
                        others_score += 1.0*input[i]*place[i].score;
                        others_time += input[i];
                        fuzzy_others_score += fuzzy_others_score_unit*input[i];
                    }
                    if((place[i].type).equals("social_leisure"))
                    {
                        social_score += 1.0*input[i]*place[i].score*place[i].ratio;
                        //System.out.println(social_score);
                        leisure_score += 1.0*input[i]*place[i].score*(1-place[i].ratio);
                        social_time += 1.0*input[i]*place[i].ratio;
                        leisure_time += 1.0*input[i]*(1-place[i].ratio);
                        if(place[i].score > 0)
                        {
                            fuzzy_social_score += input[i]*fuzzy_social_score_unit*place[i].ratio;
                            fuzzy_leisure_score += input[i]*fuzzy_leisure_score_unit*(1-place[i].ratio);
                        }
                        else
                        {
                            fuzzy_social_score += input[i]*negative_fuzzy_social_score_unit*place[i].ratio;
                            fuzzy_leisure_score += input[i]*negative_fuzzy_leisure_score_unit*(1-place[i].ratio);
                        }
                    }
                    if((place[i].type).equals("work_social"))
                    {
                        work_score += 1.0*input[i]*place[i].score*place[i].ratio;
                        social_score += 1.0*input[i]*place[i].score*(1-place[i].ratio);
                        //System.out.println(social_score);
                        work_time += 1.0*input[i]*place[i].ratio;
                        social_time += 1.0*input[i]*(1-place[i].ratio);
                        if(place[i].score > 0)
                        {
                            fuzzy_work_score += input[i]*fuzzy_work_score_unit*place[i].ratio;
                            fuzzy_social_score += input[i]*fuzzy_social_score_unit*(1-place[i].ratio);
                        }
                        else
                        {
                            fuzzy_work_score += input[i]*negative_fuzzy_work_score_unit*place[i].ratio;
                            fuzzy_social_score += input[i]*negative_fuzzy_social_score_unit*(1-place[i].ratio);
                        }
                    }
                    if((place[i].type).equals("social_health"))
                    {
                        social_score += 1.0*input[i]*place[i].score*place[i].ratio;
                        //System.out.println(social_score);
                        health_score += 1.0*input[i]*place[i].score*(1-place[i].ratio);
                        social_time += 1.0*input[i]*place[i].ratio;
                        health_time += 1.0*input[i]*(1-place[i].ratio);
                        if(place[i].score > 0)
                        {
                            fuzzy_social_score += input[i]*fuzzy_social_score_unit*place[i].ratio;
                            fuzzy_health_score += input[i]*fuzzy_health_score_unit*(1-place[i].ratio);
                        }
                        else
                        {
                            fuzzy_social_score += input[i]*negative_fuzzy_social_score_unit*place[i].ratio;
                            fuzzy_health_score += input[i]*negative_fuzzy_health_score_unit*(1-place[i].ratio);
                        }
                    }
                    if((place[i].type).equals("health_leisure"))
                    {
                        health_score += 1.0*input[i]*place[i].score*place[i].ratio;
                        leisure_score += 1.0*input[i]*place[i].score*(1-place[i].ratio);
                        health_time += 1.0*input[i]*place[i].ratio;
                        leisure_time += 1.0*input[i]*(1-place[i].ratio);
                        if(place[i].score > 0)
                        {
                            fuzzy_health_score += input[i]*fuzzy_health_score_unit*place[i].ratio;
                            fuzzy_leisure_score += input[i]*fuzzy_leisure_score_unit*(1-place[i].ratio);
                        }
                        else
                        {
                            fuzzy_health_score += input[i]*negative_fuzzy_health_score_unit*place[i].ratio;
                            fuzzy_leisure_score += input[i]*negative_fuzzy_leisure_score_unit*(1-place[i].ratio);
                        }
                    }
                }
                if(i == 98)
                {
                    if(input[i] >= sleep_time)
                    {
                        leisure_score += 0.558*(input[i]-sleep_time)*50;
                        leisure_score += 0.154*(input[i]-sleep_time)*65;
                        leisure_time += 1.0*(input[i]-sleep_time)*(0.558+0.154);
                        work_score += 0.154*(input[i]-sleep_time)*70;
                        work_time += 1.0*(input[i]-sleep_time)*0.154;
                        social_score += 0.077*(input[i]-sleep_time)*80;
                        //System.out.println(social_score);
                        social_time += 1.0*(input[i]-sleep_time)*0.077;
                        others_score += 0.058*(input[i]-sleep_time)*25;
                        others_time += 1.0*(input[i]-sleep_time)*0.058;
                        fuzzy_social_score += (input[i]-sleep_time)*fuzzy_social_score_unit*0.077;
                        fuzzy_work_score += (input[i]-sleep_time)*fuzzy_work_score_unit*0.154;
                        fuzzy_leisure_score += (input[i]-sleep_time)*fuzzy_leisure_score_unit*(0.558+0.154);
                        fuzzy_others_score += (input[i]-sleep_time)*fuzzy_others_score_unit*0.058;
                    }
                    else
                    {
                        //TODO see the threshold
                        //Tobe printed
                        //System.out.println("You are having less amount of rest.Suggestion : Spend atleast " + (sleep_time-input[i]) +" minutes more at home.");
                    }
                }
                if(i==99)
                {
                    work_efficiency = 1;
                    work_score += work_efficiency*input[i]*100;
                    others_score += (1-work_efficiency)*input[i]*100;
                    work_time += 1.0*input[i]*work_efficiency;
                    others_time += 1.0*input[i]*(1-work_efficiency);
                }
            }
        }

        social_score = social_score / (1440-sleep_time) ;
        work_score = work_score / (1440-sleep_time) ;
        leisure_score = leisure_score / (1440-sleep_time) ;
        health_score = health_score / (1440-sleep_time) ;
        others_score = others_score / (1440-sleep_time) ;

        fuzzy_social_score = fuzzy_social_score / (1440-sleep_time) ;
        fuzzy_work_score = fuzzy_work_score / (1440-sleep_time) ;
        fuzzy_leisure_score = fuzzy_leisure_score / (1440-sleep_time) ;
        fuzzy_health_score = fuzzy_health_score / (1440-sleep_time) ;
        fuzzy_others_score = fuzzy_others_score / (1440-sleep_time) ;

        JSONObject out_json = new JSONObject();
        //out_json.put()
        String TAG = "ssoft";
        Log.e(TAG, "Social score : "+ social_score +" \t Social Time : "+social_time);
        Log.e(TAG, "Work score : " + work_score + " \t Work Time : " + work_time);
        Log.e(TAG, "Leisure score : " + leisure_score + " \t Leisure Time : " + leisure_time);
        Log.e(TAG, "Health score : " + health_score + " \t Health Time : " + health_time);
        Log.e(TAG, "Others score : " + others_score + " \t Others Time : " + others_time);


            double leisure_hectic = members.slope(s_home_hectic_a, s_home_hectic_b, s_home_hectic_c, s_home_hectic_d, leisure_time + sleep_time);
            double leisure_ideal = members.slope(s_home_ideal_a, s_home_ideal_b, s_home_ideal_c, s_home_ideal_d, leisure_time + sleep_time);
            double leisure_lazy = members.slope(s_home_lazy_a, s_home_lazy_b, s_home_lazy_c, s_home_lazy_d, leisure_time + sleep_time);
            double leisure_vlazy = members.slope(s_home_vlazy_a, s_home_vlazy_b, s_home_vlazy_c, s_home_vlazy_d, leisure_time + sleep_time);

            double work_less = members.slope(s_work_less_a, s_work_less_b, s_work_less_c, s_work_less_d, work_time);
            double work_avg = members.slope(s_work_avg_a, s_work_avg_b, s_work_avg_c, s_work_avg_d, work_time);
            double work_good = members.slope(s_work_good_a, s_work_good_b, s_work_good_c, s_work_good_d, work_time);
            double work_hectic = members.slope(s_work_hectic_a, s_work_hectic_b, s_work_hectic_c, s_work_hectic_d, work_time);

            double fitness_less = members.slope(s_fitness_less_a, s_fitness_less_b, s_fitness_less_c, s_fitness_less_d, health_time);
            double fitness_good = members.slope(s_fitness_good_a, s_fitness_good_b, s_fitness_good_c, s_fitness_good_d, health_time);
            double fitness_vgood = members.slope(s_fitness_vgood_a, s_fitness_vgood_b, s_fitness_vgood_c, s_fitness_vgood_d, health_time);
            double fitness_excess = members.slope(s_fitness_excess_a, s_fitness_excess_b, s_fitness_excess_c, s_fitness_excess_d, health_time);

            double social_less = members.slope(s_social_less_a, s_social_less_b, s_social_less_c, s_social_less_d, social_time);
            double social_good = members.slope(s_social_good_a, s_social_good_b, s_social_good_c, s_social_good_d, social_time);
            double social_excess = members.slope(s_social_excess_a, s_social_excess_b, s_social_excess_c, s_social_excess_d, social_time);

            double others_acceptable = members.slope(s_others_accepted_a, s_others_accepted_b, s_others_accepted_c, s_others_accepted_d, others_time);
            double others_excess = members.slope(s_others_excess_a, s_others_excess_b, s_others_excess_c, s_others_excess_d, others_time);

            String leisure_string1 = "";
            String leisure_string2 = "";
            String social_string1 = "";
            String social_string2 = "";
            String work_string1 = "";
            String work_string2 = "";
            String health_string1 = "";
            String health_string2 = "";
            String others_string1 = "";
            String others_string2 = "";
            double EPS = 0.01;
            double leisure_max = Math.max(Math.max(Math.max(leisure_hectic, leisure_ideal), leisure_lazy), leisure_vlazy);
//            try {
                if (leisure_score < 0.9 * fuzzy_leisure_score) {
                    if (Math.abs(leisure_max - leisure_hectic) < EPS) {
                        leisure_string1 = "Catch a movie streaming on TV this evening.";
                        leisure_string2 = "Fuzzy Leisure Status : Hectic";
                    } else if (Math.abs(leisure_max - leisure_ideal) < EPS) {
                        leisure_string1 = "Catch a movie streaming on TV this evening.";
                        leisure_string2 = "Fuzzy Leisure Status : Ideal";
                    } else if (Math.abs(leisure_max - leisure_lazy) < EPS) {
                        leisure_string1 = "Time to go to the beach.";
                        leisure_string2 = "Fuzzy Leisure Status : Lazy";
                    } else if (Math.abs(leisure_max - leisure_vlazy) < EPS) {
                        leisure_string1 = "Time to go to the beach.";
                        leisure_string2 = "Fuzzy Leisure Status : Very Lazy";
                    }
                } else if (leisure_score > 1.1 * fuzzy_leisure_score) {
                    if (Math.abs(leisure_max - leisure_hectic)  < EPS) {
                        leisure_string1 = "Aliens are out there to kill you.Pray with family at home.";
                        leisure_string2 = "Fuzzy Leisure Status : Hectic";
                    } else if (Math.abs(leisure_max - leisure_ideal) < EPS) {
                        leisure_string1 = "When was the last time you played board games?";
                        leisure_string2 = "Fuzzy Leisure Status : Ideal";
                    } else if (Math.abs(leisure_max - leisure_lazy)  < EPS){
                        leisure_string1 = "Household work can't kill you but why take a chance ?";
                        leisure_string2 = "Fuzzy Leisure Status : Lazy";
                    } else if (Math.abs(leisure_max - leisure_vlazy)  < EPS){
                        leisure_string1 = "Household work can't kill you but why take a chance ?";
                        leisure_string2 = "Fuzzy Leisure Status : Very Lazy";
                    }
                } else {
                    if (Math.abs(leisure_max - leisure_hectic)  < EPS){
                        leisure_string1 = "Have some rest at home buddy.";
                        leisure_string2 = "Fuzzy Leisure Status : Hectic";
                    } else if (Math.abs(leisure_max - leisure_ideal)  < EPS){
                        leisure_string1 = "Going perfect.I must learn from you.";
                        leisure_string2 = "Fuzzy Leisure Status : Ideal";
                    } else if (Math.abs(leisure_max - leisure_lazy)  < EPS){
                        leisure_string1 = "Household work can't kill you but why take a chance ?";
                        leisure_string2 = "Fuzzy Leisure Status : Lazy";
                    } else if (Math.abs(leisure_max - leisure_vlazy)  < EPS){
                        leisure_string1 = "Household work can't kill you but why take a chance ?";
                        leisure_string2 = "Fuzzy Leisure Status : Hectic";
                    }
                }
                Log.e(TAG + " social score", Double.toString(social_score) + Double.toString(fuzzy_social_score));
                Log.e(TAG, "DOUBLE SCORE " + Double.toString(social_less) + " " + Double.toString(social_good) + " " + Double.toString(social_excess) );
                double social_max = Math.max(Math.max(social_less, social_good), social_excess);
                if (social_score < 0.9 * fuzzy_social_score) {

                    if (Math.abs(social_max - social_less) < EPS) {
                        social_string1 = "Throw a party.";
                        social_string2 = "Fuzzy Social Status: Less";
                    } else if (Math.abs(social_max - social_good) < EPS) {
                        social_string1 = "Crash a wedding.";
                        social_string2 = "Fuzzy Social Status: Good";
                    } else if (Math.abs(social_max - social_excess) < EPS) {
                        social_string1 = "Crash a wedding.";
                        social_string2 = "Fuzzy Social Status: Excess";
                    }
                } else if (social_score > 1.1 * fuzzy_social_score) {
                    if (Math.abs(social_max - social_less) < EPS) {
                        social_string1 = "Visit a distinct friend.";
                        social_string2 = "Fuzzy Social Status: Less";
                    } else if (Math.abs(social_max - social_good) < EPS) {
                        social_string1 = "When was the last time you went roaming with your friends?";
                        social_string2 = "Fuzzy Social Status: Good";
                    } else if (Math.abs(social_max - social_excess) < EPS) {
                        social_string1 = "Time Flies.Friends don't.";
                        social_string2 = "Fuzzy Social Status: Excess";
                    }
                } else {
                    if (Math.abs(social_max - social_less) < EPS) {
                        social_string1 = "Have a coffee with a friend.";
                        social_string2 = "Fuzzy Social Status: Less";
                    } else if (Math.abs(social_max - social_good) < EPS) {
                        social_string1 = "Your social life was made in heaven.";
                        social_string2 = "Fuzzy Social Status: Good";
                    } else if (Math.abs(social_max - social_excess) < EPS) {
                        social_string1 = "Time Flies.Friends don't.";
                        social_string2 = "Fuzzy Social Status: Excess";
                    }
                }
                double work_max = Math.max(Math.max(Math.max(work_avg, work_good), work_less), work_hectic);
                if (work_score < 0.9 * fuzzy_work_score) {
                    if (Math.abs(work_max- work_less) < EPS) {
                        work_string1 = "Work or get fired.";
                        work_string2 = "Fuzzy Work Status: Less";
                    } else if (Math.abs(work_max - work_avg) < EPS) {
                        work_string1 = "Work or get fired.";
                        work_string2 = "Fuzzy Work Status: Average";
                    } else if (Math.abs(work_max - work_good) < EPS) {
                        work_string1 = "A productive employee is what a boss always like.";
                        work_string2 = "Fuzzy Work Status: Good";
                    } else if (Math.abs(work_max - work_hectic) < EPS) {
                        work_string1 = "A productive employee is what a boss always like.";
                        work_string2 = "Fuzzy Work Status: Hectic";
                    }
                } else if (work_score > 1.1 * fuzzy_work_score) {
                    if (Math.abs(work_max - work_less) < EPS) {
                        work_string1 = "Office is there to kill some time.";
                        work_string2 = "Fuzzy Work Status: Less";
                    } else if (Math.abs(work_max - work_avg) < EPS) {
                        work_string1 = "Office is there to kill some time.";
                        work_string2 = "Fuzzy Work Status: Average";
                    } else if (Math.abs(work_max - work_good) < EPS) {
                        work_string1 = "Its your time soon to climb up the ladder.";
                        work_string2 = "Fuzzy Work Status: Good";
                    } else if (Math.abs(work_max - work_hectic) < EPS) {
                        work_string1 = "Its your time soon to climb up the ladder.";
                        work_string2 = "Fuzzy Work Status: Hectic";
                    }
                } else {
                    if (Math.abs(work_max - work_less)  < EPS){
                        work_string1 = "Office is there to kill some time.";
                        work_string2 = "Fuzzy Work Status: Less";
                    } else if (Math.abs(work_max - work_avg) < EPS) {
                        work_string1 = "Office is there to kill some time.";
                        work_string2 = "Fuzzy Work Status: Average";
                    } else if (Math.abs(work_max - work_good) < EPS) {
                        work_string1 = "In office beat the clock.";
                        work_string2 = "Fuzzy Work Status: Good";
                    } else if (Math.abs(work_max - work_hectic) < EPS) {
                        work_string1 = "In office beat the time.";
                        work_string2 = "Fuzzy Work Status: Hectic";
                    }
                }
                double health_max = Math.max(Math.max(Math.max(fitness_excess, fitness_good), fitness_less), fitness_vgood);
                if (health_score < 0.9 * fuzzy_health_score) {
                    if (Math.abs(health_max - fitness_less) < EPS) {
                        health_string1 = "Its time to hit the gym.";
                        health_string2 = "Fuzzy Health Status: Less";
                    } else if (Math.abs(health_max - fitness_good) < EPS) {
                        health_string1 = "Pull up the mass.Maximum effort.";
                        health_string2 = "Fuzzy Health Status: Good";
                    } else if (Math.abs(health_max - fitness_vgood) < EPS) {
                        health_string1 = "Lets get back in shape.";
                        health_string2 = "Fuzzy Health Status: Very Good";
                    } else if (Math.abs(health_max - fitness_excess) < EPS) {
                        health_string1 = "Lets get back in shape.";
                        health_string2 = "Fuzzy Health Status: Excess";
                    }
                } else if (health_score > 1.1 * fuzzy_health_score) {
                    if (Math.abs(health_max - fitness_less) < EPS) {
                        health_string1 = "Exercise + Rest = Perfect Combo.";
                        health_string2 = "Fuzzy Health Status: Less";
                    } else if (Math.abs(health_max - fitness_good) < EPS) {
                        health_string1 = "Leaner.Fitter.Stronger.";
                        health_string2 = "Fuzzy Health Status: Good";
                    } else if (Math.abs(health_max - fitness_vgood) < EPS) {
                        health_string1 = "Leaner.Fitter.Stronger.";
                        health_string2 = "Fuzzy Health Status: Very Good";
                    } else if (Math.abs(health_max - fitness_excess) < EPS) {
                        health_string1 = "Leaner.Fitter.Stronger.";
                        health_string2 = "Fuzzy Health Status: Excess";
                    }
                } else {
                    if (Math.abs(health_max - fitness_less) < EPS) {
                        health_string1 = "Exercise + Rest = Perfect Combo.";
                        health_string2 = "Fuzzy Health Status: Less";
                    } else if (Math.abs(health_max - fitness_good) < EPS) {
                        health_string1 = "I must certainly learn from you.";
                        health_string2 = "Fuzzy Health Status: Good";
                    } else if (Math.abs(health_max - fitness_vgood) < EPS) {
                        health_string1 = "Be consistent.Be strong.";
                        health_string2 = "Fuzzy Health Status: Very Good";
                    } else if (Math.abs(health_max - fitness_excess) < EPS) {
                        health_string1 = "Be consistent.Be strong.";
                        health_string2 = "Fuzzy Health Status: Excess";
                    }
                }
                double others_max = Math.max(others_acceptable, others_excess);
                if (others_score < 0.9 * fuzzy_others_score) {
                    if (Math.abs(others_max -  others_acceptable) < EPS) {
                        others_string1 = "Time not wasted is time earned.";
                        others_string1 = "Fuzzy Others Status: Acceptable";
                    } else if (Math.abs(others_max -  others_excess) < EPS) {
                        others_string1 = "Success Mantra = Less time + More work.";
                        others_string1 = "Fuzzy Health Status: Excess";
                    }
                } else if (others_score > 1.1 * fuzzy_others_score) {
                    if (Math.abs(others_max -  others_acceptable) < EPS) {
                        others_string1 = "Your time is limited.Don't waste it.-Steve Jobs";
                        others_string1 = "Fuzzy Health Status: Acceptable";
                    } else if (Math.abs(others_max -  others_excess) < EPS) {
                        others_string1 = "Your time is limited.Don't waste it.-Steve Jobs";
                        others_string1 = "Fuzzy Health Status: Excess";
                    }
                } else {
                    if (Math.abs(others_max -  others_acceptable) < EPS) {
                        others_string1 = "Time not wasted is time earned.";
                        others_string1 = "Fuzzy Health Status: Acceptable";
                    } else if (Math.abs(others_max -   others_excess) < EPS) {
                        others_string1 = "Success Mantra = Less time + More work.";
                        others_string1 = "Fuzzy Health Status: Excess";
                    }
                }

                try {
                    out_json.put("social_score", social_score);
                    out_json.put("work_score", work_score);
                    out_json.put("leisure_score", leisure_score);
                    out_json.put("health_score", health_score);
                    out_json.put("others_score", others_score);

                    out_json.put("social_time", social_time);
                    out_json.put("work_time", work_time);
                    out_json.put("leisure_time", leisure_time);
                    out_json.put("health_time", health_time);
                    out_json.put("others_time", others_time);

                    out_json.put("social_str", social_string1 + "\n" + social_string2);
                    out_json.put("work_str", work_string1 + "\n" + work_string2);
                    out_json.put("leisure_str", leisure_string1 + "\n" + leisure_string2);
                    out_json.put("health_str", health_string1 + "\n" + health_string2);
                    out_json.put("others_str", others_string1 + "\n" + others_string2);
//
//
                } catch (Exception e) {
                    e.printStackTrace();
                }
        Log.e(TAG, health_string1);
        Log.e(TAG, social_string1);
        Log.e(TAG, leisure_string1);
        Log.e(TAG, work_string1);
        Log.e(TAG, others_string1);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        Log.e(TAG, work_string1 + work_string2);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
        return out_json;
        
    }
}