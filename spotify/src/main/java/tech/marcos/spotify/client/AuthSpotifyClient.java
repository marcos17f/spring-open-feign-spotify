package tech.marcos.spotify.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authSpotifyClient", url = "https://accounts.spotify.com")
public interface AuthSpotifyClient {

    @PostMapping(value = "/api/token", consumes = "application/x-www-form-urlencoded")
    TokenResponse login(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody MultiValueMap<String, String> body
    );
}