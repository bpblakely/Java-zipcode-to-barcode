import java.util.Scanner;

public class Main {
    final static Scanner cin = new Scanner(System.in);
    final static String[] BarCodes = {"||:::", ":::||", "::|:|", "::||:",
        ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"
    };

    public static void main(String[] args) {
        System.out.println("Brian Blakely Assignment 04");
        desc();
        String quit="Quit";
        String zipcode= getDigits("Enter a 5 digit zip code (enter Quit to end): ");
        while(!zipcode.equalsIgnoreCase(quit)){
            if(!isValidZip(zipcode)){
                zipcode= getDigits("Enter another 5 digit zip code (enter Quit to end): ");
            }
            try{
            	printBarCode(zipcode);
            } catch(Exception e) {
            	System.out.println("Error in zipcode format");
            }
            zipcode= getDigits("Enter another 5 digit zip code (enter Quit to end): ");
        }
        System.out.println("Assignment 04 complete");
    } // end main
    
    static void printBarCode(String zipcode) {
        // print first framing bar and a space
        
        System.out.print("| ");
        for(int x=0;x<5;x++){
            char c= zipcode.charAt(x);
            printDigit(char2int(c));
            
        }
        
        System.out.println('|');
    } // end method
    
    static void printDigit(int digit) {
        // TODO: print the appropriate bar code and a space
    	System.out.print(BarCodes[digit]+" ");
    } // end method
    
    static boolean isValidZip(String zip) {
        // TODO: check length, return false if not 5 characters
        if (zip.length()!=5){
            invalid("A valid zipcode has 5 digits");
            return false;
        }
        for(int x=0;x<5;x++){
            if(!Character.isDigit(zip.charAt(x))) {invalid("A valid zipcode contains no non-digit characters. The character at position "+(x+1)+" is invalid"); return false;}
        }
        return true;
    } // end function

    private static int char2int(char c) {
        if (! java.lang.Character.isDigit(c))
            terminate("char2int: argument is not a digit character");
        return (int) c - (int) '0';
    }

    private static void terminate(String message) {
    	System.out.println(message + "\nProgram terminated");
        System.exit(1);
    }
    static void desc(){
    	System.out.println("The purpose of this program is to translate 5 digit zip codes to bar codes where full height bars are printed as | and half height bars are printed as :");
    }
    static void invalid(String reason){
    	System.out.println("The zip code was invalid, thus no bar code was printed");
    	System.out.println(reason);
    }
    static String getDigits(String prompt){
    	System.out.print(prompt);
        return cin.next();
    }

}
