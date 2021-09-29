package mypage.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ProductListService;
import vo.ActionForward;
import vo.Member;
import vo.Product;

public class AdminProductListFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Product> productList = new ArrayList<Product>();
		
		ProductListService productListService =new ProductListService();
		
		HttpSession session = request.getSession(false);
		
		Member member = (Member)session.getAttribute("member");
		
		productList = productListService.getListProduct();
		
		ActionForward forward = null;
		
		if(!member.getAuthor().equalsIgnoreCase("2")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('관리자가 아닙니다');");
			out.print("history.back();");
			out.print("</script>");
		} else if (member.getAuthor().equalsIgnoreCase("2")) {
			session.setAttribute("productList", productList);
			forward = new ActionForward();
			forward.setPath("mypage/adminProductList.jsp");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
