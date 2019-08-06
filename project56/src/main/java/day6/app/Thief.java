package day6.app;

import java.util.List;

public class Thief {
	
	private String username;
	private String password;
	private List<String> thiefGoods;
	private boolean loggedIn;
	
	public Thief() {}
	
	public Thief(String username, List<String> thiefGoods) {
		this.username = username;
		this.thiefGoods = thiefGoods;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword(String username) {
		if (username.equals("ButchCassidy"))
			return "123";
		else if (username.equals("BillMason"))
			return "456";
		else return "789"; // for FrancoisVillon
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getThiefGoods() {
		return thiefGoods;
	}

	public void setThiefGoods(List<String> thiefGoods) {
		this.thiefGoods = thiefGoods;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public void thiefAs(String username) {
		this.username = username;
		this.loggedIn = true;
	}
	
	public void stopThiefing() {
		this.loggedIn = false;
		this.username = null;
	}

	@Override
	public String toString() {
		return "Thief [username=" + username + ", password=" + password + ", thiefGoods=" + thiefGoods + ", loggedIn="
				+ loggedIn + "]";
	}
}
