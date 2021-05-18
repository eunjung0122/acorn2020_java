package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.BookDto;
import test.util.DBConnect;

public class BookDao {
	private static BookDao dao;
	private BookDao() {}
	
	public static BookDao getInstance() {
		if(dao==null) {
			dao=new BookDao();
		}
		return dao;
	}
	public boolean insert(BookDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//실행할 sql(INSERT OR UPDATE OR DELETE) 문 작성
			String sql = "INSERT INTO book"
					+ " (num,title,author,rating)"
					+ " VALUES(book_seq.NEXTVAL,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 여기서 한다.
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAuthor());
			pstmt.setDouble(3, dto.getRating());
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean update(BookDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//실행할 sql(INSERT OR UPDATE OR DELETE) 문 작성
			String sql = "UPDATE book"
					+ " SET title=?,author=?,rating=?"
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 여기서 한다.
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAuthor());
			pstmt.setDouble(3, dto.getRating());
			pstmt.setInt(4, dto.getNum());

			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//실행할 sql(INSERT OR UPDATE OR DELETE) 문 작성
			String sql = "DELETE FROM book WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 여기서 한다.
			pstmt.setInt(1, num);

			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	public List<BookDto> getList(){
		List<BookDto> list=new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = new DBConnect().getConn();
			//실행할 SELECT 문
			String sql = "SELECT num,title,author,rating"
					+ " FROM book"
					+ " ORDER BY num ASC";
			pstmt=conn.prepareStatement(sql);
			//? 에 바인딩할 내용은 여기서 바인딩한다.

			rs=pstmt.executeQuery();
			while (rs.next()) {
				//SELECT 된 결과를 여기서 추출해서 객체에 담는다. 
				int num=rs.getInt("num");
				String title=rs.getString("title");
				String author=rs.getString("author");
				double rating=rs.getDouble("rating");
				
				BookDto dto=new BookDto(num, title, author, rating);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}return list;
	}
	public BookDto getData(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookDto dto=null;
		try {
			conn = new DBConnect().getConn();
			//실행할 SELECT 문
			String sql = "SELECT title,author,rating"
					+ " FROM book"
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용은 여기서 바인딩한다.
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				//SELECT 된 결과를 여기서 추출해서 객체에 담는다. 
				String title=rs.getString("title");
				String author=rs.getString("author");
				double rating=rs.getDouble("rating");
				
				dto=new BookDto(num, title, author, rating);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}return dto;
	}
}
