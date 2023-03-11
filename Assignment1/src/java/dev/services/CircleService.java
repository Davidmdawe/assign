/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author david
 */
@WebService(serviceName = "CircleService")
public class CircleService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getArea")
    @WebResult(name = "area")
    public double getArea(@WebParam(name = "radius") double radius) {
        return Math.PI * radius * radius;
    }

    @WebMethod(operationName = "getDiameter")
    @WebResult(name = "diameter")
    public double getDiameter(@WebParam(name = "radius") double radius) {
        return radius * 2;
    }

    @WebMethod(operationName = "getCircumference")
    @WebResult(name = "circumference")
    public double getCircumference(@WebParam(name = "radius") double radius) {
        return 2 * Math.PI * radius;
    }

    @WebMethod(operationName = "getPerimeter")
    @WebResult(name = "perimeter")
    public double getPerimeter(@WebParam(name = "radius") double radius) {
        return 2 * Math.PI * radius;
    }
}
