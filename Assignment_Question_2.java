
import java.util.*;
public class Assignment_Question_2
{
  public static void main (String[]args)
  {
    Scanner sc = new Scanner (System.in);
    int num = sc.nextInt ();
    String roman = convert_IntegerTo_Roman (num);
      System.out.println (roman);
  }
  //Till Now this function support 1 to 3999 Integer but this function is scalable.
  public static String convert_IntegerTo_Roman (int num)
  {

    //for Mapping purpose int to string 
    HashMap < Integer, String > hmap = new HashMap <> ();
    hmap.put (1, "I");

    hmap.put (4, "IV");
    hmap.put (5, "V");

    hmap.put (9, "IX");
    hmap.put (10, "X");


    hmap.put (40, "XL");
    hmap.put (50, "L");


    hmap.put (90, "XC");
    hmap.put (100, "C");

    hmap.put (400, "CD");
    hmap.put (500, "D");

    hmap.put (900, "CM");
    hmap.put (1000, "M");

//subtract the num with higher arr[i] till arr[i]->num>=0 if(num==0) then break otherwise 
//chhose another arr[i]
    int[] arr = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    StringBuilder sb = new StringBuilder ();

    while (num > 0)
      {
	for (int i = 0; i < arr.length && num > 0; i++)
	  {
	    while (num > 0 && num - arr[i] >= 0)
	      {
		sb.append (hmap.get (arr[i]));
		num -= arr[i];
	      }
	  }
      }
    return sb.toString ();
  }
}

