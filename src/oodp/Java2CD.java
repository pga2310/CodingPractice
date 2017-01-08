/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodp;

/**
 *
 * @author Pushpak
 */
import java.io.*;

public class Java2CD {

    static int count = 0;
    static String line = "", currentClass = "", cntClass = "";
    static String[] classList = new String[25];

    public static void classRelation(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            PrintWriter write = new PrintWriter(new FileWriter("C:\\Users\\Pushpak\\Documents\\NetBeansProjects\\OODP\\src\\oodp\\output.txt", true));
            write.println("\nOutput");
            write.println("---------");
            write.println(" ");
            while ((line = br.readLine()) != null) {
                line.trim();
                String[] words = line.trim().split(" ");

                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals("class")) {
                        i++;
                        classList[count] = words[i];
                        count++;
                        i++;
                        if (words[i].equals("extends")) {                      
                            i++;
                            write.println(words[i] + " <|--- " + words[i - 2] + ":Inheritance");
                        } else if (words[i].equals("implements")) {
                            write.print(words[i - 1]);
                            i++;
                            write.println(" ......|> " + words[i]);
                        }
                    }
                }
            }

            int j = 0;
            while (classList[j] != null) {
                j++;
            }

            BufferedReader br1 = new BufferedReader(new FileReader(filePath));
            while ((line = br1.readLine()) != null) {
                line.trim();
                String[] words = line.trim().split(" ");
                if (words.length > 3) {
                    for (int i = 0; i < 3; i++) {
                        if (words[i].equals("class")) {
                            currentClass = words[i + 1];
                        }
                    }
                    for (int i = 0; i < j; i++) {
                        if ((words[0].equals(classList[i]))) {
                            write.println(currentClass + " -----> " + words[0]);
                        }
                    }
                }
            }

            write.close();
            br.close();

            System.out.println("Output is written in Output.txt file");

        } catch (Exception e) {
            e.printStackTrace();
        }
    

}

public static void main(String[] args) throws Exception {

        String filepath = "C:\\Users\\Pushpak\\Documents\\NetBeansProjects\\OODP\\src\\oodp\\Polymorph1.java";
        classRelation(filepath);
    }

}
