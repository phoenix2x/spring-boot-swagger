package com.example.demo;

import com.example.demo.services.ItemSummaryApiWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo"}, excludeFilters={
  @ComponentScan.Filter(type=FilterType.REGEX, pattern="com.example.demo.swagger.*"),
})
public class DemoApplication implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
    private ItemSummaryApiWrapper itemSummaryApiWrapper;

	@Autowired
	@Qualifier("ebay")
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		RequestEntity request = RequestEntity
//		.get(new URI("https://api.sandbox.ebay.com/buy/browse/v1/item_summary/search?q=shirt"))
//		.accept(MediaType.APPLICATION_JSON)
//		.build();
//		Bean bean = restTemplate.exchange(request, Bean.class).getBody();
//		logger.info(bean.toString());
//		logger.info(itemSummaryApiWrapper.search("drone").get(0).toString());
	}

	private static class Bean {
		private String href;

		public String getHref() {
			return href;
		}

		public void setHref(String href) {
			this.href = href;
		}
	}
}
