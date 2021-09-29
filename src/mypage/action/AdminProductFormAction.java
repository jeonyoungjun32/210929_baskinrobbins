package mypage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProductListService;
import vo.ActionForward;
import vo.Product;

public class AdminProductFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int serial_code_p = Integer.parseInt(request.getParameter("serial_code_p"));
		
		ProductListService productListService = new ProductListService();
		
		Product product = productListService.getProduct(serial_code_p);
		
		request.setAttribute("product", product);
		
		ActionForward forward = new ActionForward("mypage/adminProductForm.jsp", false);
		return forward;
	}

}
