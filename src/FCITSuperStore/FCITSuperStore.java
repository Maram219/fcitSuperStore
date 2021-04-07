/*
Maram Alshehri
CPCS204
P1

10/10/2017
 */
package FCITSuperStore;

/**
 *
 * @author Maram
 */
import java.util.*;
import java.io.*;
import static jdk.nashorn.internal.objects.NativeArray.sort;

public class FCITSuperStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        // declare and create Object reading from file
        File file1 = new File("FCITSuperStore.in");
        if (!file1.exists()) {
            System.out.println("The FCITSuperStore.in file dose not exist");
        }

        // declare and create object (write) to write into output file
        File file2 = new File("FCITSuperStore.out");

        PrintWriter write = new PrintWriter(file2);
        //create a scanner

        Scanner input = new Scanner(file1);
        Scanner input2 = new Scanner(file1);
        //   declare variabls to read frist name , last , and command
        String fristN, last, command, line = System.getProperty("line.separator");
        // create variabls to read size from a file
        int maxProducts = input.nextInt();
        int maxSales = input.nextInt();

        // create arrays Of objects 
        FCITSuperStoreProduct[] products = new FCITSuperStoreProduct[maxProducts];
        FCITSuperStoreSale[] sales = new FCITSuperStoreSale[maxSales];

        // declear variabls to  read from a file  
        int itemNum;
        String itemName;
        double itemPrice;
        int quantity;
        int numItemsOnList = 0, restockQuantity;

        // declear & creat variabl to be like counter for arrays of objects
        int countAdd = FCITSuperStoreProduct.getNumProducts();
        int numSales = FCITSuperStoreSale.getnumSales();

        // use it for find item
        int index;

        //variable counting how many item is esist
        int counterI = 0;

        //declear array for item number and sales Quantity that the customer  orderd
        int[] itemsPurchased;
        //variables to clculate the sold and clculate total sold , total , Grand Total , item amount 
        int itemAmount = 0, sold = 0;
        double total = 0, total2 = 0, grandTotal = 0;

        // do loop
        do {

            //to read command from file
            command = input.next();

            switch (command) {
                case "INVENTORY":
                    write.println("INVENTORY:");
                    if (products[0] == null) {
                        write.println("	Contains no items.");
                       
                    } else {
                        write.println("	Contains the following items:");

                        // repreasent 
                        for (int i = 0; i < FCITSuperStoreProduct.getNumProducts(); i++) {
                            write.printf( "\t| Item %6d | %-20s | $ %7.2f | %4d unit(s) |  ",products[i].getItemNum() ,products[i].getItemName(), products[i].getItemPrice(), products[i].getQuantity());
                            write.print(line);
                        }
                    }

                   write.print(line); break;
                case "RESTOCK":
                    write.println("RESTOCK:");

                    if (products[0] == null) {
                        write.println("	There are no items to restock." + line);
                    } 
                    else {
                        for (int i = 0; i < FCITSuperStoreProduct.getNumProducts(); i++) {
                            if (products[i].getQuantity() == 0) {
                                products[i].setQuantity(products[i].getRestockQuantity());
                                write.println("	Item " + products[i].getItemNum() + ", " + products[i].getItemName() + ", restocked to a quantity of " + products[i].getRestockQuantity() + ".");
                            }
                            write.print(line);
                        }
                    }

                    break;

                case "FINDITEM":
                    itemNum = input.nextInt();
                    sold = 0;
                    write.println("FINDITEM:");
//                    for (int ii = 0; ii < FCITSuperStoreSale.getnumSales(); ii++) {
//                        for (int jj = 0; jj < sales[ii].getItemsPurchased().length; jj++) {
//                            if (sales[ii].getItemsPurchased()[jj] == itemNum) {
//                                jj++;
//                                sold += sales[ii].getItemsPurchased()[jj];
//                            }
//
//                        }
//
//                    }

                    if (products[0] == null) {
                        write.println("	Cannot perform command; there are no items in the product database." + line);
                    } else {
                        index = searchB(products, itemNum, write);
                        write.print(")");
                        write.println("");
                        if (index > -1) {

                            write.println("	Item #" + itemNum + " (" + products[index].getItemName() + ")");
                            write.println("	Price            :  $" + products[index].getItemPrice());
                            write.println("	Current Quantity :  " + products[index].getQuantity());
                            write.println("	Units Sold       :  " + sold);
                            //if Statement for total function
                            if (sold == 0) {
                                total = 0;
                            } else {
                                total = sold * products[index].getItemPrice();
                            }
                            write.printf("	Total Amount     :  $%.2f", total);
                            write.println("");
                        } else {
                            write.println("	Item #" + itemNum + " was not found in the product database.");
                            write.println("");
                        }
                    }

                    break;
                case "ADDITEM":
                    write.println("ADDITEM:");
                    itemNum = input.nextInt();
                    itemName = input.next();
                    itemPrice = input.nextDouble();
                    quantity = input.nextInt();
                    restockQuantity = input.nextInt();

                    // set data on Product class
                    products[countAdd] = new FCITSuperStoreProduct();
                    products[countAdd].setItemName(itemName);
                    products[countAdd].setItemNum(itemNum);
                    products[countAdd].setItemPrice(itemPrice);
                    products[countAdd].setQuantity(quantity);
                    products[countAdd].setRestockQuantity(restockQuantity);

                    //another way to set data on Product class
                    //  products[countAdd] = new FCITSuperStoreProduct(itemNum, itemName, itemPrice, quantity, restockQuantity);
                    write.println(products[countAdd].toString() + line);
                    sortt(products, FCITSuperStoreProduct.getNumProducts());

                    countAdd++;
                    break;
                case "CUSTOMER":
                    write.println("CUSTOMER:");

                    //read customer data from input file
                    fristN = input.next();
                    last = input.next();
                    numItemsOnList = input.nextInt();

                    itemsPurchased = new int[numItemsOnList];

                    counterI = 0;

                    for (int i = 0; i < numItemsOnList; i++) {
                        itemsPurchased[i] = input.nextInt();

                    }

                    // send data to Sale class
                   // sales[numSales] = new FCITSuperStoreSale(fristN, last, (numItemsOnList / 2), itemsPurchased);

                    // clculate Quantity
                    for (int i = 0; i < countAdd; i++) {
                        for (int j = 0; j < numItemsOnList; j++) {
                            if (itemsPurchased[j] == products[i].getItemNum()) { 
                                  sales[numSales] = new FCITSuperStoreSale(fristN, last, (numItemsOnList / 2), itemsPurchased);
                                if (products[i].getQuantity() < itemsPurchased[j + 1]) {
                                    int result1 = itemsPurchased[j + 1] - products[i].getQuantity();
                                    
                                    int result2 = itemsPurchased[j + 1] - result1;
                                    products[i].setQuantity(0);
                                } else {
                                    int result3 = products[i].getQuantity() - itemsPurchased[j + 1];
                                    products[i].setQuantity(result3);
                                }

                                counterI++;
                            }
                        }
                    }

                    //  by counter   checking if the item number is existing into the customer's order or not and depending on that sending 
                    if (counterI == 0) {
                        write.println("	Customer " + fristN + " " + last + " came and made no purchases." + line);
                    } else {
                        write.println("	Customer " + fristN + " " + last + " came and made some purchases." + line);
                    }

                    numSales++;
                    break;

                case "PRINTSALESSUMMARY":
                    // I should review the code ate the below 
//                    write.println("PRINTSALESSUMMARY:");
//                    write.println("FCIT SuperStore Sales Report:");
//                    grandTotal = 0;
//                    for (int ii = 0; ii < FCITSuperStoreSale.getnumSales(); ii++) {
//
////                        write.println("	Sale #" + (ii + 1) + ", " + sales[ii].getFirstName() + " " + sales[ii].getFirstName() + " purchased " + itemAmount + " item(s):");
//                        itemAmount = 0;
//                        total2 = 0;
//                        for (int k = 0; k < sales[ii].getItemsPurchased().length; k++) {
//
//                            for (int i = 0; i < FCITSuperStoreProduct.getNumProducts(); i++) {
//                                if (sales[ii].getItemsPurchased()[k] == products[i].getItemNum()) {
//                                    itemAmount += sales[ii].getItemsPurchased()[k + 1];
//
//                                    write.printf("\t\t| Item %6d | %-20s | $ %7.2f (x   %4d) |", sales[ii].getItemsPurchased()[k], products[i].getItemName(), products[i].getItemPrice(), sales[ii].getItemsPurchased()[k + 1]);
//                                    total2 += (products[i].getItemPrice() * sales[ii].getItemsPurchased()[k + 1]);
//                                    write.println();
//                                }
//                            }
//                        }
//                        write.printf("		Total: $%.2f", total2);
//                        write.println();
//                        grandTotal += total2;
//                    }
//                    write.printf("	Grand Total: $%.2f", grandTotal);
//                    write.println(line);
                    break;
            
                
                case "QUIT":
                    write.print("Goodbye.");
                    input.close();
                    write.close();
                    System.exit(0);
                    break;

            }

        } while (input.hasNext());

    }

    //==================================================================================
    public static int searchB(FCITSuperStoreProduct[] products, int itemNum, PrintWriter write) {

        int low = 0, high = FCITSuperStoreProduct.getNumProducts() - 1, mid = 0;
        write.print("	Performing Binary Search...(Indices viewed: ");
        
        while (low <= high) {
            mid = (low + high) / 2;
            write.print(mid + " ");
            if (itemNum == products[mid].getItemNum()) {

                return mid;
            } else if (itemNum < products[mid].getItemNum()) // change high
            {
                high = mid - 1;
            } else if (itemNum > products[mid].getItemNum()) {
                low = mid + 1;
            }

        }
        return -1; // if key not found above
    }

    //==================================================================================
    private static void sortt(FCITSuperStoreProduct[] products, int countAdd) {
        FCITSuperStoreProduct[] temp = new FCITSuperStoreProduct[products.length];
        for (int i = 0; i < countAdd; i++) {
            
            if (temp[i] == null) {
                temp[i] = products[i];
                int index = i;
            }
            
            for (int j = i + 1; j < countAdd; j++) {
                if (temp[i].getItemNum() > products[j].getItemNum() && products[j] != null) {
                    temp[i] = products[j];
                    products[i + 1] = products[i];
                    products[i] = temp[i];
                }
            }
        }

    }

}
