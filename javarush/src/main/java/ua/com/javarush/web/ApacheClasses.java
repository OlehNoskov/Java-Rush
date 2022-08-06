package ua.com.javarush.web;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import java.util.List;


public class ApacheClasses {
    public static void main(String[] args) throws Exception {
        ApacheClasses solution = new ApacheClasses();
        solution.sendPost("https://requestbin.jumio.com/1hzk82w1", "name=zapp&mood=good&locale=&id=777");
    }

    public void sendPost(String url, String urlParameters) throws Exception {
        HttpClient client = getHttpClient();
        HttpPost request = new HttpPost(url);

        request.addHeader("User-Agent", "Mozilla/5.0");

        List<NameValuePair> listUrlParameters = URLEncodedUtils.parse(urlParameters, StandardCharsets.UTF_8);
        request.setEntity(new UrlEncodedFormEntity(listUrlParameters));

        HttpPost post = new HttpPost(url);
        post.setEntity(new StringEntity(urlParameters));

        HttpResponse response = client.execute(request);

        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String responseLine;
        while ((responseLine = bufferedReader.readLine()) != null) {
            result.append(responseLine);
        }

        System.out.println("Response: " + result);
    }

    protected HttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }
}