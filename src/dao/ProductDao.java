
package dao;
import model.Product;


public class ProductDao {
    
    
    public static void save(Product product) {
        String query = "insert into product(name,category,price) values('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"')";
        DbOperations.setDataorDelete(query, "Producto Añadido Correctamente");
    }
}
