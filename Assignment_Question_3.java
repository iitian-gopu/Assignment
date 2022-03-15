import java.io.*;
import java.util.*;

public class Assignment_Question_3{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

int ans=calculate(exp);
System.out.println(ans);
 }


//This String can take character '(',')','+','-','*','/' and number with one or more than one Digit
//Input:-(1+(400+500+222)-3)+(6*8)+(10/2)

   public static int calculate(String s) {
        Stack<Character>charst=new Stack<>();
        Stack<Integer>intst=new Stack<>();
        for(int i=0;i<s.length();){
            
           
//To solve opening Bracket
          if(s.charAt(i)=='('){
             
                charst.push(s.charAt(i));
               i++;
            }


           //to solve number area 
              else if(Character.isDigit(s.charAt(i))){
                int val=0;
                while(i<s.length()&&Character.isDigit(s.charAt(i))){
                    val=val*10+s.charAt(i)-'0';
                    i++;
                }
                intst.push(val);
            }
            
          // To solve Operator area  
            else if(isOperator(s.charAt(i))){
                
                while(charst.size()>0&&charst.peek()!='('&&precedence(s.charAt(i))<=precedence(charst.peek())){
                    char operator=charst.pop();
                    int val2=intst.pop();
                    int val1=intst.pop();
                    int cal=helper(val1,val2,operator);
                    intst.push(cal);
                     
                    
                }
                          

                charst.push(s.charAt(i));
                      i++;
            }
                      
        //To solve char==')'  
            else if(s.charAt(i)==')'){
                while(charst.size()>0&&charst.peek()!='('){
                     char operator=charst.pop();
                      int val2=intst.pop();
                    int val1=intst.pop();
                    int cal=helper(val1,val2,operator);
                    intst.push(cal);
                }
                charst.pop();
                i++;
            }
            
        //to solve other than opertor,brackets,and number
            else{
                
                i++;
            }
        }
        
        
        while(charst.size()>0){
             char operator=charst.pop();
              int val2=intst.pop();
                    int val1=intst.pop();
                    int cal=helper(val1,val2,operator);
                    intst.push(cal);
        }

         
        return intst.pop();
    }


//function to give precedence of operator:-  First higher or equal precednce operator will solve
    public static int precedence(char ch){
        if(ch=='+'||ch=='-')return 1;
        return 2;
    }


 //Function for checking ('+','-','/','/')   
    public static boolean isOperator(char ch){
        if(ch=='+'||ch=='-'||ch=='*'||ch=='/')return true;
        return false;
    }



//Function for evaluation of two numbers
    public static int helper(int val1,int val2,char ch){
        if(ch=='+'){
            return val1+val2;
        }
        else if(ch=='-'){
            return val1-val2;
        }
        else if(ch=='*'){
            return val1*val2;
        }
        else{
            return val1/val2;
        }
    }



}
