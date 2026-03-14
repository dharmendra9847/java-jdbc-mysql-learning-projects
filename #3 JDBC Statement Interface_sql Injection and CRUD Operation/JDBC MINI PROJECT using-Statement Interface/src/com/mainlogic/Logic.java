package com.mainlogic;

import com.crudoperation.Crud;
import com.dto.EmployeeDTO;

import java.util.Scanner;

public class Logic {


    private final int INSERT_DATA = 1;
    private final int READ_DATA = 2;
    private final int UPDATE_DATA = 3;
    private final int DELETE_DATA = 4;
    private final int EXIT = 5;

    private String username;
    private String password;
    private String fullname;
    private String address;
    private String department;
    private int salary;



    private static final int MAX_ATTEMPTS = 3;

    private Crud crud;
    public Logic(){
        crud = new Crud();
    }

    public void doStart(){

        /*
          CREATE
          INSERT
          READ
          UPDATE
          DELETE

          FIRST CREATE A MANU

         */
        Scanner sc = new Scanner(System.in);

        int attempt = 0;

        while (true){
            System.out.println("\n=========== MENU ===========");
            System.out.println("PRESS-1 : INSERT DATA");
            System.out.println("PRESS-2 : READ DATA");
            System.out.println("PRESS-3 : UPDATE DATA");
            System.out.println("PRESS-4 : DELETE DATA");
            System.out.println("PRESS-5 : EXIT\n");

//            System.out.println("ENTER YOUR CHOICE : ");
//            int choice = sc.nextInt();
//
//            if (choice == 5){
//                System.out.println("EXIT! Thank you for using our service. " +
//                        "\nHave nice day:)");
//            }
//            switch (choice){
//
//                case 1:
//            }


            System.out.println("ENTER YOUR CHOICE : ");

            int choice = 0;

            try {
                choice = sc.nextInt();
            }

            catch (Exception e) {
                System.out.println("INVALID INPUT! PLEASE TAKE A NUMBER FROM 1 TO 5.");
                sc.nextLine();

                attempt++;
                if (attempt > MAX_ATTEMPTS)
                {
                    System.out.println("You have cross maximum limit try after sometime!");
                    sc.close();
                    return;
                }
                continue;
            }

            if (choice < 1 || choice > 5){
                System.out.println("INVALID INPUT! PLEASE TAKE A VALUE FROM 1 TO 5.");

                attempt++;
                if (attempt >= MAX_ATTEMPTS) {
                    System.out.println("You have cross maximum limit try after sometime!");
                    sc.close();
                    return;
                }
            }
            switch(choice){
                case INSERT_DATA:

                    System.out.println("ENTER USER_NAME");
                    username = sc.next();

                    System.out.println("ENTER PASSWORD");
                    password = sc.next();

                    sc.nextLine();  //  AVOID NEXT LINE CHARACTER

                    System.out.println("ENTER FULL_NAME");
                    fullname = sc.nextLine();

                    System.out.println("ENTER ADDRESS");
                    address = sc.nextLine();

                    System.out.println("ENTER DEPARTMENT");
                    department = sc.nextLine();

                    System.out.println("ENTER SALARY");
                    salary = sc.nextInt();

                    EmployeeDTO employeeDTO = new EmployeeDTO(username, password, fullname, address, department, salary);
                    crud.insert(employeeDTO);
                    
                    // System.out.println("DATA INSERTED SUCCESSFULLY!");
                    break;
                case READ_DATA:

                    System.out.println("ENTER USER_NAME");
                    username = sc.next();

                    System.out.println("ENTER PASSWORD");
                    password = sc.next();
                    crud.read(username, password);


                    //  System.out.println("DATA READ SUCCESSFULLY!");
                    break;
                case UPDATE_DATA:

                    System.out.println("ENTER USER_NAME");
                    username = sc.next();

                    System.out.println("ENTER SALARY");
                    salary = sc.nextInt();

                    crud.update(username, salary);

                    //  System.out.println("DATA UPDATED SUCCESSFULLY!");
                    break;
                case DELETE_DATA:

                    System.out.println("ENTER USER_NAME");
                    username = sc.next();

                    crud.delete(username);

                    //  System.out.println("DATA DELETED SUCCESSFULLY!");
                    break;
                case EXIT:
                    System.out.println("EXIT! Thank you for using our service.\n"+
                            "Have nice day:)");
                    sc.close();
                    return;
            }

        }
    }
}
