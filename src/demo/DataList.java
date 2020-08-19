package demo;

import java.io.IOException; // ����Ÿ��
import java.sql.Connection; // DB ���� ��ü
import java.sql.DriverManager; // JDBC driver �˻�
import java.sql.ResultSet;
import java.sql.SQLException; // ������ ����Ÿ��
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
		super(); // �θ� ������ ����
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

		Connection conn = null; // DB ������ ��ü ����
		
		Statement stmt = null; // SQL ���� �����ͺ��̽��� ������ ���� ��ü
		ResultSet rs = null; // SQL ���ǿ� ���� ������ ���̺��� �����ϴ� ��ü
	
		String sql = "SELECT * FROM personnel";
		
		try { // jdbc connect j ���̺귯�� �ε� ���� ó��
			Class.forName("com.mysql.cj.jdbc.Driver"); // �ش� Ŭ������ �޸𸮿� �ε� �� ����
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage());
		} 

		try { // drive Ŭ������ �̿��� Ŀ�ؼ� ��ü�� localhost:3306/DB �� ���� �� ����ó��
			String url = "jdbc:mysql://localhost:3306/student_data?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			
			conn = DriverManager.getConnection(url, "root", "Weak"); // DB �α��� ������ ����
			
			stmt = conn.createStatement();
			
			// SQL ������ �����ϰ� ����� ����
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
			html += "<h1>����Ʈ</h1>";
			
			for(Map<String, Object> article : articles) {
				html += "<div>";
				html += "<div>�����ȣ:" + article.get("ID") + "</div>";
				html += "<div>�̸�:" + article.get("NAME") + "</div>";
				html += "<div>�μ�:" + article.get("DEPT") + "</div>";
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
			response.getWriter().append("localhost:3306/personnel (DateBase ���� ����)");
	
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