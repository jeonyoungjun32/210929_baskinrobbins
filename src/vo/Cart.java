package vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Cart {
	private String image;// 아이스크림 상품 이미지
	private String kind;// 아이스크림 종류
	private int price;// 가격
	private int qty;// 수량

	private String encodingKind;// ★★인코딩된 쓸지안쓸지 모르지만 인코딩된 아이스크림 상품명 추가

	public String getEncodingKind() {// ★★
		try {
			encodingKind = URLEncoder.encode(kind, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return encodingKind;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setEncodingKind(String encodingKind) {
		this.encodingKind = encodingKind;
	}
	

}
