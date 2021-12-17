package com.xichong.onedriveshare.controller;

import com.xichong.onedriveshare.graphtutorial.Graph;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class Index {
    @Value("${app.id}")
    private String id;
    @Value("${app.scopes}")
    private String scopes;

    @GetMapping("/")
    public String index(Model model) {
        Graph.initializeGraphAuth(id, Arrays.asList(scopes.split(",")));
        final String accessToken = Graph.getUserAccessToken();
        System.out.println("Access token: " + accessToken);
        model.addAttribute("accessToken", accessToken);
        return "index";
    }
}
