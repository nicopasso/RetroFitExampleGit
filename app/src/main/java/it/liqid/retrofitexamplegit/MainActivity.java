package it.liqid.retrofitexamplegit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        GithubService service = restAdapter.create(GithubService.class);

        service.listRepos("nicopasso", new Callback<List<Repo>>() {
            @Override
            public void success(List<Repo> repos, Response response) {

                //For sull'elenco dei Repo
                 for (Repo repo : repos) {
                     Log.e("REPO NAME AND URL", repo.name + " " + repo.url);
                 }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public interface GithubService {
        @GET("/users/{user}/repos")
        void listRepos(@Path("user") String user, Callback<List<Repo>> callback);
    }
}
