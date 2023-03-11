/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author david
 */
@WebService(serviceName = "CylinderServices")
public class CylinderServices {
    
  @WebMethod(operationName = "getBaseArea")
    public double calculateBaseArea(double radius) {
        return Math.PI * radius * radius;
    }

    @WebMethod(operationName = "getSurfaceArea")
    public double calculateSurfaceArea(double radius, double height) {
        return 2 * Math.PI * radius * (radius + height);
    }

    @WebMethod(operationName = "getPerimeter")
    public double calculatePerimeter(double radius, double height) {
        return 2 * Math.PI * radius + 2 * height;
    }

    @WebMethod(operationName = "getVolume")
    public double calculateVolume(double radius, double height) {
        return Math.PI * radius * radius * height;
    }
}