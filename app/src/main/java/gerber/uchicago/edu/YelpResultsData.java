package gerber.uchicago.edu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yiqin on 5/31/15.
 */
// See an example or raw json results here: http://www.yelp.com/developers/documentation/v2/search_api#rValue
//copy and paste into here: //http://jsonviewer.stack.hu/  to see the structure
public class YelpResultsData {

    public List<Business> businesses;
    public class Business {

        public String name;
        public String url;
        public String phone;
        public Location location;
        public String rating_img_url;

        //TODO: adding categories, we cna get two categories. We need to fetch some. Minor category to th main category.
        public List<List<String>> categoreis;


        public class Location {
            public List<String> address;

        }
    }

    public ArrayList<String> getSimpleValues() {
        ArrayList<String> simpleValues = new ArrayList<String>();


        for (Business biz : businesses) {
            try {
                simpleValues.add(biz.name + " | " + biz.location.address.get(0) + " | " + getStars(biz.rating_img_url));
            } catch (Exception e) {
                //will continue on its own
            }
        }

        return simpleValues;
    }


    //TODO: we don't need this in the project now.
    private String getStars(String strUrl){

        int nHalfCode = Integer.parseInt("00BD", 16);
        char[] cChars = Character.toChars(nHalfCode);
        String strHalf = String.valueOf(cChars);


        //try the most specific conditions first
        if(strUrl.contains("stars_4_half")){
            return "****" + strHalf;
        } else if (strUrl.contains("stars_3_half")){
            return "***" + strHalf;
        } else if (strUrl.contains("stars_2_half")){
            return "**" + strHalf;
        } else if (strUrl.contains("stars_1_half")){
            return "*" + strHalf;
        }else if (strUrl.contains("stars_5")){
            return "*****" ;
        }else if (strUrl.contains("stars_4")){
            return "****" ;
        }else if (strUrl.contains("stars_3")){
            return "***" ;
        }else if (strUrl.contains("stars_2")){
            return "**" ;
        }else if (strUrl.contains("stars_1")){
            return "*" ;
        }else {
            return "";
        }
    }


}


