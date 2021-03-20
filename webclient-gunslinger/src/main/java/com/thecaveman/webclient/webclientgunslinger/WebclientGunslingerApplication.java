package com.thecaveman.webclient.webclientgunslinger;

import com.thecaveman.webclient.webclientgunslinger.model.CowboyRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/cowboyShow")
public class WebclientGunslingerApplication {
	WebClient webClient;

	@PostConstruct//bean initialized
	public void init() {
		webClient = WebClient.builder().baseUrl("http://localhost:8080/v1/cowboyMuseum")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build()
		;
	}

	@PostMapping("/cowboyPost")
	public Mono<String> cowboyPog(@RequestBody CowboyRequest request){
		return webClient.post().uri("/cowboyWelc").syncBody(request).retrieve().bodyToMono(String.class);
	}

	@GetMapping("/getAllCowboys")
	public Flux<CowboyRequest> getAllCowboys(){
		return webClient.get().uri("/getAllCowboys").retrieve().bodyToFlux(CowboyRequest.class);
	}

	@GetMapping("/getById/{id}")
	public Mono<CowboyRequest> getCowboyById(@PathVariable(value = "id") Long id){
		return webClient.get().uri("/findById/"+id).retrieve().bodyToMono(CowboyRequest.class);
	}

	@DeleteMapping("/deleteById/{id}")
	public Mono<String> deleteById(@PathVariable(value = "id") Long id){
		return webClient.delete().uri("/deleteById/"+id).retrieve().bodyToMono(String.class);
	}

	@PutMapping("/updateById/{id}")
	public Mono<CowboyRequest> updateById(@PathVariable(value = "id")Long id,@RequestBody CowboyRequest request){
		return webClient.put().uri("/updateCowboy/"+id).syncBody(request).retrieve().bodyToMono(CowboyRequest.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WebclientGunslingerApplication.class, args);
	}

}
