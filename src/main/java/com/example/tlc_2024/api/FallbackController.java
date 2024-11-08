package com.example.tlc_2024.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FallbackController {

    /**
     * This method will forward all non-API requests to the React app's index.html
     * located in the static folder, so React Router can handle routing.
     */
    @RequestMapping("/{path:[^\\.]*}")
    public String forwardToReactApp() {
        return "forward:/index.html";  // Serve index.html from static folder
    }
}
