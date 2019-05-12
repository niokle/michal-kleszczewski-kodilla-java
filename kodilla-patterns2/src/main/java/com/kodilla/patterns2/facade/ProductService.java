package com.kodilla.patterns2.facade;

import java.math.BigDecimal;

public interface ProductService {
    public BigDecimal getPrice(Long productId);
}
