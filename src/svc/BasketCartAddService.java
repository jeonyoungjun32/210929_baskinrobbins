package svc;

import static db.Jdbcutil.*;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import vo.Cart;
import vo.Product;

public class BasketCartAddService {

	public Product getBasket(int id) {
		
		Connection con = getConnection();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.setConnection(con);

		Product produc = ProductDAO.selectIce(id);
		
		close(con);
		
		return produc;
		
	}
	public void addCart(HttpServletRequest request, Product cartProduct) {
		HttpSession session = request.getSession();
		
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
	
		if(cartList == null	) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		boolean isNewCart = true;
		
		for (int i = 0; i < cartList.size(); i++) {
			if(cartProduct.getChoice().equals(cartList.get(i).getKind())) {
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
				break;
			}
			 if(isNewCart == true) {
			    	Cart cart = new Cart();
			    	cart.setImage("image");;
			    	cart.setKind("kind");
			    	cart.setPrice(1000);
			    	cart.setQty(1);//수량은 처음이므로 1로 셋팅
			    	
			    	cartList.add(cart);
			    }
		}
	}
	
	
}
