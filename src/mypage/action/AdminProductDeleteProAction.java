package mypage.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProductListService;
import vo.ActionForward;
import vo.Product;

public class AdminProductDeleteProAction implements Action {

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
		
		ProductListService productListService = new ProductListService();
		
		ArrayList<Product> productList = productListService.getArrProudct(productCheckCode);
		
		ActionForward forward = null;
		
		for(Product products : productList) {
			
			boolean arrProductDeleteSuccess = productListService.getArrProductDelete(products);
			
			if(!arrProductDeleteSuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('삭제가 실패 되었습니다');");
				out.print("history.back();");
				out.print("</script>");
			} else {
				forward = new ActionForward("adminProductListDeleteSuccess.bg", false);
			}
		}
		
		return forward;
	}

}
