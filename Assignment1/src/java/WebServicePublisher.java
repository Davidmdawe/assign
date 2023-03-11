/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
import dev.services.CircleService;
import dev.services.CylinderServices;
import javax.xml.ws.Endpoint;

public class WebServicePublisher {
    public static void main(String[] args) {
        String circleServiceUrl = "http://localhost:3360/circle";
        Endpoint.publish(circleServiceUrl, new CircleService());

        String cylinderServicesUrl = "http://localhost:3360/cylinder";
        Endpoint.publish(cylinderServicesUrl, new CylinderServices());

        System.out.println("CircleService published at " + circleServiceUrl);
        System.out.println("CylinderService published at " + cylinderServicesUrl);
    }
}
