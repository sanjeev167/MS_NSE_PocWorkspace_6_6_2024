package com.nse.oder.service;

import com.nse.application.domain.Order;

/**
 * @author sanjeevkumar
 * 11-May-2024
 * 11:38:32 am
 */
public interface OrderService {
	Order save(Order order);
	Order get(Long orderId);
}
