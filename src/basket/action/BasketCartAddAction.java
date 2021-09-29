package basket.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.Action;
import svc.BasketCartAddService;
import vo.ActionForward;
import vo.Product;

public class BasketCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 장바구니에 추가해보자
		BasketCartAddService basketCartAddService = new BasketCartAddService(); 
		
		String id=request.getParameter("id");
		Product cartProduce = basketCartAddService.getBasket(id);
		
		
		return null;
	}

}
