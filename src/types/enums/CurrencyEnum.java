package types.enums;

import java.util.Hashtable;
import java.util.Map;

public enum CurrencyEnum {

	INVALID_CURRENCY("INVALID","INVALID"),

	BLESSED_ORB("Blessed Orb","blessed"),
	CARTOGRAPHERS_CHISEL("Cartographer's Chisel","chisel"),
	CHAOS_ORB("Chaos Orb","chaos"),
	CHROMATIC_ORB("Chromatic Orb","chrome"),
	DIVINE_ORB("Divine Orb","divine"),
	EXALTED_ORB("Exalted Orb","exalted"),
	MIRROR_OF_KALANDRA("Mirror of Kalandra","mirror"),
	ORB_OF_ALCHEMY("Orb of Alchemy","alchemy"),
	ORB_OF_ALTERATION("Orb of Alteration","alteration"),
	ORB_OF_AUGMENTATION("Orb Of Augmentation","augmentation"),
	ORB_OF_CHANCE("Orb of Chance","chance"),
	ORB_OF_FUSING("Orb of Fusing","fusing"),	
	BLESSING_OF_CHAYULA("Blessing of Chayula","blessing of chayula"),
	BLESSING_OF_ESH("Blessing of Esh","blessing of esh"),
	BLESSING_OF_TUL("Blessing of Tul","blessing of tul"),
	BLESSING_OF_UUL_NETOL("Blessing of Uul-Netol","blessing of uul-netol"),
	BLESSING_OF_XOPH("Blessing of Xoph","blessing of xoph"),
	ORB_OF_ANNULMENT("Orb of Annulment","Orb of Annulment"),	
	ARMOURERS_SCRAP("Armourer's Scrap","armourer's"),
	BLACKSMITHS_WHETSTONE("Blacksmith's Whetstone","whetstone"),
	ORB_OF_REGRET("Orb of Regret","regret"),
	ORB_OF_SCOURING("Orb of Scouring","scouring"),
	ORB_OF_TRANSMUTATION("Orb of Transmutation","transmutation"),
	PORTAL_SCROLL("Portal Scroll","portal"),
	REGAL_ORB("Regal Orb","regal"),
	SCROLL_OF_WISDOM("Scroll of Wisdom","wisdom"),
	SILVER_COIN("Silver Coin","silver"),
	VAAL_ORB("Vaal Orb","vaal"),
	GEMCUTTERS_PRISM("Gemcutter's Prism","gcp"),
	GLASSBLOWERS_BAUBLE("Glassblower's Bauble","bauble"),
	JEWELLERS_ORB("Jeweller's Orb","jeweller's"),
	APPRENTICE_CARTOGRAPHERS_SEXTANT("Apprentice Cartographer's Sextant","apprentice sextant"),
	JOURNEYMAN_CARTOGRAPHERS_SEXTANT("Journeyman Cartographer's Sextant","journeyman sextant"),
	MASTER_CARTOGRAPHERS_SEXTANT("Master Cartographer's Sextant","master sextant"),
	SPLINTER_OF_CHAYULA("Splinter of Chayula","splinter of chayula"),	
	SPLINTER_OF_ESH("Splinter of Esh","splinter of esh"),	
	SPLINTER_OF_TUL("Splinter of Tul","splinter of tul"),	
	SPLINTER_OF_UUL_NETOL("Splinter of Uul-Netol","splinter of uul-netol"),		
	SPLINTER_OF_XOPH("Splinter of Xoph","splinter of xoph"),	
	ANCIENT_ORB("Ancient Orb","Ancient Orb"),
	ANNULMENT_SHARD("Annulment Shard","Annulment Shard"),
	ENGINEERS_ORB("Engineer's Orb","Engineer's Orb"),	
	EXALTED_SHARD("Exalted Shard","Exalted Shard"),
	HARBINGERS_ORB("Harbinger's Orb","Harbinger's Orb"),	
	MIRROR_SHARD("Mirror Shard","Mirror Shard"),
	ORB_OF_BINDING("Orb of Binding","Orb of Binding"),
	ORB_OF_HORIZONS("Orb of Horizons","Orb of Horizons"),
	PERANDUS_COIN("Perandus Coin","coin");
	
	/** UNIMPLEMENTED BY CURRENCY API LISTED BELOW */
	//ALBINO_RHOA_FEATHER,
	//APPRENTICE_CARTOGRAPHERS_SEAL,
	//TRANSMUTATION_SHARD,
	//REGAL_SHARD,
	//HARBINGERS_SHARD,
	//HORIZON_SHARD,
	//ENGINEERS_SHARD,
	//BINDING_SHARD,
	//CHAOS_SHARD,
	//ANCIENT_SHARD,
	//ALCHEMY_SHARD,
	//ALTERATION_SHARD,
	//SCROLL_FRAGMENT,	
	//MASTER_CARTOGRAPHERS_SEAL,
	//JOURNEYMAN_CARTOGRAPHERS_SEAL,
	// Lab
	//OFFERING_TO_THE_GODDESS()
	//UNSHAPING_ORB,
	
	private String apiString;
	private String tradeString;
	
	private CurrencyEnum(String apiString, String tradeString) {
		this.apiString = apiString;
		this.tradeString = tradeString;
	}
	
	public String getApiString() {
		return apiString;
	}
	
	public String getTradeString() {
		return tradeString;
	}
	
	private static Map<String, CurrencyEnum> map;
	
	static {
		map = new Hashtable<String, CurrencyEnum>();
		for (CurrencyEnum e : CurrencyEnum.values()) {
			map.put(e.apiString, e);
			map.put(e.tradeString, e);
		}
	}
	
	public static CurrencyEnum fromString(String s) {
		return map.containsKey(s) ? map.get(s) : CurrencyEnum.INVALID_CURRENCY;
	}
	
	
}
