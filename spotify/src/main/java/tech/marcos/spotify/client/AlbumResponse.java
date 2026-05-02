package tech.marcos.spotify.client;

import java.util.List;

public class AlbumResponse {

    private Albums albums;

    public Albums getAlbums() {
        return albums;
    }

    public static class Albums {
        private List<Album> items;

        public List<Album> getItems() {
            return items;
        }
    }
}