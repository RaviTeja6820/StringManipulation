
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part1 {
    public int findStopcodon(String dna,int startindex,String stopcodon)
    {
        int pos=dna.indexOf(stopcodon,startindex);
        if(pos==-1)
        return dna.length();
        while((pos-startindex)%3!=0)
        {
            pos=dna.indexOf(stopcodon,pos+1);
        }
        if(pos==-1)
        return dna.length();
        return pos;
    }
    public String findGene(String dna)
    {
        int index=dna.indexOf("ATG");
        if(index==-1)
        return "";
        int taaindex=findStopcodon(dna,index,"TAA");
        int tagindex=findStopcodon(dna,index,"TAG");
        int tgaindex=findStopcodon(dna,index,"TGA");
            System.out.println(taaindex);
            System.out.println(tgaindex);
            System.out.println(tagindex);
            int temp=Math.min(taaindex,tagindex);
            temp=Math.min(temp,tgaindex);
        return dna.substring(index,temp+3);
    }
    public void testfsc()
    {
        int index;
       String test1="ATGAGHGTHGHAGTAGHTTGAGHTTAAGHGTAGHAH";
       System.out.println(test1);System.out.println(test1.length());
       String result1=findGene(test1);
       System.out.println("the gene is "+result1);
       
       int index2;
       String test2="ATGAGHGTHGHAGTAGHTTGAGHTGHGTAGHAH";
       System.out.println(test2);System.out.println(test2.length());
       String result2=findGene(test2);
       System.out.println("the gene is "+result2);
    
       /*String test3="ATGAHGTHGHAGTAGHTTAAGHTGHAGHGAGAHAH";
       System.out.println(test3);System.out.println(test3.length());
       //String result3=findSimpleGene(test3,"ATG","TAA");
       //System.out.println(result3);
    
       String test4="ATGAGHGTHGHAGTAGHTTAAGHTGHAGHGAGAHAH";
       System.out.println(test4);System.out.println(test4.length());
       //String result4=findSimpleGene(test4,"ATG","TAA");
       //System.out.println("the gene is "+result4);*/
    }
}
