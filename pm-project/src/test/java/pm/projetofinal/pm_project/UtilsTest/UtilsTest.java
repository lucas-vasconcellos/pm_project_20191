package pm.projetofinal.pm_project.UtilsTest;

import pm.projetofinal.pm_project.Utils.Utils;
import org.junit.*;

public class UtilsTest {
	
	Utils utils = new Utils();
	
	@Test
	public void testIsIntegerParseIntSuccess()
	{
		final String strToParse = "1234567890";
		
		boolean isParsable = utils.isIntegerParseInt(strToParse);
		boolean resultadoEsperado = true;
		Assert.assertEquals(resultadoEsperado, isParsable);
	}
	
	@Test
	public void testIsIntegerParseIntFailure()
	{
		final String strToParse = "@sads_)#$!";
		
		boolean isParsable = utils.isIntegerParseInt(strToParse);
		boolean resultadoEsperado = false;
		Assert.assertEquals(resultadoEsperado, isParsable);
	}
}
