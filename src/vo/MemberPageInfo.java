package vo;
//회원 리스트 페이지뷰 만들기위한 vo
public class MemberPageInfo {
	private int page;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int MemberListCount;	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getMemberListCount() {
		return MemberListCount;
	}
	public void setMemberListCount(int memberListCount) {
		MemberListCount = memberListCount;
	}
	
}
