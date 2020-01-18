package org.humingk.movie.server.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author humingk
 */
@RestController
public class UserController {
    @GetMapping("/info")
    public String userInfo() {
        return "movie-server-user";
    }
}
