package pl.edu.wat.usos.usosapp;

import android.content.Context;
import android.os.AsyncTask;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;

/**
 * Created by Rafal on 2016-04-03.
 */
public class LoginTask extends AsyncTask<Void, Void, String> {


    public LoginTask(Context context) {

    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            OAuth10aService service = new ServiceBuilder()
                    .apiKey("9G6AR9WpNXz3uR2QmAFY")
                    .apiSecret("Wju2N3pm9bSf6MERYydEY5RcNJn6wWeXfpNj5JaE")
                    .build(UsosAPI.instance());
            final OAuth1RequestToken requestToken = service.getRequestToken();
            String authUrl = service.getAuthorizationUrl(requestToken);
            return authUrl;
        } catch (Exception ignore) {
        }
        return null;
    }
}
