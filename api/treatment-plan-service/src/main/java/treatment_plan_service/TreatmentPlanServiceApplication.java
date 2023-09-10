package treatment_plan_service;


;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
	public class TreatmentPlanServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TreatmentPlanServiceApplication.class, args);
	}
}
