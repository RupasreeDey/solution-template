
import java.util.ArrayList;
import java.util.List;
import java.util.*; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * All of your application logic should be placed inside this class.
 * Remember we will load your application from our custom container.
 * You may add private method inside this class but, make sure your
 * application's execution points start from inside run method.
 */

public class test implements Runnable {

    public static String readLine() {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String value;
        try {
            value = reader.readLine();
        } catch (IOException ex) {
            value = null;
        }
        return value;
    }

    public static Integer readLineAsInteger() {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(readLine());
    }

    public static void printLine(Object value) {
        System.out.println(value);
    }
    @Override
    public void run() {
        // your application entry point

        // sample input process
        
        int test_case = readLineAsInteger();
	
	while(test_case!=0)
	{
		test_case-=1;

		Integer no_table = readLineAsInteger();
		
		Dictionary column_val = new Hashtable(); 

		while(no_table!=0)
		{
			no_table-=1;
			String table_name = readLine();
			int col_num = readLineAsInteger();
			int row_num = readLineAsInteger();
			
			List<String> columns = new ArrayList<>();

			for(int i=0; i<col_num; i++)
			{
				String col_name = readLine();
				columns.add(col_name);
				
			}

			for(int i=0; i<col_num; i++)
			{
				String col_name = columns.get(i);
				printLine(col_name);
			}

			
			int[][] table_val = new int[100][100];

			for(int i=0; i<row_num; i++)
			{
				for(int j=0; j<col_num; j++)
				{
					int val = readLineAsInteger();
					table_val[i][j]=val;
				}
			}

			

			for(int i=0; i<col_num; i++)
			{
				String column_name=columns.get(i);
				List<Integer> col_val_map = new ArrayList<>();


				for(int j=0; j<row_num; j++)
				{
					//Integer val = readLineAsInteger();
					int val=table_val[j][i];
					col_val_map.add(val);
				}

				column_val.put(column_name, col_val_map);
			}

			
		}

		
	}	


        // sample output process
        //printLine(string);
        //printLine(integer);
    }
}
