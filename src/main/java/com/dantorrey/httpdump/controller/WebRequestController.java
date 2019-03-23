package com.dantorrey.httpdump.controller;

import com.dantorrey.httpdump.value.RequestDetails;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;

@Controller
public class WebRequestController {

    // Accept all web requests, and print the details to a file.
    @RequestMapping(value = "/**", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RequestDetails> allRequests(HttpServletRequest httpServletRequest) throws IOException {
        RequestDetails request = new RequestDetails();

        request.setUrl(httpServletRequest.getRequestURI());
        request.setBody(IOUtils.toString(httpServletRequest.getInputStream(), Charset.defaultCharset()));
        return new ResponseEntity<RequestDetails>(request, HttpStatus.OK);
    }
}
