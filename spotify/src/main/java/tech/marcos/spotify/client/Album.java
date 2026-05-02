package tech.marcos.spotify.client;

import java.util.List;

public class Album {

    private String name;
    private List<Artist> artists;

    public String getName() {
        return name;
    }

    public List<Artist> getArtists() {
        return artists;
    }
}