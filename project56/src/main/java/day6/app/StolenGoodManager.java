package day6.app;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StolenGoodManager {
	
	private List<StolenGood> stolenGoods;
	
	public List<String> genericComments = new LinkedList<>(Arrays.asList("comment1", "comment2", "comment3"));
	public List<String> mayoComments = new LinkedList<>(Arrays.asList("Isn't that word spelled with like four Ns?",
			"I change the spelling of words ALL the time."));
	public List<String> walletComments = new LinkedList<>(Arrays.asList("I have a lot of empty wallets",
			"Uhh why not use the word billfold to avoid confusion? To me a wallet is a mini wall.."));

	public StolenGoodManager() {
		StolenGood generic = new StolenGood("ButchCassidy", "name", "victim", "description", genericComments);
		StolenGood mayo = new StolenGood("BillMason", "jar of mayonaise", "someone who likes mayonaise", 
				"someone stole someone else's mayonaise and then changed the spelling of that very word,"
				+ " thereby stealing also the original spelling", mayoComments);
		StolenGood wallet = new StolenGood("FrancoisVillon", "wallet", "someone who now has no wallet", "this thief stole only the wallet itself,"
				+ " not the contents of the wallet", walletComments);
		this.stolenGoods = new LinkedList<>(Arrays.asList(generic, mayo, wallet));
	}
			
	public List<StolenGood> getStolenGoods() {
		return stolenGoods;
	}
	
	public void fullyAddGood(StolenGood sGood) {
		this.stolenGoods.add(sGood);	
	}
	
	public void addComments(StolenGood sGood, String comment) {
		List<String> goodComments = sGood.getGoodComments();
		goodComments.add(comment);
	}
}
