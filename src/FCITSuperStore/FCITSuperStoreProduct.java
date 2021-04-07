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
public class FCITSuperStoreProduct
{
    private int itemNum;
    private String itemName;
    private double itemPrice;
    private int quantity;
    private int restockQuantity;
    private static int numProducts=0;
 
     public FCITSuperStoreProduct()
     {numProducts++; }
     //============================================
   //For another Way   
//    public FCITSuperStoreProduct(int itemNum ,String itemName , double itemPrice,int quantity , int restockQuantity)
//    { this.itemNum=itemNum;
//    this.itemName=itemName;
//    this.itemPrice=itemPrice;
//    this.quantity=quantity;
//    this.restockQuantity=restockQuantity;
//    
//  numProducts++;
//    
//    }
    
//======================================
    public int getItemNum( )
   {
 return itemNum;
   }          

   //======================================            
  public String getItemName( )
  {
  return itemName;
 
 }         
  //======================================          
          
  public double getItemPrice( )
  {
  return itemPrice;
 
 }         
 
  //======================================         
          
          
 public int getQuantity( )
  {
 
  return quantity;
 }        

 //======================================        
         
         
public int getRestockQuantity( ) 
  {
 
  return restockQuantity;
 }       
        
        
//======================================        
       
 public static int getNumProducts ( ) 
  {
  return numProducts;
 
 }        
         
 //======================================         
         
         
public void setItemNum( int itemNum ) 
   {
 this.itemNum=itemNum;
 
 }      
        
 //======================================       
        
 public void setItemName( String itemName ) 
   {
 this.itemName=itemName;
 
 }       
         
 //======================================         
         
 public void setItemPrice(double itemPrice ) 
   {
 this.itemPrice=itemPrice;
 
 }       
         
         
   //======================================         
         
 public void setQuantity( int quantity ) 
         
  {
  this.quantity=quantity;
 
 }        
         
   //======================================         
         
 public void setRestockQuantity( int restockQuantity ) 
  {
 this.restockQuantity=restockQuantity;
 
 }        
         
   //======================================         
         
         
 public static void setNumProducts ( int numProducts )
 {
 FCITSuperStoreProduct.numProducts= numProducts;
 
 }

   //======================================    
  @Override
 public String toString() {
 return "	Item "+itemNum+", "+itemName+", with a cost of $"+itemPrice+" and initial stock of "+quantity+", has been added to the product database.";
 }
 

}
