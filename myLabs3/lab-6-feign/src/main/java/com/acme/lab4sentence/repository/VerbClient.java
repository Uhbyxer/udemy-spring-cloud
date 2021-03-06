package com.acme.lab4sentence.repository;

import com.acme.lab4sentence.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("LAB-4-VERB")
public interface VerbClient {
	@RequestMapping(value = "/", method = GET)
	Word getWord();
}
