/**
 * 
 */
package com.nse.query;
import com.nse.domain.Order;
/**
 * @author sanjeevkumar
 * <br>11-May-2024
 * <br>11:46:46 am
 * <br>
 */
public interface OrderQuery {
	Order getOrder(Long orderId);
}
