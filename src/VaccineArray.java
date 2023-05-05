public class VaccineArray{
  String country;
  String date;
  String noOfVacc;
  
  public VaccineArray(){}
  
  public VaccineArray(String country, String date, String noOfVacc){
   this.country = country;
   this.date = date;
   this.noOfVacc = noOfVacc;
  }
  
  public String getcountry(){
   return country;
  }
  
  public String getdate(){
   return date;
  }
  
  public String getnoOfVacc(){
   return noOfVacc;
  }
 
 /*
 This is a method to print out the country and its vaccination number for a given date
 **/
  public String printAll(){
   return (country + " = "+ noOfVacc );
  }
  
  
}