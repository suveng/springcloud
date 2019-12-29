package qw.test.order.service.feign;

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
class FeignUserServiceTest extends ApplicationTests {

	@Autowired
	FeignUserService feignUserService;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void get() {
		Object o = feignUserService.get();
		System.out.println(o);
	}
}
