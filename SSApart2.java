
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
public void howMany(String stringa,String stringb)
{
    int pos=stringb.indexOf(stringa);
    int count=0;
    while(pos!=-1)
    {
        count=count+1;
        pos=stringb.indexOf(stringa,pos+stringa.length());
    }
    System.out.println("Count="+count);
}
public void test()
{
    howMany("ABC","ABCGHTSADHIJABCHASDNBAABCIASD");
}
}
