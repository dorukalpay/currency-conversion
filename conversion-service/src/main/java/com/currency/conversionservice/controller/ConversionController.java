package com.currency.conversionservice.controller;

import com.currency.conversionservice.dto.conversion.ConversionListRequest;
import com.currency.conversionservice.dto.conversion.ConversionListResponse;
import com.currency.conversionservice.dto.conversion.ConversionRequest;
import com.currency.conversionservice.dto.conversion.ConversionResponse;
import com.currency.conversionservice.service.ConversionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class ConversionController {

    private final ConversionService conversionService;

    @PostMapping("/convert")
    public ConversionResponse convert(@RequestBody @Valid ConversionRequest request) {
        return conversionService.convert(request);
    }

    @GetMapping("/listConversions")
    public ConversionListResponse listConversions(ConversionListRequest request) {
        return conversionService.listConversions(request);
    }
}
