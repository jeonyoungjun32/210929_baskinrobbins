package basket.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.Action;
import svc.BasketViewService;
import vo.ActionForward;
import vo.Basket;

public class BasketViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BasketViewService basketViewService = new BasketViewService();
		
		int id = Integer.parseInt(request.getParameter("id"));
		//해당 개 상품의 '조회수 1증가' -> 'id로 조회한 개상품정보를 Dog객체로 반환'
		Basket basket = basketViewService.getbasketView(id);
		//request영역에 '개 하나의 정보가 담긴 Dog객체'를 속성으로 공유
		request.setAttribute("basket", basket);
		
		//★혜-753p-두번째 그림(dogList.jsp) : "오늘본 개 상품 목록" 정보를 알기 위해서는 '개 하나의 상세정보 보기'를 한 후
		Cookie todayImageCookie=new Cookie("today"+id, basket.getBasket_image());//"today1","pu.jpg"
		todayImageCookie.setMaxAge(60*60*24);//60*60*24초=>24시간 설정
		response.addCookie(todayImageCookie);//반드시, 응답에 쿠키 객체를 추가한다.
		
		ActionForward forward = new ActionForward("basketView.jsp", false);
		return forward;
	}
}
