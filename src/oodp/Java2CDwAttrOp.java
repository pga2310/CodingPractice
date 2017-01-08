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
import java.util.regex.Pattern;

public class Java2CDwAttrOp {

    static PrintWriter write;
    static int count = 0;
    static String[] classlist = new String[25];
    static String line = "", currentClass = "", inClass = "";

    public static void main(String[] args) throws Exception {

        String filepath = "C:\\Users\\Pushpak\\Documents\\NetBeansProjects\\OODP\\src\\oodp\\Polymorph1.java";
        String output = "C:\\Users\\Pushpak\\Documents\\NetBeansProjects\\OODP\\src\\oodp\\outputAssignment2.txt";
        write = new PrintWriter(new FileWriter(output, true));
        write.println("Output:");
        write.println("------");
        classAttOp(filepath);

    }

    public static void classAttOp(String filepath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        write.println(" ");
        try {

            while ((line = br.readLine()) != null) {
                line.trim();
                String[] words = line.trim().split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals("class")) {
                        i++;
                        classlist[count] = words[i];
                        inClass = words[i];                     
                        count++;
                        if (count > 1) {
                            write.println("}");
                            write.println(" ");
                        }
                        write.println("class " + words[i] + " {");
                    }

                    if (words[i].equals("void")) {
                        {
                            String[] elem = words[i + 1].split(Pattern.quote("("));
                            write.println("" + elem[0] + "(): Void");
                        }
                    }

                    if (i < 2) {
                        if (words[i].equals("int")) {
                            if (words[i + 1].contains("(")) {
                                String[] elem = words[i + 1].split(Pattern.quote("("));
                                write.println("+" + elem[0].replace(";", " ") + "(): int");
                            } else {
                                write.println("-" + words[i + 1].replace(";", " ") + ": int");
                            }
                        }
                    }

                }
                String[] elem = words[0].split(Pattern.quote("("));
                if (elem[0].equals(inClass) && inClass!="") {
                    write.println("" + elem[0] + "():");
                }
            }
            write.println("}");

        } catch (Exception e) {
            System.out.println(e);

        }
        br.close();
        
        classRelation(filepath);
    }

    public static void classRelation(String filePath) throws Exception {
        write.println("\n");
        int j = 0;
        while (classlist[j] != null) {
            j++;
        }
        BufferedReader br1 = new BufferedReader(new FileReader(filePath));
        while ((line = br1.readLine()) != null) {
            line.trim();
            String[] words = line.trim().split(" ");

            for (int i = 0; i < words.length; i++) {
                if (words[i].equals("class")) {
                    i++;
                    currentClass = words[i];
                    i++;
                    if (words[i].equals("extends"))
                    {
                        i++;
                        write.println(words[i] + " <|-- " + words[i - 2]+":Inheritance");
                    } else if (words[i].equals("implements"))
                    {
                        write.print(words[i - 1]);
                        i++;
                        write.println(" ...|> " + words[i]);
                    }
                }
            }
            for (int i = 0; i < j; i++) {
                if ((words[0].equals(classlist[i])))
                {
                    write.println(currentClass + " ---> " + words[0]);
                }
            }
        }
        write.close();
        br1.close();
        System.out.println("Output is written in outputAssignment2.txt file");

    }
}
