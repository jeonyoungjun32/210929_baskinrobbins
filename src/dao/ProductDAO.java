package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.IO;
import vo.Product;

import static db.Jdbcutil.*;

public class ProductDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
//	private MemberDAO() {}
	
	private static ProductDAO memberDAO;
	
	public static ProductDAO getInstance() {
		if(memberDAO == null) {
			memberDAO = new ProductDAO();
		}
		
		return memberDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	/*관리자 물건 등록*/
	public int insertProduct(Product product, String id) {
		sql="select concat(2,date_format(sysdate(),'%m%d%i%S'))";
		int serial_code=0;
		String product_status="O";
		int insertCount=0;
		int product_count=0;
		try {
			pstmt = con.prepareStatement(sql);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) serial_code = rs.getInt(1);
			
			sql ="insert into Product values(?,?,?,?,?,?,?,now(),?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, serial_code);
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getKcal());
			pstmt.setString(4, product.getAllergy());
			pstmt.setInt(5, product.getPrice());
			pstmt.setString(6, product.getChoice());
			pstmt.setString(7, product_status);
			pstmt.setInt(8, product_count);
			pstmt.setString(9, id);
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insertProduct 오류 : "+e);
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return insertCount;
	}

	/*물건 조회*/
	public ArrayList<Product> getListProduct() {
		sql = "select * from Product";
		ArrayList<Product> productList = new ArrayList<Product>();
		Product product= null;
		try {
			pstmt=con.prepareStatement(sql);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				do {
				product = new Product();
				
				product.setSerial_code_p(rs.getInt("serial_code_p"));
				product.setName(rs.getString("name"));
				product.setKcal(Integer.parseInt(rs.getString("kcal")));
				product.setAllergy(rs.getString("allergy"));
				product.setPrice(Integer.parseInt(rs.getString("price")));
				product.setChoice(rs.getString("choice"));
				product.setStatus(rs.getString("status"));
				product.setPI_date(rs.getString("PI_date"));
				product.setCount(Integer.parseInt(rs.getString("count")));
				product.setId(rs.getString("id"));
				
				productList.add(product);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("getListProduct 오류 : "+e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return productList;
	}
	
	//아이스케잌 조회
	public ArrayList<Product> getListIceCake() {
		sql = "select * from Product where choice = ?";
		ArrayList<Product> iceCakeList = new ArrayList<Product>();
		Product product= null;
		String product_choice="1";
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,product_choice);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				do {
				product = new Product();
				
				product.setSerial_code_p(rs.getInt("serial_code_p"));
				product.setName(rs.getString("name"));
				product.setKcal(Integer.parseInt(rs.getString("kcal")));
				product.setAllergy(rs.getString("allergy"));
				product.setPrice(Integer.parseInt(rs.getString("price")));
				product.setChoice(rs.getString("choice"));
				product.setStatus(rs.getString("status"));
				product.setPI_date(rs.getString("PI_date"));
				product.setCount(Integer.parseInt(rs.getString("count")));
				product.setId(rs.getString("id"));
				
				iceCakeList.add(product);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("getListProduct 오류 : "+e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return iceCakeList;
	}
	
	//디저트 조회
	public ArrayList<Product> getListDessert() {
		sql = "select * from Product where choice = ?";
		ArrayList<Product> dessertList = new ArrayList<Product>();
		Product product= null;
		String product_choice="4";
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,product_choice);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				do {
				product = new Product();
				
				product.setSerial_code_p(rs.getInt("serial_code_p"));
				product.setName(rs.getString("name"));
				product.setKcal(Integer.parseInt(rs.getString("kcal")));
				product.setAllergy(rs.getString("allergy"));
				product.setPrice(Integer.parseInt(rs.getString("price")));
				product.setChoice(rs.getString("choice"));
				product.setStatus(rs.getString("status"));
				product.setPI_date(rs.getString("PI_date"));
				product.setCount(Integer.parseInt(rs.getString("count")));
				product.setId(rs.getString("id"));
				
				dessertList.add(product);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("getListProduct 오류 : "+e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return dessertList;
	}
	
	//음료 조회
	public ArrayList<Product> getListBeverage() {
		sql = "select * from Product where choice = ?";
		ArrayList<Product> beverageList = new ArrayList<Product>();
		Product product= null;
		String product_choice="2";
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,product_choice);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				do {
				product = new Product();
				
				product.setSerial_code_p(rs.getInt("serial_code_p"));
				product.setName(rs.getString("name"));
				product.setKcal(Integer.parseInt(rs.getString("kcal")));
				product.setAllergy(rs.getString("allergy"));
				product.setPrice(Integer.parseInt(rs.getString("price")));
				product.setChoice(rs.getString("choice"));
				product.setStatus(rs.getString("status"));
				product.setPI_date(rs.getString("PI_date"));
				product.setCount(Integer.parseInt(rs.getString("count")));
				product.setId(rs.getString("id"));
				
				beverageList.add(product);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("getListProduct 오류 : "+e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return beverageList;
	}
	
	//커피 조회
	public ArrayList<Product> getListCoffee() {
		sql = "select * from Product where choice = ?";
		ArrayList<Product> coffeeList = new ArrayList<Product>();
		Product product= null;
		String product_choice="3";
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,product_choice);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				do {
				product = new Product();
				
				product.setSerial_code_p(rs.getInt("serial_code_p"));
				product.setName(rs.getString("name"));
				product.setKcal(Integer.parseInt(rs.getString("kcal")));
				product.setAllergy(rs.getString("allergy"));
				product.setPrice(Integer.parseInt(rs.getString("price")));
				product.setChoice(rs.getString("choice"));
				product.setStatus(rs.getString("status"));
				product.setPI_date(rs.getString("PI_date"));
				product.setCount(Integer.parseInt(rs.getString("count")));
				product.setId(rs.getString("id"));
				
				coffeeList.add(product);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("getListProduct 오류 : "+e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return coffeeList;
	}
	
	//상품 코드로 상품 조회
	public Product getProduct(int serial_code_p) {
		sql="select * from Product where serial_code_p = ?";
		Product product = null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, serial_code_p);
			
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				product = new Product();
				product.setSerial_code_p(rs.getInt("serial_code_p"));
				product.setName(rs.getString("name"));
				product.setKcal(rs.getInt("kcal"));
				product.setAllergy(rs.getString("allergy"));
				product.setPrice(rs.getInt("price"));
				product.setChoice(rs.getString("choice"));
				product.setStatus(rs.getString("status"));
				product.setPI_date(rs.getString("PI_date"));
				product.setCount(rs.getInt("count"));
				product.setId(rs.getString("id"));
				
				}
		} catch (Exception e) {
			System.out.println("getProduct 오류 : "+e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return product;
	}

	//상품 정보 수정
	public int ProductUpdate(int serial_code_p, String name, String allergy, int kcal, int price) {
		sql ="update Product set name = ?, kcal = ?, allergy = ?, price = ? where serial_code_p = ? ";
		int productUpdateCount=0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, kcal);
			pstmt.setString(3, allergy);
			pstmt.setInt(4, price);
			pstmt.setInt(5, serial_code_p);
			
			productUpdateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("ProductUpdate 오류 : "+e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return productUpdateCount;
	}
	//수정해야함

	//상품리스트에서 체크한것을 찾기
	public ArrayList<Product> adminGetProduct(String[] productCheckCode) {
		ArrayList<Product> productList = new ArrayList<Product>();
		Product product = null;
		if (productCheckCode != null) {

			for (int i = 0; i < productCheckCode.length; i++) {
				sql = "select * from Product where serial_code_p = ?";
				try {
					pstmt = con.prepareStatement(sql);

					pstmt.setString(1, productCheckCode[i]);

					rs = pstmt.executeQuery();

					if (rs.next()) {
						product = new Product(
								rs.getInt("serial_code_p"),
								rs.getString("name"),
								rs.getInt("kcal"),
								rs.getString("allergy"),
								rs.getInt("price"),
								rs.getString("choice"),
								rs.getString("status"),
								rs.getString("PI_date"),
								rs.getInt("count"),
								rs.getString("id"));

							productList.add(product);
					}

				} catch (Exception e) {
					System.out.println("adminGetProduct 오류 : " + e);
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rs);
				}
			}
		}
		return productList;
	}

	//상품 체크박스 선택시 삭제
	public int arrProductDelete(Product products) {
		int arrProductDeleteCount = 0;

		sql = "delete from Product where serial_code_p =?";

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, products.getSerial_code_p());

			arrProductDeleteCount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("arrProductDelete 오류 : " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return arrProductDeleteCount;
	}

	//상품 체크박스 선택한 정보 가져오기
	public ArrayList<Product> arrProductInfo(String[] productCheckCode) {
		ArrayList<Product> productList = new ArrayList<Product>();
		Product product = null;
		if (productCheckCode != null) {

			for (int i = 0; i < productCheckCode.length; i++) {
				sql = "select * from Product where serial_code_p = ?";
				try {
					pstmt = con.prepareStatement(sql);

					pstmt.setString(1, productCheckCode[i]);

					rs = pstmt.executeQuery();

					if (rs.next()) {
						product = new Product(
								rs.getInt("serial_code_p"),
								rs.getString("name"),
								rs.getInt("kcal"),
								rs.getString("allergy"),
								rs.getInt("price"),
								rs.getString("choice"),
								rs.getString("status"),
								rs.getString("PI_date"),
								rs.getInt("count"),
								rs.getString("id"));

							productList.add(product);
					}

				} catch (Exception e) {
					System.out.println("arrProductInfo 오류 : " + e);
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rs);
				}
			}
		}
		return productList;
	}

	//IO 등록(입고)
	//serial_code : 상품 코드 / product_count : 상품 갯수 / strserial_code : 상품 앞번호 추출 (1 : 아이스크림/ 2 :상품)
	public int arrAdminIOupdate(int[] serial_code_p, int[] product_count, String[] strserial_code) {
		//sql 2개던지기 IO Product
		int IOcount=0;
		int productCode=0;
		int icecreamCode=0;
		String IO_status= "I";
		int ice_insert_count=0;
		int ice_update_count=0;
		int product_insert_count=0;
		int product_update_count=0;
		int ReturnValue=0;
		for(int i =0; i<strserial_code.length; i++) {
			/*주분 번호 */
			sql="select count(IO_index)+1 as IOcount from IO";
			try {
				pstmt = con.prepareStatement(sql);
				
				rs=pstmt.executeQuery();
				
				if(rs.next()) IOcount=rs.getInt("IOcount");
				
			} catch (Exception e) {
				System.out.println("arrAdminIOupdate 1-1 오류 : " + e);
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			
			/*아이스크림*/ 
			if(strserial_code[i].equalsIgnoreCase("1")) {
				
				sql="";
				
			/*상품*/
			} else if (strserial_code[i].equalsIgnoreCase("2")) {
				
				sql="insert into IO values (?,?,?,now(),?,?)";
				try {
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, IOcount);
					pstmt.setString(2, IO_status);
					pstmt.setInt(3, product_count[i]);
					pstmt.setInt(4, serial_code_p[i]);
					pstmt.setInt(5, icecreamCode);
					
					product_insert_count = pstmt.executeUpdate();
					
				} catch (Exception e) {
					System.out.println("arrAdminIOupdate 1-2 오류 : " + e);
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
				sql="update Product set status = ?, count = count + ? where serial_code_p = ?";
				
				try {
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, IO_status);
					pstmt.setInt(2, product_count[i]);
					pstmt.setInt(3, serial_code_p[i]);
					
					product_update_count = pstmt.executeUpdate();
					
				} catch (Exception e) {
					System.out.println("arrAdminIOupdate 1-3 오류 : " + e);
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
			}
		}
		
		if(product_insert_count>0 && product_update_count >0) {
			ReturnValue=1;
		}
		
		return ReturnValue;
	}
	
	//IO 리스트 출력
	public ArrayList<IO> selectIOlist() {
		sql="select * from IO";
		IO io = null;
		ArrayList<IO> ioList =new ArrayList<IO>();
		try {
			pstmt=con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
				io = new IO(
						rs.getInt("IO_index"),
						rs.getString("IO_inout"),
						rs.getInt("IO_count"),
						rs.getString("IO_date"),
						rs.getInt("serial_code_p"),
						rs.getInt("serial_code_i"));
				
				ioList.add(io);
				} while(rs.next());
			}
			
		} catch (Exception e) {
			System.out.println("selectIOlist 오류 : " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return ioList;
	}
	//id로 조회수 1증가
	public int updateReadCount(int id) {
		//String sql = "update dog SET readcount=readcount+1 where id=?";
		String sql = "update basKet_detail SET readcount=readcount+1 where id="+id;
		int updateCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			//pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();//업데이트가 성공하면 1리턴받음
			
		} catch (Exception e) {					
			System.out.println("1증가 하는곳  에러 :" + e);//e:예외종류+예외메세지
		}finally {
			close(rs);
			close(pstmt);			
		}
		
		return updateCount;
	}
	//id로 아이스크림 정보를 조회하여 Ice객체를 반환
	public Product selectIce(int id) {
		Product ice = null;
		
		try {
			pstmt = con.prepareStatement("select * from basket_detail where id = "+id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ice = new Product(
								rs.getInt("serial_code_p"),
								rs.getString("name"),
								rs.getInt("kcal"),
								rs.getString("allergy"),
								rs.getInt("price"),
								rs.getString("choice"),
								rs.getString("status"),
								rs.getString("PI_date"),
								rs.getInt("count"),
								rs.getString("id"));
			}
		} catch (Exception e) {
			System.out.println("selectIce 에러 "+e);
			close(rs);
			close(pstmt);
		}
		
		return ice;
		
		
	}

}
