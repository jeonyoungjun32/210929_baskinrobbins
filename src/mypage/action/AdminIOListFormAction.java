package mypage.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProductListService;
import vo.ActionForward;
import vo.IO;

public class AdminIOListFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ProductListService productListService = new ProductListService();
		
		ArrayList<IO> ioList = productListService.getIOList();
		
		request.setAttribute("ioList", ioList);
		ActionForward forward =new ActionForward("mypage/adminIOList.jsp", false);
		return forward;
	}

}
