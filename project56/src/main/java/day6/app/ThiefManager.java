package day6.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThiefManager {

	private List<Thief> thieves;

	public List<String> goods1 = new LinkedList<>(Arrays.asList("generic"));
	public List<String> goods2 = new LinkedList<>(Arrays.asList("mayo"));
	public List<String> goods3 = new LinkedList<>(Arrays.asList("wallet"));
	
	public ThiefManager() {
		Thief thief1 = new Thief("ButchCassidy", goods1);
		Thief thief2 = new Thief("BillMason", goods2);
		Thief thief3 = new Thief("FrancoisVillon", goods3);
		this.thieves = new ArrayList<Thief>(Arrays.asList(thief1, thief2, thief3));
	}
	
	public List<Thief> getThieves() {
		return thieves;
	}
	
	public void addGoodToThiefList(Thief thief, ThiefManager tm, StolenGood sGood) {
		if (thief.getUsername().equals("ButchCassidy")) {
			this.goods1.add(sGood.getNameOfGood());
		}
		if (thief.getUsername().equals("BillMason")) {
			this.goods2.add(sGood.getNameOfGood());
		}
		if (thief.getUsername().equals("FrancoisVillon")) {
			this.goods3.add(sGood.getNameOfGood());
		}
	}
}
