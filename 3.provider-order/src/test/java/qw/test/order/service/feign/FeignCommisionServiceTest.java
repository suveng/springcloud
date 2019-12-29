package qw.test.order.service.feign;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import qw.test.order.ApplicationTests;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author suwenguang
 **/
class FeignCommisionServiceTest extends ApplicationTests {

	@Autowired
	FeignCommisionService feignCommisionService;
	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void health() {
		Object health = feignCommisionService.health();
		System.out.println(JSON.toJSONString(health));
	}
}
