package model;

import java.util.*;

import org.apache.catalina.connector.Request;

import java.sql.*;

public class PostDAO {
	//게시글 목록
	public ArrayList<PostVO> list(){
		ArrayList<PostVO> array = new ArrayList<PostVO>();
		try {
			String sql = "select * from posts order by id desc limit 0,10";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PostVO vo = new PostVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setDate(rs.getTimestamp("date"));
				array.add(vo);
//				System.out.println(vo.toString());
			}
		}catch(Exception e) {
			System.out.println("게시글 목록오류"+e.toString());
		}
		return array;
	}
	
	
	//게시글 등록
	public void insert(PostVO vo) {
		try {
			String sql = "insert into posts(title,body,writer) values(?,?,?)";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getBody());
			ps.setString(3,vo.getWriter());
			ps.execute();
		}catch(Exception e){
			System.out.println("게시글등록오류"+e.toString());
		}
	}
	
	//게시글 읽기
	public PostVO read(int id) {
		PostVO vo = new PostVO();
		try {
			String sql = "select * from posts where id =" +id;
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setDate(rs.getTimestamp("date"));
				vo.setBody(rs.getString("body"));
			}
		}catch(Exception e) {
			System.out.println("게시물읽기오류"+e.toString());
		}
		return vo;
	}
	
	//게시글 삭제
	public void delete(int id) {
		try {
			String sql = "delete from posts where id="+id;
			PreparedStatement ps = DB.CON.prepareStatement(sql);		
			ps.execute();
		}catch(Exception e){
			System.out.println("게시글삭제오류"+e.toString());
		}
	}
	
	//게시글 수정
	public void update(PostVO vo) {
		try {
			String sql = "update posts set title = ?, body = ?, date = now() where id = ?";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getBody());
			ps.setInt(3,vo.getId());
			ps.execute();
		}catch(Exception e){
			System.out.println("게시글수정오류"+e.toString());
		}
	}
	
}
