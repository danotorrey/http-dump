package com.dantorrey.httpdump.controller;

import com.dantorrey.httpdump.value.RequestDetails;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

@Controller
public class WebRequestController {


    /**
     * Accept all web requests, and print the details to a file.
     * @return a JSON representation of the request
     */
    @RequestMapping(value = "/**", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RequestDetails> allRequests(HttpServletRequest httpServletRequest, @RequestHeader Map<String, String> headers) throws IOException {
        RequestDetails request = new RequestDetails();

        request.setUrl(httpServletRequest.getRequestURI());
        request.setMethod(httpServletRequest.getMethod());
        request.setBody(IOUtils.toString(httpServletRequest.getInputStream(), Charset.defaultCharset()));
        request.setHeaders(headers);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }
}
