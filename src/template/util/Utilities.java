package template.util;

import java.util.Date;
import java.util.ResourceBundle;


public abstract class Utilities {
	public static String getFieldBundle(String field,ResourceBundle rb){
		try{
			return rb.getString(field);

		}catch(Exception e){
			e.printStackTrace();
			return "";
		}

	}
	public static boolean isEmpty(String s)
	{
		if(s==null) return true;
		if(s.equals("") || s.trim().equals(""))return true;
		return false;
	}
	public static float tryParse(String param)
	{
		if(param == null) return -1;
		try{
			return Float.parseFloat(param);
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
			return -1;
		}
			
	}
	
	public static int tryParse(String param,int base)
	{
		if(param == null) return -1;
		try{
			return Integer.parseInt(param,base);
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
			return -1;
		}
		
	}
	public static double tryParseDouble(String param)
	{
		if(param == null) return -1;
		try{
			return Double.parseDouble(param);
		}catch(Exception e)
		{

			e.printStackTrace();
			return -1;
		}
		
	}
	public static Date tryParseDate(String param) 
	{
		String [] dateFormats = new String []{
				"yyyy-MM-dd HH:mm:ss",
				"yyyy-MM-dd HH:mm",
				"yyyyMMdd HH:mm:ss",
				"yyyyMMdd HH:mm",
				"yyyyMMdd HHmm",
				"yyyy-MM-dd",
				"yyyyMMdd",
		};
		
		for (int i=0; i<dateFormats.length;i++)
		{
			try{
				return new java.text.SimpleDateFormat(dateFormats[i]).parse(param); 
			}catch(Exception e)
			{
				continue;
						
			}
		}
		try{
			return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2000-01-01 00:00:00"); 
			}catch(Exception ee){
				return  null;
			}
	}
	@SuppressWarnings("unchecked")
	public static  <T> T tryDynamicParse(String param,Class<T> c)
	{
		
		if(Double.class.equals(c))
		{
			
			return (T)(new Double(tryParseDouble(param)));
		}
		if(Date.class.equals(c))
		{
			return (T)(tryParseDate(param));
		}
		if(Integer.class.equals(c))
		{
			return (T)(new Integer(tryParse(param,2)));
		}
		if(String.class.equals(c))
		{
			return (T)param;
		}
		if(int.class.equals(c))
		{
			Integer i =new Integer(tryParse(param,10));
			return (T)i;
		}
		if(float.class.equals(c))
		{
			float res =tryParse(param);
			Float res2= new Float(res);
			return (T)res2;
			//return tryParse(param);
		}
		try{
		return c.cast(null);
		}catch(Exception e){
			return c.cast(-1);
		}
	}
}
