package com.furniture.controller;

import com.furniture.Repository.CurrencyRepository;
import com.furniture.dto.AmountDto;
import com.furniture.dto.ConvertDto;
import com.furniture.model.Currency;
import com.furniture.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping("/all")
    public List<Currency> getAllCurrency(){
        return currencyService.getAllCurrency();
    }
    @PostMapping("/create")
    public Currency createCurrency(@RequestBody Currency currency){
        return currencyService.createCurrency(currency);
    }
    @DeleteMapping("/{currencyId}")
    public void deleteCurrency(@PathVariable int currencyId){
        currencyService.deleteCurrency(currencyId);
    }
    @PutMapping("/update/{currencyId}")
    public  void updateCurrency(@RequestBody Currency currency,@PathVariable int currencyId){
        currencyService.updateCurrency(currencyId,currency);
    }

    @PostMapping("/convert")
    public AmountDto convertCurrency(@RequestBody ConvertDto convertDto){
        return currencyService.convertCurrency(convertDto);
    }

}
