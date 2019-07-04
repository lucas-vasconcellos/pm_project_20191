package pm.projetofinal.pm_project.UtilsTest;

import pm.projetofinal.pm_project.Utils.Utils;
import org.junit.*;

public class UtilsTest {

	/**
	 * Teste que verifica se dado uma string ela pode ser parseada para integer
	 */
	@Test
	public void testIsIntegerParseIntSuccess() {
		final String strToParse = "1234567890";

		boolean isParsable = Utils.isIntegerParseInt(strToParse);
		boolean resultadoEsperado = true;
		Assert.assertEquals(resultadoEsperado, isParsable);
	}

	/**
	 * Teste que verifica se dado uma string ela não consegue ser parseada para
	 * integer
	 */
	@Test
	public void testIsIntegerParseIntFailure() {
		final String strToParse = "@sads_)#$!";

		boolean isParsable = Utils.isIntegerParseInt(strToParse);
		boolean resultadoEsperado = false;
		Assert.assertEquals(resultadoEsperado, isParsable);
	}
}
