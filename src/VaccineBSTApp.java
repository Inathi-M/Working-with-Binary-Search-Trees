import java.util.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;
public class VaccineBSTApp{
   public static BinarySearchTree<String> BST;
   public static BinarySearchTree<String> country;
     
   public static BinarySearchTree bstree =new BinarySearchTree();
   public static String[] arrCountry = new String[10000];
   public static String[] arrDate = new String[10000];
   public static String[] arrnoOfVacc = new String[10000];
   public static String[] arrCoun_Date = new String[10000]; 
   public static String[] arraycountry = new String[1000];
   public static String[] arrT = new String[10000];
   public static int bestcase,worstcase; 
   
   
   
/*
   This class is used to print out all the country names and their vaccination numbers
   It uses the object Vaccines to access the required information
   It compares the given data by the user to the values in the cvs file that are now stored in a traditional Array
**/  
   public static String printResults(String place, String day,BinaryTreeNode<String> rootNode) throws NullPointerException{
      String result = "";
      BinaryTreeNode<String> BTN = country.find(place,rootNode);
      if (BTN == null){
            result = place + " = <Not Found>";
      }
      
      boolean check = false;
      try{
      String data = BTN.getData();

      for(int a = 0;a < 9918;a++){
         if((arrCountry[a] + arrDate[a]).equals(data + day)){
             check = true;
             result = (arrCountry[a] + " = "+ arrnoOfVacc[a] );
         }
      }
      
      
      if(check == false){
         result = (place + " = <Not Found>");
      }
      
      return result;
      
      }catch(Exception e){
            return result;
      }
   }
   
   
 /*
  This method is used to determine the number of iterations it takes for the traditional array to find the given ]
  combinations of country + date.
  The result is the iterations for each country and the country name.s   
*/
      public static String printComparisons(String place, String day,BinaryTreeNode<String> rootNode,int SampleSize) throws NullPointerException{
      int averagecase = 0;
      String result = "";
      BinaryTreeNode<String> BTN = country.find(place,rootNode);
      if (BTN == null){
            result = place + " = <Not Found>";
      }
      
      boolean check = false;
      try{
      String data = BTN.getData();
      bestcase = bstree.OperationsCount();
      for(int a = 0;a < 9918;a++){
         if((arrCountry[a] + arrDate[a]).equals(data + day)){
             check = true;
             result = ("There are  "+bstree.OperationsCount() + " iterations for "+ arrCountry[a] );
                  if(bestcase > bstree.OperationsCount())
                   bestcase = bstree.OperationsCount(); 
                  
                  if(worstcase < bstree.OperationsCount())
                   worstcase = bstree.OperationsCount();
         }
      }
      
      if(check == false){
         result = (place + " = <Not Found>");
      }
      return result;
      
      }catch(Exception e){
            return result;
      }
   }

/*
   This method is used to test the traditional array using 10 different subsets of values that are spaced equally apart.
   For each subset of values the number of iterations required to find the country + date combination is given
   The best case, the worst case and the aveage case is determined for each seperate subset
   Each result is written to a separate textfile ranging from sample1 to sample10 for the 10 substet values.
   The method also takes in the subset value, the Date and the PrintWriter file as arguments.
**/      
      public static String calculatesubsets(int subset,String sDate,PrintWriter sampledata){  
         Random randNum=new Random();        
         int opCount = 0;
         int average = 0;   
         int smallest = country.OperationsCount();
         int biggest = country.OperationsCount();
         int  max=subset;
         int    min=1;
         int  n_subset=min+ randNum.nextInt(max);
         for(int p=0;p<subset -1;p++){
         		  int l=n_subset;  
           if (l+p > 9917){
            System.out.println("Number of lines exceeded");
            break;
           }else{    
              System.out.println(printComparisons(arrT[l+p],sDate,country.root,subset));
              
              opCount = opCount + country.OperationsCount();
        	     sampledata.println(printComparisons(arrT[l+p],sDate,country.root,subset));
              if (smallest > country.OperationsCount()){
                  smallest = country.OperationsCount();
              } //end of if
              if(biggest < country.OperationsCount()){
                  biggest = country.OperationsCount();
              }
				 }
            } 
             
             average  = (opCount / subset);
             System.out.println(average);
             System.out.println("The average case is" + average +"|The worst case is "+biggest + "|And the best case is "+ smallest) ; 
             sampledata.println("The average case is" + average +"|The worst case is "+biggest + "|And the best case is "+ smallest); 
            return ("The average case " + average +" " +opCount +" "+ subset);
   }
   
/**
   This method is used to create 10 different textfiles named from sample1.txt to sample10.txt to store the results from
   calculating the iterations required to find the country + date combinations for each of the 10 different subset values.
   The method then calls the calculatesubsets method to write the results to the 10 different textfiles for the 10 different subsets
   There is only one argument, it is the date
 */
    public static void createFiles(String date) throws IOException{
     
     FileWriter w=new FileWriter(new File("first_BSTAnd_Comparison.txt"),true);
     
     PrintWriter first_subset=new PrintWriter(w);
     
	     
     FileWriter file1 = new FileWriter(new File("D:/Assignment1/BSTtextfile/Sample1.txt"));
     FileWriter file2 = new FileWriter(new File("D:/Assignment1/BSTtextfile/Sample2.txt"));
     FileWriter file3 = new FileWriter(new File("D:/Assignment1/BSTtextfile/Sample3.txt"));
     FileWriter file4 = new FileWriter(new File("D:/Assignment1/BSTtextfile/Sample4.txt"));
     FileWriter file5 = new FileWriter(new File("D:/Assignment1/BSTtextfile/Sample5.txt"));
     FileWriter file6 = new FileWriter(new File("D:/Assignment1/BSTtextfile/Sample6.txt"));
     FileWriter file7 = new FileWriter(new File("D:/Assignment1/BSTtextfile/Sample7.txt"));
     FileWriter file8 = new FileWriter(new File("D:/Assignment1/BSTtextfile/Sample8.txt"));
     FileWriter file9 = new FileWriter(new File("D:/Assignment1/BSTtextfile/Sample9.txt"));
     FileWriter file10 = new FileWriter(new File("D:/Assignment1/BSTtextfile/Sample10.txt"));
     
     PrintWriter sample1=new PrintWriter(file1);
     PrintWriter sample2=new PrintWriter(file2);
     PrintWriter sample3=new PrintWriter(file3);
     PrintWriter sample4=new PrintWriter(file4);
     PrintWriter sample5=new PrintWriter(file5);
     PrintWriter sample6=new PrintWriter(file6);
     PrintWriter sample7=new PrintWriter(file7);
     PrintWriter sample8=new PrintWriter(file8);
     PrintWriter sample9=new PrintWriter(file9);
     PrintWriter sample10=new PrintWriter(file10);
   
// This is the first subset 991           
    calculatesubsets(991,date,sample1);
//This is the second subset 1982
    calculatesubsets(1982,date,sample2);
//This is the third subset 2973
    calculatesubsets(2973,date,sample3);
//This is the fourth subset 3964
    calculatesubsets(3964,date,sample4);
//This is the fifth subset 4955
    calculatesubsets(4955,date,sample5);;     
//This is the fifth subset 5946
    calculatesubsets(5946,date,sample6);
//This is the fifth subset 6937
    calculatesubsets(6937,date,sample7);        
 //This is the fifth subset 7928
    calculatesubsets(7928,date,sample8);        
//This is the fifth subset 8919
    calculatesubsets(8919,date,sample9);
//This is the fifth subset 9910
    calculatesubsets(9910,date,sample10);    
                       
      first_subset.close();
      sample1.close();
      sample1.close();
      sample3.close();
      sample4.close();
      sample5.close();
      sample6.close();
      sample7.close();
      sample8.close();
      sample9.close();
      sample10.close();
     }
     

   
    public static void main(String[] args) throws IOException{
            FileWriter writeFile1=new FileWriter(new File("D:/Assignment1/BSTtextfile/FirstTest.txt"),true);
            FileWriter writeFile2=new FileWriter(new File("D:/Assignment1/BSTtextfile/SecondTest.txt"),true);
            FileWriter writeFile3=new FileWriter(new File("D:/Assignment1/BSTtextfile/ThirdTestwithInvalidValues.txt"),true);
            
            PrintWriter firstTest=new PrintWriter(writeFile1);
	         PrintWriter SecondTest=new PrintWriter(writeFile2);
            PrintWriter ThirdTest=new PrintWriter(writeFile3); 
            
            String sDate,sCountry;
            Scanner input = new Scanner(System.in);
            BST = new BinarySearchTree<String>();
            
            country = new BinarySearchTree<String>();
            File textfile = new File("D://Assignment1/vaccinations.csv");

            Scanner inputstream = new Scanner(textfile);
            inputstream.nextLine();
            
            
            
            int counter = 0;
            while(inputstream.hasNext()){
              String line[] = inputstream.nextLine().split(",",-1);
              
              String acountry = line[0];
              String date = line[1];
              String noOfVacc = line[2];
              
              String set_to_BST = (country +" "+date+" "+noOfVacc);
              
              String place = acountry;
              BST.insert(set_to_BST);
              
              country.insert(place);
              
              arrCountry[counter]= acountry;
              arrDate[counter] = date;
              arrnoOfVacc[counter] = noOfVacc;
              counter++;
            }
            
             System.out.println("Enter the date: ");
             sDate = input.nextLine();
               
             System.out.println("Enter the list of countries (end with an empty line): ");
             sCountry = "";
             int count = 0;
             while(input.hasNextLine()){
               sCountry = input.nextLine();
               if(sCountry.equals(""))
               break;
               arraycountry[count] = sCountry;
               count++;
             }
             
            System.out.println("Results");
           for(int b = 0;b<count;b++){
           // System.out.println(printResults(arraycountry[b],sDate,country.root));
            //SecondTest.println(printResults(arraycountry[b],sDate,country.root));
           }
           
      firstTest.close();
      SecondTest.close();
      ThirdTest.close();
           
       String fileNamed=("D:/Assignment1/vaccinations.csv");
       File file= new File(fileNamed);
       Scanner inputStream=new Scanner(file);
       inputStream.nextLine();
       
       int counterT=0;
       while(inputStream.hasNextLine()){
       String line1=inputStream.nextLine();
        String [] a=line1.split(",",-1);

         arrT[counterT++]=a[0];       
         }
         
         createFiles(sDate);        
    }
}