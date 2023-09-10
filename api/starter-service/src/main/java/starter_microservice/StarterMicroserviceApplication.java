package starter_microservice;


;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
	public class StarterMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(StarterMicroserviceApplication.class, args);
	}
}
