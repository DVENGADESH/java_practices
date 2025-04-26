import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Products{
    private int product_id;
    private String Product_name;
    private double price;
    private int Quantity;

    public Products(int product_id, String product_name, double price, int Quantity) {
        this.product_id = product_id;
        Product_name = product_name;
        this.price = price;
        this.Quantity = Quantity;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }
}

class User_Cart {
    List<Products> productList;
    List<Cart_Item> cart;
    Scanner in;

    public User_Cart(Scanner in, ArrayList<Cart_Item> cart, List<Products> products1) {

        this.productList = products1;
        this.in = in;
        this.cart = cart;
    }

    public void Add_To_Cart() {
        System.out.println("Available Products :");
        for (Products p : productList) {
            System.out.println("ID : " + p.getProduct_id() + "\t\t Product Name : " + p.getProduct_name() + "\t\t Price : " + p.getPrice() + "\t\t Available Stock : " + p.getQuantity());

        }
        Products selectedproduct = null;
        System.out.println("Enter Product ID : ");
        int id = in.nextInt();

        System.out.println("Enter Quantity : ");
        int quantity = in.nextInt();

        for (Products p : productList) {
            if (p.getProduct_id() == id) {
                selectedproduct = p;
            }

        }
        if (selectedproduct == null) {
            System.out.println("Invalid Product ID ! ");
        }
        if (quantity > selectedproduct.getQuantity()) {
            System.out.println("Stock not available !" + "\n Available Stock : " + selectedproduct.getQuantity());
        }

        // add more quantity if product already in the cart

        for (Cart_Item add : cart) {
            if (add.getProduct().getProduct_id() == selectedproduct.getProduct_id()) {
                add.setQuantity(add.getQuantity() + quantity);
                selectedproduct.setQuantity(selectedproduct.getQuantity() - quantity);
                System.out.println("Product Quantity increased in Cart ! ");
            }
        }

        //add new product to the cart

        cart.add(new Cart_Item(selectedproduct, quantity));
        selectedproduct.setQuantity(selectedproduct.getQuantity() - quantity);
        System.out.println("Product Added To Cart");
    }

    public void view_cart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty ! ");
        }
        System.out.println(" ----- Cart ----- ");
        double total = 0;
        for (Cart_Item item : cart) {
            System.out.println(item.getProduct().getProduct_id() + "\t\t  " + item.getProduct().getProduct_name() + "\t\t  " + item.getProduct().getQuantity() + "\t\t  " + item
                    .getProduct().getPrice());
            total += item.Total_Price();

        }
    }

    public void remove_cart(){

        for (Cart_Item item : cart) {
            if (cart.isEmpty()){
                System.out.println("Cart is Empty ! ");
            }
            view_cart();
        }
            for (Cart_Item item : cart){
            System.out.println("Enter the product ID : ");
            int id = in.nextInt();
            if(id != item.getProduct().getProduct_id()){
                System.out.println("Product ID Not Match !");
            }
            item.getProduct().setQuantity(item.getQuantity() + item.getQuantity());
            cart.remove(item);
            System.out.println("Item Removed from the Cart !.. ");
        }
        System.out.println("Item Not Matched !...");

    }
    public void checkout(){
        if(cart.isEmpty()){
            System.out.println(" Your Cart is Empty !.. ");
        }
        System.out.println(" Enter Coupon Code if yes otherwise press enter : ");
        in.nextLine();
        String coupon = in.nextLine();
        double total = 0;
        for (Cart_Item item : cart){
            total += item.Total_Price();
        }
       

        if(coupon.equalsIgnoreCase("SAVE10")){
            total *= 0.9;
            System.out.println(" 10% Discount Applied Successfully !. ");
        } else if (coupon.equalsIgnoreCase("SAVE5")) {
            System.out.println(" 5% Discount Applied Successfully !. ");
            total *= 0.4;
        }

        System.out.println("--------- Bill ---------");
        System.out.println("Total : " + total);
        System.out.println("Product Dispatched Successfully !...");
        System.out.println("Thank You !..");
    }
}
class Cart_Item{
    private Products product;
    private int Quantity;

    public Cart_Item(Products product, int quantity) {
        this.product = product;
        Quantity = quantity;
    }

    public Products getProduct() {
        return product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double Total_Price(){
        return Quantity * product.getPrice();
    }
}



public class Main {
    public static void main(String[] args) {
        List<Products> productsList= new ArrayList<>();
        productsList.add(new Products(1,"Mens T-Shirt",500,10));
        productsList.add(new Products(2,"Laptop      ",70000,5));
        productsList.add(new Products(3,"Mobile Phone",25000,9));
        productsList.add(new Products(4,"Water Bottle",250,25));
        Scanner in = new Scanner(System.in);
        User_Cart cart = new User_Cart(in,new ArrayList<>(),productsList);


        System.out.println("---------Welcome To Console Based E-Commerce Shopping--------- ");
        int chioce;
        do {

            System.out.println("Enter Your Choice : \n 0.Products : \n 1.Add to Cart : \n 2.View Cart : \n 3.Remove Cart : \n 4.Checkout : \n 5. Exit :" );
            chioce = in.nextInt();


            switch (chioce){
                case 0 -> {
                    System.out.println("ID \t\t Product Name \t\t Price \t\t Available stock ");
                    for (Products p: productsList){
                        System.out.println("\n"+ p.getProduct_id() + "\t\t"+ p.getProduct_name() + "\t\t\t" + p.getPrice() + "\t\t\t" + p.getQuantity());

                    }
                }
                case 1 -> cart.Add_To_Cart();
                case 2 -> cart.view_cart();
                case 3 -> cart.remove_cart();
                case 4 -> cart.checkout();
                case 5 ->{

                    System.out.println("Thank you !..");
                    break;
                }

                default -> System.out.println("Invalid Option !");
            }

        } while (chioce != 5);


    }
}
