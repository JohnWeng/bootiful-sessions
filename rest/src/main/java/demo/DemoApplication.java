package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * <OL>
 * <LI> Confirm that the Redis instance is avaialbe. Perhaps run {@code FLUSHDB}, but only </LI>
 * <LI>First {@code curl  http://localhost:8080/ -v -u user:password}. This will let you see the headers. Make sure to extract the
 * {@code x-auth-token} and store it.
 * </LI>
 * <LI> Send a request specifying only the token, not the username and password.
 * {@code curl  http://localhost:8080/ -H "x-auth-token: f4a06478-a3c9-4162-90a0-fdaf5110b7f1"}
 * </LI>
 * <LI>Verify the results: {@code redis-cli keys '*' | xargs redis-cli del}</LI>
 * </OL>
 */
@EnableRedisHttpSession
@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	Map<String, String> helloUser(Principal principal) {
		Map<String, String> result = new HashMap<>();
		result.put("usernamlllllllllle", principal.getName());
		return result;
	}
//
//	@RequestMapping("/logout")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	void logout(HttpSession session) {
//		session.invalidate();
//	}



//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String handle(@RequestParam Map<String, String> reqPar) throws Exception {
//
//		return "ok";
//
//	}
}



