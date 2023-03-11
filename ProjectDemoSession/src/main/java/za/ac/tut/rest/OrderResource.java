/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.rest;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import za.ac.tut.dao.Orders;
import za.ac.tut.dao.OrderRepository;



/**
 *
 * @author MosesGadebe
 */
@Path("/order")
public class OrderResource 
{
    OrderRepository dao = new OrderRepository();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/store")
    public String storeOrder(Orders order)
    {
        dao.open();
        dao.store(order);
        dao.close();
        return "Order is inserted";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/all")
    public ArrayList<Orders> getOrder()
    {
       ArrayList<Orders> list = null;
       
       dao.open();
       list =  dao.findAll();
       dao.close();
       return list;
    }
}
