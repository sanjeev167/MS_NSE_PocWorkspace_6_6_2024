/**
 * 
 */
package com.nse.command;
import com.nse.domain.Order;
/**
 * @author sanjeevkumar
 * 11-May-2024
 * 11:33:46 am
 */
public interface OrderCommand {
	Order createOrder(Order order);
}
