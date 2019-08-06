package day6.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class LeController {
	
	@Autowired
	StolenGoodManager sgm;
	
	@Autowired
	ThiefManager tm;
	
	@Autowired
	Thief thief;
	
	@Autowired
	StolenGood sGood;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("thieves", tm.getThieves());
		return "home";
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("loginTry")LoginTry loginTry) {
		return "login";
	}
	
	@PostMapping("/timeline")
	public String timeline(@ModelAttribute("loginTry")LoginTry loginTry, RedirectAttributes redirect, Model model) {
		if (this.thiefLikeLogin(loginTry.getUsername(), (Hasher.hash(loginTry.getPassword())))) {
			thief.thiefAs(loginTry.getUsername());
			thief.setUsername(loginTry.getUsername());
			model.addAttribute("firstGoods", sgm.getStolenGoods());
			return "timeline";
		}
		else { 
			model.addAttribute("message", "YOU CAN STEAL MANY THINGS BUT NOT ACCESS TO THIS SITE. TRY AGAIN.");
			return "login";
		}
	}
	
	@GetMapping("/timeline")
	public String timeline(RedirectAttributes redirect) {
		if (!thief.isLoggedIn()) {
			redirect.addFlashAttribute("message", "You must log in first");
			return "redirect:/home";
		} 
		else return "timeline";
	}
	
	@PostMapping("/logout")
	public String logout(RedirectAttributes redirect) {
		thief.stopThiefing();
		redirect.addFlashAttribute("message", "Bye now");
		return "redirect:/home";
	}
	
	@GetMapping("/new")
	public String good(@ModelAttribute("potentialGood")StolenGood potentialGood, RedirectAttributes redirect) {
		if (!thief.isLoggedIn()) {
			redirect.addFlashAttribute("message", "You must log in first");
			return "redirect:/home";
		}
		else return "new";
	}
	
	@PostMapping("/old")
	public String old(@ModelAttribute("potentialGood") StolenGood potentialGood, Errors errors, Model model) {
		if (errors.hasErrors())
			return "new";
		else {
			sGood.setOwner(thief.getUsername());
			sGood.setNameOfGood(potentialGood.getNameOfGood());
			sGood.setVictim(potentialGood.getVictim());
			sGood.setDescriptionOfEvent(potentialGood.getDescriptionOfEvent());
			sGood.setGoodComments(potentialGood.getGoodComments());
			tm.addGoodToThiefList(thief, tm, sGood);
			sgm.fullyAddGood(sGood);
			model.addAttribute("thieves", tm.getThieves());
			return "old";
		}
	}
	
	@GetMapping("/elaborate")
	public String elaborate() {
		return "elaborate";
	}
	
	private boolean thiefLikeLogin(String username, String password) {
		return (username.equals("ButchCassidy") && password.equals(Hasher.hash("123"))) ||
				(username.equals("BillMason") && password.equals(Hasher.hash("456"))) ||
				(username.equals("FrancoisVillon") && password.equals(Hasher.hash("789")));
	}
}
