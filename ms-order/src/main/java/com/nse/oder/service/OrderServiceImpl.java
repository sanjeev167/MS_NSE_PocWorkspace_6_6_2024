package com.nse.oder.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nse.application.domain.Order;
import com.nse.error.ResourceNotFoundException;
import com.nse.oder.repo.OrderJpaRepository;

import jakarta.transaction.Transactional;

/**
 * @author sanjeevkumar 
 * 11-May-2024 
 * 12:10:57 pm
 */
public class OrderServiceImpl implements OrderService {
	Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	private final OrderJpaRepository orderJpaRepository;

	public OrderServiceImpl(OrderJpaRepository orderJpaRepository) {
		this.orderJpaRepository = orderJpaRepository;
	}

	@Override
	@Transactional
	public Order save(Order order) {
		log.info("Saving Order");
		var orderPersistable = OrderPersistableMapper.MAPPER.map(order);
		orderPersistable = orderJpaRepository.save(orderPersistable);
		log.info("Order saved, order {}", orderPersistable);
		return OrderPersistableMapper.MAPPER.map(orderPersistable);
	}

	@Override
	@Transactional
	public Order get(Long orderId) {
		log.info("Fetching order for id {}", orderId);
		var orderPersistable = orderJpaRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found"));
		log.info("Fetched order, {}", orderPersistable);
		return OrderPersistableMapper.MAPPER.map(orderPersistable);
	}
}
