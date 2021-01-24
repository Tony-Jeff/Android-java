package com.tonyjimaria.lerjson;

import android.os.AsyncTask;
import com.tonyjimaria.lerjson.model.bean.Cliente;
import com.tonyjimaria.lerjson.model.bean.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LoadJSONTask extends AsyncTask<String, Void, Response> {

    private Listener mListener;
    public LoadJSONTask(Listener listener) {
        mListener = listener;
    }

    public interface Listener{
        void onLoaded(List<Cliente> clienteList);
        void onError();
    }

    @Override
    protected Response doInBackground(String... strings) {
        return null;
    }

    private String loadJSON(String jsonURL) throws IOException {

        URL url = new URL(jsonURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = in.readLine()) != null) ;
        {
            response.append(line);

        }
        in.close();
        return response.toString();
    }
}
