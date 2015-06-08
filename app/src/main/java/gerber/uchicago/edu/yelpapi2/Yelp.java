package gerber.uchicago.edu.yelpapi2;

import gerber.uchicago.edu.YelpResultsData;
import com.google.gson.Gson;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/**
 * Created by yiqin on 5/31/15.
 */
//see instructions for the classes you need here: http://stackoverflow.com/questions/6676733/yelp-integration-in-android
/**
 * Example for accessing the Yelp API.
 */
public class Yelp {

    //these are my developers keys, please get your own by going to: http://www.yelp.com/developers/getting_started/api_access
    private static final String CONSUMER_KEY = "P4OLddR4ErelBW1KKeSIaQ";
    private static final String CONSUMER_SECRET = "gX7EvDGX5OK_5O8QEt_LabNB6WE";
    private static final String TOKEN = "BTVYw5QzgcQSRX9YfWPfRzbHn_lGIU8L";
    private static final String TOKEN_SECRET = "tZyBbp_AhnyOjYJEjUZ6QquCaIg";

    OAuthService service;
    Token accessToken;

//        /**
//         * Setup the Yelp API OAuth credentials.
//         *
//         * OAuth credentials are available from the developer site, under Manage API access (version 2 API).
//         *
//         * @param consumerKey Consumer key
//         * @param consumerSecret Consumer secret
//         * @param token Token
//         * @param tokenSecret Token secret
//         */
//        public Yelp(String consumerKey, String consumerSecret, String token, String tokenSecret) {
//            this.service = new ServiceBuilder().provider(YelpApi2.class).apiKey(consumerKey).apiSecret(consumerSecret).build();
//            this.accessToken = new Token(token, tokenSecret);
//        }

    public Yelp(){
        this.service = new ServiceBuilder().provider(YelpApi2.class).apiKey(CONSUMER_KEY).apiSecret(CONSUMER_SECRET).build();
        this.accessToken = new Token(TOKEN, TOKEN_SECRET);
    }


    public YelpResultsData searchMultiple(String searchTerm, String city) {

        // Execute a signed call to the Yelp service.
        OAuthService service = new ServiceBuilder().provider(YelpApi2.class).apiKey(CONSUMER_KEY).apiSecret(CONSUMER_SECRET).build();
        Token accessToken = new Token(TOKEN, TOKEN_SECRET);
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");

        request.addQuerystringParameter("location", city);
        //TODO: set category here.
        request.addQuerystringParameter("category", "restaurants");
        request.addQuerystringParameter("term", searchTerm);
        request.addQuerystringParameter("limit", "20");

        service.signRequest(accessToken, request);
        Response response = request.send();
        String rawData = response.getBody();

        YelpResultsData mYelpSearchResult = null;

        try {
            mYelpSearchResult = new Gson().fromJson(rawData, YelpResultsData.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mYelpSearchResult;
    }

}



