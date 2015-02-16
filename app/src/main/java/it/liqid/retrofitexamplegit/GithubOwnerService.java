package it.liqid.retrofitexamplegit;

import java.util.List;

import retrofit.Callback;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by niccolo on 13/02/15.
 */
public interface GithubOwnerService {

    //@FormUrlEncoded //mi assicuro che sia usato l'encoding giusto ma funziona solo con @POST
    @GET("/users/{user}/repos")
    void ownerInfo(@Path("user") String user, Callback<List<Owner>> callback);

}
