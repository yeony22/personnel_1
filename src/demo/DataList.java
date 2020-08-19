package demo;

import java.io.IOException; // 예외타입
import java.sql.Connection; // DB 연동 객체
import java.sql.DriverManager; // JDBC driver 검색
import java.sql.ResultSet;
import java.sql.SQLException; // 쿼리문 예외타입
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/List")
public class DataList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataList() {
		super(); // 부모 생성자 실행
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		Connection conn = null; // DB 연동할 객체 생성
		
		Statement stmt = null; // SQL 문을 데이터베이스에 보내기 위한 객체
		ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체
	
		String sql = "SELECT * FROM personnel";
		
		try { // jdbc connect j 라이브러리 로딩 예외 처리
			Class.forName("com.mysql.cj.jdbc.Driver"); // 해당 클래스가 메모리에 로드 및 실행
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage());
		} 

		try { // drive 클래스를 이용해 커넥션 객체에 localhost:3306/DB 와 연동 및 예외처리
			String url = "jdbc:mysql://localhost:3306/student_data?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			
			conn = DriverManager.getConnection(url, "root", "Weak"); // DB 로그인 정보로 연동
			
			stmt = conn.createStatement();
			
			// SQL 문장을 실행하고 결과를 리턴
			// stmt.excuteQuery(SQL) : select
			// stmt.excuteUpdate(SQL) : insert, update, delete ..
			
			rs = stmt.executeQuery(sql);
			
			List<Map<String, Object>> articles = new ArrayList<>();
			
			while (rs.next()) {
				Map<String, Object> article = new HashMap<>();
				
				article.put("ID", rs.getString("ID"));
				article.put("NAME", rs.getString("NAME"));
				article.put("DEPT", rs.getString("DEPT"));
				
				System.out.println(article);
				articles.add(article);
				
			}
			
			String html ="";
			html += "<h1>리스트</h1>";
			
			for(Map<String, Object> article : articles) {
				html += "<div>";
				html += "<div>사원번호:" + article.get("ID") + "</div>";
				html += "<div>이름:" + article.get("NAME") + "</div>";
				html += "<div>부서:" + article.get("DEPT") + "</div>";
				html += "<hr>";
				html += "</div>";
			}
			
			response.getWriter().append(html);
			
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} finally {
			response.getWriter().append(conn.toString() + "<br/>");
			response.getWriter().append("localhost:3306/personnel (DateBase 연동 성공)");
	
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}