package com.example.demo;

import com.microsoft.applicationinsights.TelemetryClient;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microsoft.applicationinsights.telemetry.Duration;

@RestController
@RequestMapping("/sample")
public class TestController {

    @Autowired
    TelemetryClient telemetryClient;

    private static final Logger logger = LoggerFactory.getLogger( TestController.class);

    @GetMapping("/hello")
    public String hello() {


        //track a custom event
        logger.info( "Logging Pius TestController--new" );
        logger.error ( "Logging Pius Error");
       telemetryClient.trackEvent("Sending a custom event...");
        telemetryClient.trackTrace("test pooja3");
        //trace a custom trace
       // telemetryClient.trackTrace("Sending a custom trace....");

        //track a custom metric
      //  telemetryClient.trackMetric("custom metric", 1.0);

        //track a custom dependency
      //  telemetryClient.trackDependency("SQL", "Insert", new Duration(0, 0, 1, 1, 1), true);

        return "hello";
    }
}