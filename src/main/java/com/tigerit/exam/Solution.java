package com.tigerit.exam;


import com.tigerit.exam.IO;

/**
 * All of your application logic should be placed inside this class.
 * Remember we will load your application from our custom container.
 * You may add private method inside this class but, make sure your
 * application's execution points start from inside run method.
 */
public class Solution implements Runnable {
    @Override
    public void run() {
            /**
     * @param args the command line arguments
     */
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

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test_case = 0;
        try {
            test_case = (int) Integer.parseInt(reader.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("testcase is: " + test_case);

        while (test_case != 0) {
            test_case -= 1;

            Integer no_table = null;
            try {
                no_table = (int) Integer.parseInt(reader.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("table_no is: " + no_table);

            Dictionary column_val = new Hashtable();

            List<List<String>> table_1 = new ArrayList<List<String>>();
            List<List<String>> table_2 = new ArrayList<List<String>>();

            try {
                String table_name = reader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            String dimension = "";
            try {
                dimension = reader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            String[] ret = dimension.split("\\s+");
            int col_num_1 = Integer.parseInt(ret[0]);
            int row_num_1 = Integer.parseInt(ret[1]);

            System.out.println("==>col_num ==>" + col_num_1);

            System.out.println("==>row_num ==>" + row_num_1);
            for (int i = 0; i <= row_num_1; i++) {
                String at_names = "";
                try {
                    at_names = reader.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

                String[] table_1_head = at_names.split("\\s+");

                List<String> head = new ArrayList<>();
                for (int j = 0; j < col_num_1; j++) {
                    head.add(table_1_head[j]);

                }

                table_1.add(head);

//                    System.out.println("==>table_1_[0] ==>" + table_1.get(i));
//
//                    System.out.println("==>table_attr_1 ==>" + table_1_head[1]);
            }
            for (int i = 0; i <= row_num_1; i++) {
                System.out.println("==>table_1_[0] ==>" + table_1.get(i));
            }

            /////########################################################################
            /////#############################  Table2   ################################
            /////########################################################################
            try {
                String table_name = reader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            dimension = "";
            try {
                dimension = reader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            ret = dimension.split("\\s+");
            int col_num_2 = Integer.parseInt(ret[0]);
            int row_num_2 = Integer.parseInt(ret[1]);

            System.out.println("==>col_num ==>" + col_num_2);

            System.out.println("==>row_num ==>" + row_num_2);

            for (int i = 0; i <= row_num_2; i++) {
                String at_names = "";
                try {
                    at_names = reader.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

                String[] table_1_head = at_names.split("\\s+");

                List<String> head = new ArrayList<>();
                for (int j = 0; j < col_num_2; j++) {
                    head.add(table_1_head[j]);

                }

                table_2.add(head);

//                    System.out.println("==>table_1_[0] ==>" + table_1.get(i));
//
//                    System.out.println("==>table_attr_1 ==>" + table_1_head[1]);
            }

            for (int i = 0; i <= row_num_2; i++) {
                //System.out.println("==>table_1_[0] ==>" + table_2.get(i));
            }

            int query = 0;
            try {
                query = (int) Integer.parseInt(reader.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            //System.out.println("==>query number ==> " + query);

            String table_first = "";
            String table_second = "";

            while (query != 0) {
                query -= 1;

                boolean select_all = false;

                String first = "", second = "";

                for (int i = 0; i < 4; i++) {
                    String com = "";

                    try {
                        com = reader.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String[] command = com.split("\\s+");

                    for (int j = 0; j < command.length; j++) {
                        //System.out.println("==>command ==> " + command[j]);
                    }

                    if (i == 0) {

                        if (command[1] == "*") {
                            select_all = true;
                        }
                    }

                    if (i == 1) {
                        table_first = command[1];
                    }

                    if (i == 2) {
                        table_second = command[1];
                    }

                    if (i == 3) {
                        String first_at = command[1];
                        String second_at = command[3];

                        int start = 0;

                        for (int j = 0; j < first_at.length(); j++) {
                            if (first_at.charAt(j) == '.') {
                                start = j;
                                break;
                            }
                        }

                        first = "";

                        for (int j = start + 1; j < first_at.length(); j++) {
                            first += first_at.charAt(j);
                        }

                        start = 0;

                        for (int j = 0; j < second_at.length(); j++) {
                            if (second_at.charAt(j) == '.') {
                                start = j;
                                break;
                            }
                        }

                        second = "";

                        for (int j = start + 1; j < second_at.length(); j++) {
                            second += second_at.charAt(j);
                        }

                    }
                }

               // System.out.println("==>first attribute ==> " + first);
               //System.out.println("==>second attribute ==> " + second);

                int index_1 = 0;

                for (int i = 0; i < col_num_1; i++) {
                    if (table_1.get(0).get(i) == first) {
                        index_1 = i;
                        break;
                    }
                }

                int index_2 = 0;

                for (int i = 0; i < col_num_2; i++) {

                    if (table_2.get(0).get(i) == second) {
                        index_2 = i;
                        break;
                    }
                }
                
                System.out.println("==>Table1 index ==> " + index_1);
                System.out.println("==>Table2 index ==> " + index_2);

                if (select_all == true) {
                    List<String> L1 = table_1.get(0);
                    List<String> L2 = table_2.get(0);

                    String out1 = "";
                    String out2 = "";

                    for (int k = 0; k < col_num_1; k++) {
                        out1 += L1.get(k);
                        out1 += " ";
                    }

                    for (int k = 0; k < col_num_2; k++) {
                        out2 += L2.get(k);
                        if (k <= col_num_2 - 1) {
                            out2 += " ";
                        }
                    }

                    String out = out1 + out2;
                    System.out.println(out);
                }

                int i, j = 0;
                for (i = 0; i < row_num_1; i++) {
                    List<String> L1 = table_1.get(i);

                    String table_1_val = L1.get(index_1);

                    for (j = 0; j < row_num_2; j++) {
                        List<String> L2 = table_2.get(j);

                        String table_2_val = L2.get(index_2);

                        String out1 = "";
                        String out2 = "";

                        if (table_1_val == table_2_val) {
                            for (int k = 0; k < col_num_1; k++) {
                                out1 += L1.get(k);
                                out1 += " ";
                            }

                            for (int k = 0; k < col_num_2; k++) {
                                out2 += L2.get(k);
                                if (k <= col_num_2 - 1) {
                                    out2 += " ";
                                }
                            }

                            String out = out1 + out2;
                            System.out.println(out);
                        }
                    }

                }

            }

            //System.out.println("end");

        }
    }
}
