package com.dantorrey.httpdump.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebRequestController {

    // Accept all web requests, and print the details to a file.
    @RequestMapping("/**")
    public ResponseEntity<String> allRequests(HttpServletRequest request) {

        return ResponseEntity.ok("All good!");
    }
}
