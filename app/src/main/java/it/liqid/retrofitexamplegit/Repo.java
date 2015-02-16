package it.liqid.retrofitexamplegit;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by niccolo on 12/02/15.
 */
@Parcel
public class Repo {

    public Repo() {

    }

    //Con l'annotation @SerializedName posso usare internamente i nomi che voglio delle variabili e associarli ai nomi che hanno nel JSON

    public Integer id;

    //Ad esempio con questa annotations dico a RetroFit (o meglio alla libreria Gson che viene usata)
    //che il nome della variabile nel JSON è "name" e voglio che venga salvata in repoName
    @SerializedName("name")
    public String repoName;

    public String html_url;
    public boolean fork;
    public String url;
    public String forks_url;
    public String keys_url;
    public String created_at;
    public String updated_at;
    public String pushed_at;

}
