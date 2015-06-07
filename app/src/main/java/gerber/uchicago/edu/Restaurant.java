package gerber.uchicago.edu;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Adam Gerber on 5/19/2014.
 * University of Chicago
 */
public class Restaurant implements Serializable {

    private long mId;
    private int mFavorite;
    private String mName;
    private String mCity;
    private String mAddress;
    private String mPhone;
    private String mYelp;
    private String mImageUrl;
    // TODO: add time stamp
    private String mUpdateTime;


    public Restaurant(long id, int favorite, String name, String city, String address, String phone, String yelp, String imageUrl) {
        mId = id;
        mFavorite = favorite;
        mName = name;
        mCity = city;
        mAddress = address;
        mPhone = phone;
        mYelp = yelp;
        mImageUrl = imageUrl;

        mUpdateTime = getCurrentTimeStamp();
    }

    public Restaurant(int favorite, String name, String city, String address, String phone, String yelp, String imageUrl) {
        mFavorite = favorite;
        mName = name;
        mCity = city;
        mAddress = address;
        mPhone = phone;
        mYelp = yelp;
        mImageUrl = imageUrl;

        mUpdateTime = getCurrentTimeStamp();
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getYelp() {
        return mYelp;
    }

    public void setYelp(String yelp) {
        mYelp = yelp;
    }

    public int getFavorite() {
        return mFavorite;
    }

    public void setFavorite(int favorite) {
        mFavorite = favorite;
    }

    public void setUpdateTime(){
        mUpdateTime = getCurrentTimeStamp();
    }

    public String getUpdateTime(){
        return mUpdateTime;
    }


    /**
     *
     * @return yyyy-MM-dd HH:mm:ss formate date as string
     */
    public static String getCurrentTimeStamp(){
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTimeStamp = dateFormat.format(new Date()); // Find todays date

            return currentTimeStamp;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
