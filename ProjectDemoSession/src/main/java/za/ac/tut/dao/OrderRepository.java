/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MosesGadebe
 */
public class OrderRepository
{
    private EntityManagerFactory factory;
    private EntityManager manager;
    //opens the persistence
    public void open()
    {
        factory = Persistence.createEntityManagerFactory("abcLink");
        manager = factory.createEntityManager();
    }
    //insert
    public void store(Orders order)
    {
        manager.getTransaction().begin();
        manager.persist(order);
        manager.getTransaction().commit();
    }
    //retrieve a record
    public Orders findOrder(int orderID)
    {
        return manager.find(Orders.class, orderID);
    }
    //Retrive all orders
    public ArrayList<Orders> findAll()
    {
         String sql = "Select order from Orders order";
          ArrayList<Orders> orders = new ArrayList<Orders>(manager.createQuery(sql).getResultList()); 
          return orders;
          
    }
    
    public void updateOrder(Orders order)
    {
        Orders orderItem = findOrder(order.getOrderID());
        
        if (orderItem != null)
        {
            manager.getTransaction().begin();
            manager.merge(order);
            manager.getTransaction().commit();
        }
    }
    //delete
    public void deleteOrder(int orderID)
    {
        Orders orderItem = findOrder(orderID);      
        if (orderItem != null)
        {
            manager.getTransaction().begin();
            manager.remove(orderItem);
            manager.getTransaction().commit();
        }
    }
    //closes the persistence
    public void close()
    {
        
        manager.close();
        factory.close();
    }
}
