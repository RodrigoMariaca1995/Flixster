package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class Movie {

    int movieId;
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;

    //empty constructor needed by the Parceler library
    public Movie(){}

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path"); //gets string "backdrop_path" from movie API and assigns it to backdropPath
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException { //creates a list of movies from the array of movies in the API
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i < movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() { //image loading library is used because returning posterPath would return the link in the API rather than the image.
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }
    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating(){return rating;}

    public int getMovieId() {
        return movieId;
    }
}
