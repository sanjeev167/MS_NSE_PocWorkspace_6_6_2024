package com.nse.application.factory;
import com.nse.application.command.OrderCommand;
import com.nse.application.query.OrderQuery;
/**
 * @author sanjeevkumar
 * <br>11-May-2024
 * <br>11:40:52 am
 * <br>OrderFactory will provide two different objects for processing jobs of two different contexts. OrderCommand is related with workflow
 * context whereas OrderQuery is related with normal order query context.
 */
public interface OrderFactory {
	OrderCommand getOrderCommand();
	OrderQuery getOrderQuery();
}
