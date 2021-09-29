package svc;

import static db.Jdbcutil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.IO;
import vo.Product;

public class ProductListService {
	
	//AdminProductInserProAction : 물건 등록
	public boolean insertProduct(Product product, String id) throws Exception {
		
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		int insertCount = productDAO.insertProduct(product, id);
		
		boolean insertSuccess = false;
		if(insertCount > 0) {
			commit(con);
			insertSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		
		return insertSuccess;
	}
	
	//AdminProductFormAction
	//AdminProductUpdateFormAction
	public Product getProduct(int serial_code_p) throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		Product product = productDAO.getProduct(serial_code_p);
		
		close(con);
		
		return product;
	}
	
	//AdminProductUpdateProAction
	public boolean getProductUpdate(int serial_code_p, String name, String allergy, int kcal, int price) throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		int productUpdateCount = productDAO.ProductUpdate(serial_code_p, name, allergy, kcal, price);
		
		boolean productUpdateSuccess = false;
		if (productUpdateCount > 0) {
			productUpdateSuccess = true;
			commit(con);
		} else {
			rollback(con);
		}
		
		return productUpdateSuccess;
	}
	
	//AdminProductListFormAction - 물건 리스트
	public ArrayList<Product> getListProduct() throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		ArrayList<Product> productList = productDAO.getListProduct();
		
		close(con);
		
		return productList;
	}

	//AdminProductDeleteProAction
	//AdminIOFormAction
	//체크된 물건 찾기
	public ArrayList<Product> getArrProudct(String[] productCheckCode) throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		ArrayList<Product> productList = productDAO.adminGetProduct(productCheckCode);
		
		close(con);
		
		return productList;
	}

	//AdminProductDeleteProAction - 상품 삭체 요청
	public boolean getArrProductDelete(Product products) throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		int arrProductDeleteCount = productDAO.arrProductDelete(products);
		
		boolean arrProductDeleteSuccess = false;
		if(arrProductDeleteCount > 0) {
			commit(con);
			arrProductDeleteSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		return arrProductDeleteSuccess;
	}

	//AdminIOProAction
	public boolean adminIOUpdate(int[] serial_code_p, int[] product_count, String[] strProduct_code) throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		int IOValue = productDAO.arrAdminIOupdate(serial_code_p,product_count,strProduct_code);
		
		boolean IOSuccess = false;
		if(IOValue >0) {
			commit(con);
			IOSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		return IOSuccess;
		
	}
	
	//AdminIOListFormAction
	public ArrayList<IO> getIOList() throws Exception {
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);
		
		ArrayList<IO> ioList = productDAO.selectIOlist();
		
		close(con);
		
		return ioList;
	}
	
}
