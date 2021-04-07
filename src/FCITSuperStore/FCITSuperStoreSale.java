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
public class FCITSuperStoreSale 
{
    private String firstName;
    private String lastName;
    private int numItemsOnList;
    private int itemsPurchased[];
    private static int numSales;
    
      //=====================================


   public FCITSuperStoreSale(String firstName,String lastName,int numItemsOnList,int[]itemsPurchased)
    { this.firstName=firstName;
      this.lastName=lastName;
      this.numItemsOnList=numItemsOnList;
      this.itemsPurchased=itemsPurchased;
       numSales++;
    }
    //=======================================
    public String getFirstName( )
    {
    return firstName;
    }
   //======================================
    public String getLastName( )
              {
    return lastName;
    }
    //======================================
    public int getNumItemsOnList( )
    {
    return 0;
    }
    //======================================
    public int[] getItemsPurchased( )
       {
    return itemsPurchased;
    }
    
//======================================
    public static int getnumSales( )
        {
   return numSales;
    }
    
    //======================================
    public void setFirstName( String firstName )
    {this.firstName=firstName;}
      //======================================
public void setLastName( String lastName )
        {this.lastName=lastName;}
   //======================================
public void setNumItemsOnList( int numItemsOnList )
     {this.numItemsOnList=numItemsOnList;}
   //======================================
public void setItemsPurchased( int[] itemsPurchased )
     {}
   //======================================
public static void setNumSales ( int numSales )
      {
      FCITSuperStoreSale.numSales=numSales;}
   //======================================

}
    

