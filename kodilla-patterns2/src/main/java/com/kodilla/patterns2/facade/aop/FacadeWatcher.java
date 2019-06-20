package com.kodilla.patterns2.facade.aop;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(orderDto, userId))")
    public void logEvent(OrderDto orderDto, Long userId) {
        LOGGER.info("------------------------------");
        LOGGER.info("User ID: " + userId);
        orderDto.getItems().stream()
                .forEach(itemDto -> LOGGER.info("Product ID: " + itemDto.getProductId() + " Quantity: " + itemDto.getQuantity()));
        LOGGER.info("------------------------------");
    }

}
