package quize_application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Quiz_Application
{
	
	
	void question_bank() throws IOException//Create question-bank
	{
		 // Open the file in append mode.
        FileWriter fw = new FileWriter("question-bank.txt",true);
        PrintWriter out = new PrintWriter(fw);
        
        
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.println("Name of the question");
        String question=sc.nextLine();
   
        System.out.println("Provide value for the option 1");
        String option_1=sc.nextLine();
        System.out.println("Provide value for the option 2");
        String option_2=sc.nextLine();
        System.out.println("Provide value for the option 3");
        String option_3=sc.nextLine();
        System.out.println("Provide value for the option 4");
        String option_4=sc.nextLine();
        System.out.println("Provide option number for correct answer");
        int ans=sc.nextInt();
        
        
        out.println(question+","+option_1+"|"+option_2+"|"+option_3+"|"+option_4+"|"+ans);

        // Close the file.
        out.close();
	}
	void question_set() throws IOException//Enter n number of question in question bank
	{
		System.out.println("Enter the number question");
		Scanner sc=new Scanner(System.in);
		int ques=sc.nextInt();
		System.out.println();
		for(int i=1;i<=ques;i++)
		{
			question_bank();
			
			if(ques==i)
			{
				System.out.println("All question add successfully....!!!");
			}
		}
		System.out.println();
	}
	
	//Random function for question show random
	 public List<String> sampler (int reservoirSize) throws FileNotFoundException, IOException
	    {
	        String currentLine=null;
	        //reservoirList is where our selected lines stored
	        List <String> reservoirList= new ArrayList<String>(reservoirSize); 
	        // we will use this counter to count the current line number while iterating
	        int count=0; 

	        Random ra = new Random();
	        int randomNumber = 0;
	        Scanner sc = new Scanner(new File("question-bank.txt")).useDelimiter("\n");
	        while (sc.hasNext())
	        {
	            currentLine = sc.next();
	            count ++;
	            if (count<=reservoirSize)
	            {
	                reservoirList.add(currentLine);
	            }
	            else if ((randomNumber = (int) ra.nextInt(count))<reservoirSize)
	            {
	                reservoirList.set(randomNumber, currentLine);
	            }
	        }
	        return reservoirList;
	    }
	 
	 
	 //Quiz show for user
	 void start_quiz() throws IOException
	 {
		
	         String question;
	         int mark=0;
	         String[] str = null;
	         
	         
	         for(int index = 1;index<=10;index++)
	        {
	        	
	        	List<String> myList =sampler(1);
	        	String question1=myList.toString();
	        	str=question1.split(",");
	        	String[] str1=new String[1];
		        str1[0]=str[0];
		        String optionques = Arrays.toString(str1);
		        String replace1 = optionques.replace('[', ' ');
		        String ques=replace1.replace(']', ' ');
		       
		        System.out.println(ques+"?");
		        
		        
		        String[] str2=new String[1];
		        str2[0]=str[1];
		        
		        
		        String option = Arrays.toString(str2);
		    
		        String replace = option.replace('[', ' ');
		        String options=replace.replace(']', ' ');
		        
		        String[] values=options.split("\\|");
		       
		        
		        System.out.println("  a)"+values[0]);
		        System.out.println("  b) "+values[1]);
		        System.out.println("  c) "+values[2]);
		        System.out.println("  d) "+values[3]);
		        
		       
		        
		        //ans
		        String[] ans=new String[1];
		        ans[0]=values[4];
		        
		        String s=new String();
		        s=ans[0];
		       s = s.replaceAll("\\s", "");
		       
		        
		        
		        System.out.println("select correct option");
		        Scanner sc=new Scanner(System.in);
		        String op=sc.next();
		        
		        if(s.equals(op))
		        {
		        	 mark=mark+10;
		        	
		        	
		        }
		       
		        
		   
		        System.out.println();
	         }
	       
	        
	        System.out.println("You have score "+mark+" Do you want to continue?.");
	        Scanner sc=new Scanner(System.in);
	        String dec=sc.next();
	        System.out.println();
			switch(dec)
			{
			 case "yes":start_quiz();
				break;
			 case "no":System.out.println("Exit Application");
				 break;
			 	default:
			 			System.out.println("Invalid choice please select correct option");
			}
	        
	        
	      
	       
	   } 
	
	
	void enter_quiz() throws IOException
	{
		System.out.println("Welcome to the Quiz, Enter your below");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		System.out.println("Do you want to start with the Quiz?");
		String dec=sc.next();
		switch(dec)
		{
		 case "yes":start_quiz();
			break;
		 case "no":System.out.println("Exit Application");
			 break;
		 	default:
		 			System.out.println("Invalid choice please select correct option");
		}
	}
	
	
    public static void main(String[] args) throws IOException
    {
    	
    	Quiz_Application q=new Quiz_Application();
    	System.out.println("1.1 Create Quiz");
    	System.out.println("1.2 Start Quiz");
    	Scanner sc=new Scanner(System.in);
    	int ch=sc.nextInt();
    	switch (ch) {
    	  case 1:q.question_set();
    	  			break;
    	  case 2:
    	
    		  q.enter_quiz();
    	 
    	    break;
    	  default:
    	    System.out.println("Invalid choice please select correct option");
    	}
    	
       
    }
}