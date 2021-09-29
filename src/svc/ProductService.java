package svc;

import static db.Jdbcutil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.Product;

public class ProductService {

	//IceCakeIngredientListAction
	//IceCakeListAction - 아이스케이크
	public ArrayList<Product> getListIceCake() throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		ArrayList<Product> iceCakeList = productDAO.getListIceCake();
		
		close(con);
		
		return iceCakeList;
	}

	//DessertIngredientListAction
	//DessertListAction - 디저트
	public ArrayList<Product> getListDessert() throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		ArrayList<Product> dessertList = productDAO.getListDessert();
		
		close(con);
		
		return dessertList;
	}

	//BeverageIngredientListAction
	//BeverageListAction - 음료
	public ArrayList<Product> getListBeverage() throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		ArrayList<Product> beverageList = productDAO.getListBeverage();
		
		close(con);
		
		return beverageList;
	}
	
	//CoffeeIngredientListAction
	//CoffeeListAction - 커피
	public ArrayList<Product> getListCoffee() throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		ArrayList<Product> coffeeList = productDAO.getListCoffee();
		
		close(con);
		
		return coffeeList;
	}
	
	
	
}
