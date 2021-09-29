package mypage.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProductListService;
import vo.ActionForward;
import vo.Product;

public class AdminIOFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String productCheckCode[] = request.getParameterValues("productCheck");
		
		if(productCheckCode == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('상품이 체크되지 않았습니다.');");
			out.print("history.back();");
			out.print("</script>");
		}
		
		ProductListService ProductListService = new ProductListService();
		
		ArrayList<Product> productList = ProductListService.getArrProudct(productCheckCode);
		
		request.setAttribute("productList",productList);
		ActionForward forward = new ActionForward("mypage/adminIOForm.jsp", false);
		
		return forward;
	}

}
