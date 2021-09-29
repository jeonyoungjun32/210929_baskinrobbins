package mypage.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProductListService;
import vo.ActionForward;

public class AdminIOProAction implements Action {

	/*수정중*/
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String strProduct_code[] = request.getParameterValues("code");
		
		if(strProduct_code == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('입고할 상품이 없습니다');");
			out.print("history.back();");
			out.print("</script>");
		}
		int i;
		int j=0;
		for(i=0;i<strProduct_code.length;i++) {
			j++;
		}
		int serial_code_p[] = new int[j];
		
		for(i=0; i<strProduct_code.length; i++) {
			serial_code_p[i] = Integer.parseInt(strProduct_code[i]);
		}
		
		String strProduct_count[] = request.getParameterValues("IO_count");
		
		int product_count[] = new int[j];
		
		for(i =0; i<strProduct_code.length; i++) {
			product_count[i] = Integer.parseInt(strProduct_count[i]);
		}
		
		for(i=0; i<strProduct_code.length; i++) {
			strProduct_code[i] = strProduct_code[i].substring(0, 1);
		}
		
		ProductListService productListService = new ProductListService();
		
		boolean IOSuccess = productListService.adminIOUpdate(serial_code_p,product_count,strProduct_code);
		
		ActionForward forward = null;
		
		if (!IOSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('입고가 실패되었습니다.');");
			out.print("history.back();");
			out.print("</script>");
		} else {
			forward = new ActionForward("adminIOProSuccess.bg", false);
		}
		
		return forward;
	}

}
