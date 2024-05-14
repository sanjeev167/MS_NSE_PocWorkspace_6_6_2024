/**
 * 
 */
package com.nse.application.command;
import com.nse.application.domain.Order;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 11:33:46 am
 */
public interface OrderCommand {
	Order createOrder(Order order);
}
