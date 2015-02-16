package it.liqid.retrofitexamplegit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestClient restClient = new RestClient();


        restClient.getGithubOwnerService().ownerInfo("nicopasso", new Callback<List<Owner>>() {


            @Override
            public void success(List<Owner> owners, Response response) {

                for (Owner owner : owners) {
                    Log.e("OWNER NAME", owner.usernameOwner);
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

    /*public interface GithubService {

        @FormUrlEncoded //mi assicuro che sia usato l'encoding giusto
        @GET("/users/{user}/repos")
        void listRepos(@Path("user") String user, Callback<List<Repo>> callback);
    }*/
}
