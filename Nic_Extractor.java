import java.util.Scanner;
public class Nic_Extractor {
    public static void main(String[] args){
        Scanner idnumber = new Scanner(System.in);
        System.out.println("\nHi , Using this simple program you can extract Birth of Date and gender from National Identy card of Srilanka(new)");
        System.out.println("\nEnter NIC number: ");
        String id = idnumber.nextLine();//user input nic number in string format
        String[] stringlist = new String[12];   //create a empty string list that length of 12
        char[] idu = id.toCharArray();  //at here id is splited into characters
        for (int i = 0;i<idu.length;i++){   //access every character in list idu
            String ch = Character.toString(idu[i]); //convert that character into string
            stringlist[i] = ch;   //assaign that converted string to the list stringlist
        }
        String year = stringlist[0]+stringlist[1]+stringlist[2]+stringlist[3]; //filter the year in string format
        String birthnum = stringlist[4]+stringlist[5]+stringlist[6];    //filter the birth number(xxx) in string format
        int yearint,birthnumint;    //initiate the integers of year and birthnumber
        yearint=Integer.valueOf(year);  //convert the year from string into integer
        birthnumint=Integer.valueOf(birthnum);// convert the birthnumber to integer
        String gender="Male"; //assaign gender male default
        if (birthnumint>=500){ //check birthnumber>=500
            gender = "Female";  // if yes update gender to female
            birthnumint-=500;   // if yes subract 500 from birthnumber bcz we had already find the gender
        }
        int month = 0;  
        int date = 0;
        int bn = birthnumint;   //assign a intger varible bn bcz we want to find the date of birth
        int[] months={31,29,31,30,31,30,31,31,30,31,30,31}; //days in every months
        String[] months_words = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        for (int j = 0;j<12;j++){   //access the months list
            if (bn<months[j]){  // if birthnumber (first time only birthnumber = bn) bn < 500 then 
                date=bn;    // thats the date
                month = j+1; // month is the count of iteration 
                break;  
            } else {
                bn-=months[j];  //if not subract total days of that month from bn
            }
        }
        String dates = Integer.toString(date);  //convert integer date into string bcz we want to concatenate
        String mon = Integer.toString(month); // like wise the date convertion at here its optional
        System.out.println("\nDate Of Birth is "+year+"-"+months_words[month-1]+"-"+dates);
        System.out.println("Gender is "+gender+"\n");
    }
}
//this simple program build by S.Vithurshan
// this is my first project in java 27/12/2023