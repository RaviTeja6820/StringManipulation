
/**
 * Write a description of part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
public class part3 {
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
    public String findGene(String dna,int pos)
    {
        int index=dna.indexOf("ATG",pos);
        if(index==-1)
        return "";
        int taaindex=findStopcodon(dna,index,"TAA");
        int tagindex=findStopcodon(dna,index,"TAG");
        int tgaindex=findStopcodon(dna,index,"TGA");
            int temp=Math.min(taaindex,tagindex);
            temp=Math.min(temp,tgaindex);
        return dna.substring(index,temp+3);
    }
    public void countgenes(String dna)
    {
        int count=0;
        String gene=findGene(dna,0);
        if(gene=="")
        System.out.println("count="+count);
        while(gene!="")
        {
            count+=1;
            System.out.println(gene);
            gene=findGene(dna,(dna.indexOf(gene)+gene.length()));
        }
        System.out.println("count= "+count);
    }
    public void test()
    {
        String dna="ATGGHTFDTBJUAUHTAAHJIATGHJUKIJTGADFGATGGHYTAAJKI";
        countgenes(dna);
    }
}
