/* This program takes a HEX String from the command line 
   and converts it to binary
   then it splits the binary form into specific number of bits
   to make up the virtual memory and finding RX,SX,PX,BX.

Author: Atef Yassine
Date: 02/08/2019.
Class: Intro to enterprise.
*/

import java.util.*;
import java.math.*;

class AddressMapping {

//Convert hex to binary
static String hexToBin(String s) {
  return new BigInteger(s, 16).toString(2);
}

//Convert binary to hex
static String BinToHex(String s) {
  return new BigInteger(s, 2).toString(16);
}

//Reverses a string for manipulation purposes.
static String Reverse(String str){
	String reverse="";
        for(int i = str.length() - 1; i >= 0; i--)
        {
            reverse = reverse + str.charAt(i);
        }
		return reverse;
}


  public static void main(String[] args) {

    String hex_1="";
    
  //Takes in argument from the command-line, argument should be like (with quotes) "AA BB CC DD EE FF 11 22"
	for(int i = 0; i<args.length; i++){
	hex_1 = args[i];
	}
    
    //Takes out all the spaces from the string provided in the command line.
    String hex = hex_1.replaceAll(" ",""); 

    //Converts the HEX provided to Binary
    String bin = hexToBin(hex);
	  
	  
    //Splits the binary into the needed format. RX: 33 bits, SX: 11 bits, PX: 8 bits, BX: 12 bits.
    String RX = bin.substring(bin.length()-33);

    String SX = bin.substring(20,31);

    String PX = bin.substring(12,20);

    String BX = bin.substring(0,12);


    System.out.println("");
    System.out.println("Input address: " + hex_1);
    System.out.println("");

    /*From now on, I change back to Hex, reverse the letters,
     put spaces every 2 HEX characters and reverse back and print them off
     with upper cases. */
    RX = BinToHex(RX);
    RX = Reverse(RX);
    RX = RX.replaceAll("..(?!$)", "$0 ");
    RX = Reverse(RX);
    System.out.println("Region index \tRX = " + RX.toUpperCase());


    SX = BinToHex(SX);
    SX = Reverse(SX);
    SX = SX.replaceAll("..(?!$)", "$0 ");
    SX = Reverse(SX);
    System.out.println("Segment index \tSX = " + SX.toUpperCase());


    PX = BinToHex(PX);
    PX = Reverse(PX);
    PX = PX.replaceAll("..(?!$)", "$0 ");
    PX = Reverse(PX);
    System.out.println("Page index \tPX = " + PX.toUpperCase());


    BX = BinToHex(BX);
    BX = Reverse(BX);
    BX = BX.replaceAll("..(?!$)", "$0 ");
    BX = Reverse(BX);
    System.out.println("Page offset \tBX = " + BX.toUpperCase());
  }

}
