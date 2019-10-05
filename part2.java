
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.StorageResource;
import edu.duke.FileResource;
import java.io.*;
public class part2 {
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
            if(temp==-1)
            temp=Math.max(taaindex,tagindex);
            int temp2=Math.min(temp,tgaindex);
            if(temp2==-1)
            temp2=Math.max(temp,tgaindex);
        return dna.substring(index,temp2+3);
    }
    public StorageResource getAllgenes(String dna)
    {
        StorageResource sr=new StorageResource();
        String gene=findGene(dna,0);
        while(gene!="")
        {
            sr.add(gene);
            gene=findGene(dna,(dna.indexOf(gene)+gene.length()));
        }
        return sr;
    }
    public double cgRatio(String dna)
    {
        double countC,countG,cgR;
        int posC,posG;
        countC=0;countG=0;posC=0;posG=0;
        posC=dna.indexOf("C",posC);
        while(posC!=-1)
        {
            countC+=1;
            posC=dna.indexOf("C",posC+1);
        }
        posG=dna.indexOf("G",posG);
        while(posG!=-1)
        {
            countG+=1;
            posG=dna.indexOf("G",posG+1);
        }
        cgR=(double)((countC+countG)/dna.length());
        return cgR;
    }
    public void test()
    {
        int countn=0,counts=0,countcg=0,tempprev=0,tempnew=0;
        String greatest="";
        FileResource fr=new FileResource("brca1.fa");
        String dna=fr.asString();
        //String dna="atgcctttgtaahtaatghtaatgccttaattgtaahtaatghtahtatga";
        //String dna="";
        dna=dna.toUpperCase();
        System.out.println(dna);
        System.out.println("Cgratio of dna="+cgRatio(dna.toUpperCase()));
        //StorageResource sr=getAllgenes(dna.toUpperCase());
        String gene=findGene(dna,0);
        while(gene!="")
        {
            //System.out.println(gene);
            gene=findGene(dna,(dna.indexOf(gene)+gene.length()));
            tempnew=gene.length();
            if(tempnew>tempprev)
            greatest=gene;
            if(tempnew>9)
            {
                countn+=1;
            }
            if(tempnew>60)
            {
                counts+=1;
            }
            if((cgRatio(gene))>0.35)
            {
                countcg+=1;
            }
            tempprev=gene.length();
        }
        //StorageResource cg=new StorageResource();
        //StorageResource g9=new StorageResource();
        //StorageResource g60=new StorageResource();
        /*for(String str:sr.data())
        {
            tempnew=str.length();
            System.out.println(str);
            if(tempnew>tempprev)
            greatest=str;
            if(tempnew>9)
            {
                countn+=1;
                //g9.add(str);
                System.out.println(str);
            }
            if(str.length()>60)
            {
                counts+=1;
                //g60.add(str);
                System.out.println(str);
            }
            if((cgRatio(str))>0.35)
            {
                //cg.add(str);
                countcg+=1;
                System.out.println(str);
            }
            tempprev=str.length();
        }*/
        System.out.println("count9 ="+countn);
        /*for(String str:g9.data())
        {
            System.out.println("String that are greater than 9");
            System.out.println(str);
        }*/
        System.out.println("count60 ="+counts);
        /*for(String str:g60.data())
        {
            System.out.println("String that are greater than 60");
            System.out.println(str);
        }*/
        System.out.println("countcg ="+countcg);
        /*for(String str:cg.data())
        {
            System.out.println("String that have greater cg than 0.35");
            System.out.println(str);
        }*/
        System.out.println("greatest ="+greatest+"   length"+greatest.length());
    
    }
}
