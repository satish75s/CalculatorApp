package com.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.service.CalculatorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class CalculatorController {
	@Autowired
	CalculatorService calculatorService;

	@GetMapping("/add")
	public ResponseEntity<Integer> addition(@RequestParam("a") int a, @RequestParam("b") int b) {
		log.info("addition");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "foo");
		return new ResponseEntity<>(calculatorService.addition(a, b), headers, HttpStatus.CREATED);
		/*
		 * return ResponseEntity.ok() .header("Custom-Header", "foo")
		 * .body(calculatorService.addition(a, b));
		 */
	}

	@GetMapping("/subtract")
	public int subtraction(@RequestParam("a") int a, @RequestParam("b") int b) {
		return calculatorService.subtraction(a, b);
	}

	@GetMapping("/multiply")
	public int multiplication(@RequestParam("a") int a, @RequestParam("b") int b) {
		log.info("multiplication testing");
		return calculatorService.multiplication(a, b);
	}

	@GetMapping("/divide")
	public int division(@RequestParam("a") int a, @RequestParam("b") int b) {
		return calculatorService.division(a, b);
	}

}
