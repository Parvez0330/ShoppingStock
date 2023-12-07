package com.shopping.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shopping.entity.Stock;
import com.shopping.exception.StockNotFoundException;
import com.shopping.service.StockService;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
	Logger logger = LogManager.getLogger(StockController.class);
    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStocks() {
    	logger.info("All Stocks Viewed");
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id) {
    	logger.info("Displaying the Stock Id Details");
        return stockService.getStockById(id).orElse(null);
    }

    @PostMapping
    public Stock saveStock(@RequestBody Stock stock) {
    	logger.info("Saved Stock");
        return stockService.saveStock(stock);
    }

    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock updatedStock){
    	logger.info("Update Stock");
        return stockService.updateStock(id, updatedStock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
    	logger.info("Delete Stock");
        stockService.deleteStock(id);
    }
    // Global Exception Handling
    @ExceptionHandler(StockNotFoundException.class)
    public String handleCustomerNotFoundException(StockNotFoundException ex) {
        return ex.getMessage();
    }
}
