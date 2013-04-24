package hooks;

public class DatoConverter 
{
	
	public static String Convertorz(String dato)
	{
		String nyDatoDel1 = dato.substring(0,4);
		String nyDatoDel2 = dato.substring(4,6);
		String nyDatoDel3 = dato.substring(6,8);
		
		String NyDato = nyDatoDel1 + " : " + nyDatoDel2 + " : " + nyDatoDel3;
		return NyDato;
	}
}
