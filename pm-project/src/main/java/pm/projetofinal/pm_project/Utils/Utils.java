package pm.projetofinal.pm_project.Utils;

import java.util.HashMap;
import java.util.Map;

public class Utils {

	public static final Map<String, String> mapaUF = new HashMap<String, String>();

	static {
		mapaUF.put(new String("12"), "AC");
		mapaUF.put(new String("27"), "AL");
		mapaUF.put(new String("13"), "AM");
		mapaUF.put(new String("12"), "AP");
		mapaUF.put(new String("12"), "BA");
		mapaUF.put(new String("12"), "CE");
		mapaUF.put(new String("16"), "AP");
		mapaUF.put(new String("29"), "BA");
		mapaUF.put(new String("23"), "CE");
		mapaUF.put(new String("53"), "DF");
		mapaUF.put(new String("32"), "ES");
		mapaUF.put(new String("52"), "GO");
		mapaUF.put(new String("21"), "MA");
		mapaUF.put(new String("31"), "MG");
		mapaUF.put(new String("50"), "MS");
		mapaUF.put(new String("51"), "MT");
		mapaUF.put(new String("15"), "PA");
		mapaUF.put(new String("25"),"PB");
		mapaUF.put(new String("26"), "PE");
		mapaUF.put(new String("22"), "PI");
		mapaUF.put(new String("41"), "PR");
		mapaUF.put(new String("33"), "RJ");
		mapaUF.put(new String("24"), "RN");
		mapaUF.put(new String("11"), "RO");
		mapaUF.put(new String("14"), "RR");
		mapaUF.put(new String("43"), "RS");
		mapaUF.put(new String("42"), "SC");
		mapaUF.put(new String("28"), "SE");
		mapaUF.put(new String("35"), "SP");
		mapaUF.put(new String("17"), "TO");
	}

	public static boolean isIntegerParseInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException nfe) {
		}
		return false;
	}
}
