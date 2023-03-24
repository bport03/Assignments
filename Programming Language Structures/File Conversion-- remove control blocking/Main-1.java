package SQL;


import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // open files and create a new file
            FileReader input=new FileReader("control-char.txt");
            Scanner s = new Scanner(input);
            FileWriter out= new FileWriter("outcome.txt");
            boolean inc=false;
            boolean outc=false;
            String line;
            // loop throught the file and check for control c and control b
            while (s.hasNextLine()){
                line=s.nextLine();
                int length = line.length();

                for (int i =0 ; i < length;i++){
                    if( (int)line.charAt(i)==3 && inc==false){
                        inc=true;
                        outc=false;
                    }
                    if((int)line.charAt(i)==2 && inc==true){
                        inc=false;
                        outc=true;
                    }
                    if(inc == false && outc==false){

                            out.write(line.charAt(i));

                    }
                    if(outc == true){
                        outc=false;

                    }
                }
                if(inc==false){
                    out.write("\n");
                }

            }
            input.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}
