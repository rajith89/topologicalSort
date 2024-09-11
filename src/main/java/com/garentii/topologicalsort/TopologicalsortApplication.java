package com.garentii.topologicalsort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class TopologicalsortApplication {


	public static void main(String[] args) {
		SpringApplication.run(TopologicalsortApplication.class, args);

		List<VulnerabilityScript> scripts = Arrays.asList(
				new VulnerabilityScript(1, Arrays.asList(2, 3)),
				new VulnerabilityScript(2, Arrays.asList(4)),
				new VulnerabilityScript(3, Arrays.asList(4)),
				new VulnerabilityScript(4, Collections.emptyList())
		);

		List<Integer> sorted = TopologicalSort.sortScripts(scripts);
		System.out.println("Topologically sorted script IDs: " + sorted);
	}

}
