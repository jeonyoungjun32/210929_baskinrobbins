package login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProductListService;
import vo.ActionForward;

public class orderPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ProductListService productListService = new ProductListService();
		
		productListService.getListProduct();
		
		ActionForward forward = null;
		
		return forward;
	}

}
