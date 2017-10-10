package com.acme.lab4sentence.repository;

import com.acme.lab4sentence.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("LAB-4-ADJECTIVE")
public interface AdjectiveClient {

	@GetMapping("/")
	Word getWord();
}
