/*

You don't need to type 'www.' to open a website anymore.
Though, you still need to type '.com' to open a website.
The browser predicts ALL THE VOWELS in the name of the website. (Not '.com',)
Obviously, this means you can type the name of a website faster and save some time.
Now to convince users that his browser will indeed save A LOT of time for users to open a particular website, prepare a report on the same.

Input format:
The first line contains tc, the number of test cases.
The second line contains the name of websites, as a string.

Output format:
You have to print the ratio of characters you would have typed in your browser, to your normal browser.

Constraints:
1 <= tc <= 100
1 <= Length of the website <= 200

AMPLE INPUT 
2
www.google.com
www.hackerearth.com

SAMPLE OUTPUT 
7/14
11/19

*/

import java.io.BufferedReader;

import java.io.InputStreamReader;



class BestInternetBrowser 
{
    
 public static void main(String qq[]) throws Exception 
  {

        
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
   int t = Integer.parseInt(br.readLine());
         
   while(t-- > 0){

             String url=br.readLine();

             int L1=url.length();

             String replace=url.replaceAll("[aeiou]", "");

             int L2=replace.length()-3;

             System.out.println(L2+"/"+L1);

    }
    
  }

}