/**
 * 
 */
package com.nse.factory;

import com.nse.command.OrderCommand;
import com.nse.query.OrderQuery;


/**
 * @author sanjeevkumar
 * <br>11-May-2024
 * <br>11:42:50 am
 * <br>Objective: Using this OrderFactory, we can initiate any order related operation. Right now, it provides two get operations through which
 * We can get an object of OrderCommand and an object of OrderQuery.
 *  <br>OrderCommand: We will start processing orderWorkFlow using its method.
 *  <br>OrderQuery: We will start processing different order queries using its method.
 */
public class OrderFactoryImpl implements OrderFactory{
	 private final OrderCommand orderCommand;
	 private final OrderQuery orderQuery;

	  public OrderFactoryImpl(OrderCommand orderCommand, OrderQuery orderQuery) {
	    this.orderCommand = orderCommand;
	    this.orderQuery = orderQuery;
	  }
	  
	  @Override
	  public OrderCommand getOrderCommand() {
	    return orderCommand;
	  }
	  @Override
	  public OrderQuery getOrderQuery() {
	    return orderQuery;
	  }
}//End of OrderFactoryImpl
