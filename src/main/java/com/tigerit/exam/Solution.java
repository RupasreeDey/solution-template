package com.tigerit.exam;


import static com.tigerit.exam.IO.*;

/**
 * All of your application logic should be placed inside this class.
 * Remember we will load your application from our custom container.
 * You may add private method inside this class but, make sure your
 * application's execution points start from inside run method.
 */
public class Solution implements Runnable {
    @Override
    public void run() {
    int testCase_number = readLineAsInteger();
    	
    	for(int testCase = 0 ; testCase < testCase_number ; testCase++)
    	{
    		//testCase_number-=1;
    		int table_number = readLineAsInteger();
    		
    		ArrayList tableNames = new ArrayList() ;
    		List<List<String>> tableAttributeNames = new ArrayList<List<String>>();
    		List<List<List<String>>> tableRowWiseValues = new ArrayList<List<List<String>>>();

            while(table_number!=0)
            {
                
            	table_number-=1;
                String tableName = readLine();
                tableNames.add(tableName);

                String col_row_line = readLine();
                String[] col_row_split = col_row_line.split(" ");            

                int col_number = Integer.parseInt(col_row_split[0]);
                int row_number = Integer.parseInt(col_row_split[1]);
                

                
                String columnName = readLine();   //input column names
                
                String[] columnNameSplit = columnName.split(" ");
                ArrayList columnList = new ArrayList();
                
                for(int i=0; i<col_number ; i++)
                {
                	columnList.add(columnNameSplit[i]);
                }

                tableAttributeNames.add(columnList);
                
                List<List<String>> rowList = new ArrayList<List<String>>();

                for(int i=0; i < row_number; i++){
                   
                    String rowLine = readLine();     //row value input
                    String[] rowLineSplit = rowLine.split(" ");
                    
                    ArrayList individualRow = new ArrayList();
                    
                    for(int k=0; k<col_number; k++){
                        String rowIntValue = rowLineSplit[k];  
                         individualRow.add(rowIntValue);
                    }  
                    
                    rowList.add(individualRow);
                }
                
                tableRowWiseValues.add(rowList);
            }
    		
          //store & print output
            
            int t = testCase +1;
            printLine("Test: "+ t);
            
            int queryNumber = readLineAsInteger();
            
            for(int query=0; query<queryNumber; query++){
            	
                String line1 = readLine();
                String line2 = readLine();
                String line3 = readLine();
                String line4 = readLine();
                readLine();
                
                String[] line1Split = line1.split(" ");
                String[] line2Split = line2.split(" ");
                String[] line3Split = line3.split(" ");
                String[] line4Split = line4.split(" ");

                String table1 = line2Split[1];
                String table2 = line3Split[1];
                
                String table1Alias = "";
                String table2Alias = "";
                
                if(line2Split.length==3 && line3Split.length==3)
                {
                	//System.out.println("length 3 of line1");
                	table1Alias = line2Split[2];
                    table2Alias = line3Split[2];
                }
                
                //System.out.println("Tables " + table1 + " " + table2);
                
                //System.out.println("Table aliases " + table1Alias + " " + table2Alias);
                
                String[] line4SplitByDot = line4Split[1].split("\\.");               
                String attribute1 = line4SplitByDot[1];


                line4SplitByDot = line4Split[3].split("\\.");
                String attribute2 = line4SplitByDot[1];
                
                //System.out.println("Attributes " + attribute1 + " " + attribute2);

                //get table index number
                int table1Order=0, table2Order=0, attribute1Order=0, attribute2Order=0;
                
                for(int i=0; i<tableNames.size(); i++)
                {
                    if(table1.equals(tableNames.get(i))){
                    	table1Order = i;
                    }
                    else if(table2.equals(tableNames.get(i))){
                    	table2Order =  i;
                    }
                }
                
                //System.out.println("Table orders " + table1Order + " " + table2Order);
                    
                //get primary key index
                for(int i=0; i<tableAttributeNames.get(table1Order).size(); i++){

                    if(attribute1.equals(tableAttributeNames.get(table1Order).get(i))){
                    	attribute1Order=i;
                    }
                }
                
                for(int i=0; i<tableAttributeNames.get(table2Order).size(); i++){

                    if(attribute2.equals(tableAttributeNames.get(table2Order).get(i))){
                    	attribute2Order=i;
                    }
                }
                
                //System.out.println("Attributes order" + attribute1Order + " " + attribute2Order);
                
                //output starts
                
                String output="";
                
                if(line1Split[1].equals("*"))
                {
                    //select all columns for header

                    
                    for(int i=0; i<tableAttributeNames.get(table1Order).size(); i++){
                        output += tableAttributeNames.get(table1Order).get(i)+" ";
                    }
                    
                    for(int i=0; i<tableAttributeNames.get(table2Order).size(); i++){
                        output += tableAttributeNames.get(table2Order).get(i)+" ";
                    }
                    
                    output +="\n";
                    
                  //add all columns to output

                    
                    for(int i=0; i<tableRowWiseValues.get(table1Order).size(); i++){
                    	
                    	List<String>A = new ArrayList();
                    	A = tableRowWiseValues.get(table1Order).get(i);
                    	
                        for(int j=0; j<tableRowWiseValues.get(table2Order).size(); j++){
                        	
                        	List<String>B = new ArrayList();
                        	B = tableRowWiseValues.get(table2Order).get(j);
                        	
                        	
                        	//System.out.println(A.get(attribute1Order) + "  " + B.get(attribute2Order));
                        	
                            if(A.get(attribute1Order).equals(B.get(attribute2Order)) ){
                                //matched
                            	//System.out.println("matched");
                                for(int x=0; x<A.size(); x++){
                                    output +=A.get(x)+" ";
                                }
                                for(int x=0; x<B.size(); x++){                                    
                                    output +=B.get(x)+" ";                                    
                                }
                                output +="\n";                                
                            }
                        }
                    }

                    printLine(output);
                    printLine("\n");
                    
                }
                
                else
                {
                	for(int i=0; i<line1Split.length; i++)
                	{
                		//System.out.println("Line1Split " + line1Split[i]);
                	}
                	
                	ArrayList columnToSelect = new ArrayList();
                	ArrayList table1Columns = new ArrayList();
                	ArrayList table2Columns = new ArrayList();
                	
                	
                	
                	for(int i=1; i<line1Split.length; i++)
                	{
                		String part = line1Split[i];
                		String[] partSplitByDot = part.split("\\."); 
                		
                		//System.out.println("partSplitByDot[0] " + partSplitByDot[0]);
                		
                		//if(i==line1Split.length-1)System.out.println("partSplitByDot[1] " + partSplitByDot[1].substring(0, partSplitByDot[1].length()));
                		//else System.out.println("partSplitByDot[1] " + partSplitByDot[1].substring(0, partSplitByDot[1].length() -1 ));
                		
                		if(partSplitByDot[0].equals(table1Alias)) 
                			{
                				//System.out.println("partSplitByDot[0] matched table1 alias");
                				if(i==line1Split.length-1)table1Columns.add(partSplitByDot[1].substring(0, partSplitByDot[1].length()));
                				else table1Columns.add(partSplitByDot[1].substring(0, partSplitByDot[1].length()-1));
                			}
                		else if(partSplitByDot[0].equals(table2Alias)) 
                			{
                				//System.out.println("partSplitByDot[0] matched table2 alias");
                				if(i==line1Split.length-1) table2Columns.add(partSplitByDot[1].substring(0, partSplitByDot[1].length()));
                				else table2Columns.add(partSplitByDot[1].substring(0, partSplitByDot[1].length() - 1));
                			}
                		
                		//System.out.println("columns to select " + partSplitByDot[1].substring(0, partSplitByDot[1].length() - 1));
                		
                		if(i==line1Split.length-1) columnToSelect.add(partSplitByDot[1].substring(0, partSplitByDot[1].length()));
                		else columnToSelect.add(partSplitByDot[1].substring(0, partSplitByDot[1].length() -1 ));
                	}
                	
                	
                	for(int i=0; i<table1Columns.size(); i++)
                	{
                		output += table1Columns.get(i) + " ";
                		//System.out.println("table1 Columns " + table1Columns.get(i));
                	}
                	
                	for(int i=0; i<table2Columns.size(); i++)
                	{
                		output += table2Columns.get(i);
                		if(i<table2Columns.size()-1) output+=" "; 
                		//System.out.println("table2 Columns " + table2Columns.get(i));
                	}
                	
                	output +="\n";
                	
                	//row match
                	
                    for(int i=0; i<tableRowWiseValues.get(table1Order).size(); i++){
                    	
                    	List<String>A = new ArrayList();
                    	A = tableRowWiseValues.get(table1Order).get(i);
                    	
                        for(int j=0; j<tableRowWiseValues.get(table2Order).size(); j++){
                        	
                        	List<String>B = new ArrayList();
                        	B = tableRowWiseValues.get(table2Order).get(j);
                        	
                            if(A.get(attribute1Order).equals(B.get(attribute2Order) )){
                                //table1, table2 row matched
                                for(int x=0; x<A.size(); x++){
                                	
                                	String at_name = tableAttributeNames.get(table1Order).get(x);
                                	
                                	for(int y=0 ; y < table1Columns.size(); y++)
                                	{
                                		if(at_name.equals(table1Columns.get(y)))
                                		{
                                			output +=A.get(x)+" ";
                                		}
                                	}
                                    
                                }
                                
                                for(int x=0; x<B.size(); x++){
                                	
                                	String at_name = tableAttributeNames.get(table2Order).get(x);
                                	
                                	for(int y=0 ; y < table2Columns.size(); y++)
                                	{
                                		if(at_name.equals(table2Columns.get(y)))
                                		{
                                			output +=B.get(x)+" ";
                                		}
                                	}
                                    
                                }
                                
                                
                                output +="\n";                                
                            }
                        }
                    }
                	
                	
                    printLine(output);
                    printLine("\n");
                }
    	}
    }
    }
}
