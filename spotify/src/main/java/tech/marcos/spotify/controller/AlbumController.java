package tech.marcos.spotify.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import tech.marcos.spotify.client.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/spotify/api")
public class AlbumController {

    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumSpotifyClient albumSpotifyClient;

    public AlbumController(AuthSpotifyClient authSpotifyClient,
                           AlbumSpotifyClient albumSpotifyClient) {
        this.authSpotifyClient = authSpotifyClient;
        this.albumSpotifyClient = albumSpotifyClient;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAlbums() {

        String clientId = "";
        String clientSecret = "";

        // gerar base64
        String credentials = clientId + ":" + clientSecret;
        String base64 = Base64.getEncoder().encodeToString(credentials.getBytes());
        String authHeader = "Basic " + base64;

        // body
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        // pegar token
        TokenResponse tokenResponse = authSpotifyClient.login(authHeader, body);
        String token = tokenResponse.getAccessToken();

        // 🔥 chamada que FUNCIONA
        Album album = albumSpotifyClient.getAlbum(
                "Bearer " + token,
                "4aawyAB9vmqN3uQ7FjRGTy" // álbum de teste
        );

        return ResponseEntity.ok(List.of(album));
    }
}