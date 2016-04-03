package pl.edu.wat.usos.usosapp;

import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.OAuth1RequestToken;

/**
 * Created by Rafal on 2016-04-03.
 */
public class UsosAPI extends DefaultApi10a {

    private static final String AUTHORIZE_URL = "https://usosapps.wat.edu.pl/services/oauth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_RESOURCE = "usosapps.wat.edu.pl/services/oauth/request_token";
    private static final String ACCESS_TOKEN_RESOURCE = "https://usosapps.wat.edu.pl/services/oauth/access_token";

    protected UsosAPI() {
    }

    private static class InstanceHolder {
        private static final UsosAPI INSTANCE = new UsosAPI();
    }

    public static UsosAPI instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://" + ACCESS_TOKEN_RESOURCE;
    }

    @Override
    public String getRequestTokenEndpoint() {
        return "https://" + REQUEST_TOKEN_RESOURCE;
    }

    @Override
    public String getAuthorizationUrl(OAuth1RequestToken requestToken) {
        return String.format(AUTHORIZE_URL, requestToken.getToken());
    }
}
