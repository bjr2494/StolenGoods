package day6.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

@SpringBootApplication
public class Project56Application {

	public static void main(String[] args) {
		SpringApplication.run(Project56Application.class, args);
	}
	
	@Bean("thief")
	@SessionScope
	public Thief makeThief() {
		Thief thief = new Thief();
		return thief;
	}
	
	@Bean("sGood")
	@SessionScope
	public StolenGood stolenGood() {
		StolenGood sGood = new StolenGood();
		return sGood;
	}
	
	@Bean("sgm")
	@ApplicationScope
	public StolenGoodManager sGoodMan() {
		StolenGoodManager sgm = new StolenGoodManager();
		return sgm;
	}
	
	@Bean("tm")
	@ApplicationScope
	public ThiefManager thiefMan() {
		ThiefManager tm = new ThiefManager();
		return tm;
	}
}
