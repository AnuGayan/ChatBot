import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CsvDB {
    ArrayList<Product> products = new ArrayList<>();



//    public ArrayList<Product> ProductDB() throws FileNotFoundException, ParseException {
    public static void main(String[] args) throws FileNotFoundException, ParseException{
        ArrayList<Product> products = new ArrayList<>();
        Scanner scan = new Scanner(new File("/home/anusha/Desktop/Data.csv"));

        while (scan.hasNextLine()){
            String line = scan.nextLine();
            String[] lineArray = line.split(",");
            products.add(new Product(lineArray[0],new SimpleDateFormat("dd/MM/yyyy").parse(lineArray[1]),lineArray[2],Integer.parseInt(lineArray[3])));
        }
        System.out.println(products);
//        return products;
    }


    public int count(String productName,String timePeriod){
        int count=0;

        if (timePeriod.equals("lastmonth")){

        }
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()){
            Product pd = iterator.next();
//            if (pd.getProductName().equals(productName)&& pd.getPurchesedDate().after())
        }
        return count;
    }
}

class Product{
    private String productName;
    private Date purchesedDate;
    private String customerName;

    public int getProductInstance() {
        return productInstance;
    }

    public void setProductInstance(int productInstance) {
        this.productInstance = productInstance;
    }

    private int productInstance;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getPurchesedDate() {
        return purchesedDate;
    }

    public void setPurchesedDate(Date purchesedDate) {
        this.purchesedDate = purchesedDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Product(String productName, Date purchesedDate, String customerName, int productInstance){
        this.customerName = customerName;
        this.productName = productName;
        this.purchesedDate=purchesedDate;
        this.productInstance=productInstance;


    }

//    public int productCount(String productName,Date purchesedDate){
//        int count=0;
//        while (Objects.equals(getProductName(), productName) && getPurchesedDate()==purchesedDate){
//
//        }
//        return count;
//    }
}

