import java.util.*;
import java.io.*;
public class VaccineArrayApp  {
public static VaccineArray Vaccines[] = new VaccineArray[9919];
public static String country;
public static String date;
public static String[] coun_date = new String[1000];
public static String[] arraycountry = new String[1000];
public static String noOfVacc;
public static int iterations = 0;
public static int iterations2 =0;
//public static VaccineBSTApp vaccinefiles = new VaccineBSTApp();
public static int bestcase,worstcase; 

/*
   This class is used to print out all the country names and their vaccination numbers
   It uses the object Vaccines to access the required information
   It compares the given data by the user to the values in the cvs file that are now stored in a traditional Array
**/
public static String printAllresults(String place,String date){ 
   String result = "";
   boolean Found = false;
   for(int b=0;b < 9918;b++){
      //iterations++;
      if(((Vaccines[b].getcountry() + Vaccines[b].getdate()).equals(place + date))){
           //System.out.println(Vaccines[b].printAll());
           result = Vaccines[b].printAll();
           Found = true;
     }
 }
      if (Found == false){
        result = place + " = <Not Found>";
     }
     
     return result;
}

/*
  This method is used to determine the number of iterations it takes for the traditional array to find the given ]
  combinations of country + date.
  The result is the iterations for each country and the country name.s   
*/

public static String printComparisons(String place,String date){ 
   iterations = 0;
   String result = "";
   boolean Found = false;
   for(int b=0;b < 9918;b++){
      iterations++;
      if(((Vaccines[b].getcountry() + Vaccines[b].getdate()).equals(place + date))){
           iterations2 = iterations;
           iterations =0; 
           result = ("There are  "+iterations2 + " iterations for "+ Vaccines[b].getcountry());
           Found = true;
     }
 }
      if (Found == false){
         result = place + " = <Not Found>";
     }
     
     return result;
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
         int smallest = 100;
         int biggest = 1000;
         int  max=subset;
         int    min=1;
         int  n_subset=min+ randNum.nextInt(max);
         for(int p=0;p<subset -1;p++){
         		  int l=n_subset;  
           if (l+p > 9917){
            System.out.println("Number of lines exceeded");
            break;
           }else{    
              System.out.println(printComparisons(Vaccines[l+p].getcountry(),sDate));  
              opCount = opCount + iterations;
        	     sampledata.println(printComparisons(Vaccines[l+p].getcountry(),sDate));
              if (smallest > iterations){
                  smallest = iterations;
              } //end of if
              if(biggest < iterations){
                  biggest = iterations;
              }
				 }
            } 
             
             average  = (opCount / subset);
             System.out.println("The average case is " + average +" |The worst case is "+biggest + " |And the best case is "+ smallest) ; 
             sampledata.println("The average case is " + average +" |The worst case is "+biggest + " |And the best case is "+ smallest); 
            return ("The average case " + average +" " +opCount +" "+ subset);
   }
   

   /**
   This method is used to create 10 different textfiles named from sample1.txt to sample10.txt to store the results from
   calculating the iterations required to find the country + date combinations for each of the 10 different subset values.
   The method then calls the calculatesubsets method to write the results to the 10 different textfiles for the 10 different subsets
   There is only one argument, it is the date
 */
    public static void createFiles(String date) throws IOException{
     FileWriter file1 = new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/Sample1.txt"));
     FileWriter file2 = new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/Sample2.txt"));
     FileWriter file3 = new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/Sample3.txt"));
     FileWriter file4 = new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/Sample4.txt"));
     FileWriter file5 = new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/Sample5.txt"));
     FileWriter file6 = new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/Sample6.txt"));
     FileWriter file7 = new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/Sample7.txt"));
     FileWriter file8 = new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/Sample8.txt"));
     FileWriter file9 = new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/Sample9.txt"));
     FileWriter file10 = new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/Sample10.txt"));
     
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
      
      sample1.close();
      sample2.close();
      sample3.close();
      sample4.close();
      sample5.close();
      sample6.close();
      sample7.close();
      sample8.close();
      sample9.close();
      sample10.close();
     }
     
     
     /*
     This is the main method of the VaccineArrayApp
     **/
public static void main(String[] args) throws IOException{
    FileWriter writeFile1=new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/FirstTest.txt"),true);
    FileWriter writeFile2=new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/SecondTest.txt"),true);
    FileWriter writeFile3=new FileWriter(new File("C:/UCT/CSC2001F/Assignments/Assignment1/Arraytextfile/ThirdTestwithInvalidValues.txt"),true);
            
    PrintWriter firstTest=new PrintWriter(writeFile1);
	 PrintWriter SecondTest=new PrintWriter(writeFile2);
    PrintWriter ThirdTest=new PrintWriter(writeFile3);
             
   String Country,Date;
   String noOfVaccines;
   String[] Count_Date = new String[1000];
   String[] array = new String[10000];
   File textfile = new File("C:/UCT/CSC2001F/Assignments/Assignment1/vaccinations.csv");
   Scanner keyboard = new Scanner(System.in);
  
   Scanner inputStream = new Scanner(textfile);
   inputStream.nextLine();
      
   int count = 0;
   while(inputStream.hasNext()){
    
      Arrays.fill(array, ""); 
      String line1 = inputStream.nextLine();
      array = line1.split(",",-1);
   
      country = array[0];
      date = array[1];
      noOfVacc = array[2];
      
      Vaccines[count] = new VaccineArray(country,date,noOfVacc); 
      count++; 
   }
   
   System.out.println("Enter the date: ");
   Date = keyboard.nextLine();
   
   System.out.println("Enter the list of countries (end with an empty line): ");
   Country = "";
   int counter = 0;
   while(keyboard.hasNextLine()){
         Country = keyboard.nextLine();
         if (Country.equals(""))
         break;
         arraycountry[counter]  = Country;
         counter++;
      }
        
      System.out.println("Results");
      for(int b = 0;b<counter;b++){
        printAllresults(arraycountry[b],Date);
        firstTest.println(printAllresults(arraycountry[b],Date));
      }
      
 
       firstTest.close();
       SecondTest.close();
       ThirdTest.close();
       
       createFiles(Date); 
 }

}

