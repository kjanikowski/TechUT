package pl.kjanikowski.SkiJumpCRUD.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.kjanikowski.SkiJumpCRUD.domain.SkiJump;

public class SkiJumpManagerJDBC implements SkiJumpManager {
	
	private String SqlAddSkiJump = "INSERT INTO SkiJump(name, size, date, hasRecord) VALUES (?,?,?,?)";
	private String SqlCreateTable = "CREATE TABLE SkiJump(id bigint GENERATED BY DEFAULT AS IDENTITY, name varchar(30) UNIQUE, size int, date DATE, hasRecord BOOLEAN)";
	private String SqlDeleteSkiJump = "DELETE FROM SkiJump WHERE id=?";
	private String SqlGetAllSkiJumps= "SELECT id, name, size, date, hasRecord FROM SkiJump";
	private String SqlFindByName = "SELECT id, name, size, date, hasRecord FROM SkiJump WHERE name=?";
	
	private Connection conn;
	
	
	private PreparedStatement AddSkiJumpPStmt; 
	private PreparedStatement DeleteSkiJump;
	private PreparedStatement getAllSkiJumps;
	private PreparedStatement findByName;
	private Statement stmt; 
	
	
	
	private final String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
	
	public SkiJumpManagerJDBC() {
		
		try {
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			
			
			
			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);
			boolean tableExists = false; 
			
			while(rs.next()) {
				if("SkiJump".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}
			
			if(tableExists == false) {
				stmt.executeUpdate(SqlCreateTable);
			}
			
			AddSkiJumpPStmt = conn.prepareStatement(SqlAddSkiJump);
			DeleteSkiJump = conn.prepareStatement(SqlDeleteSkiJump);
			getAllSkiJumps = conn.prepareStatement(SqlGetAllSkiJumps);
			findByName = conn.prepareStatement(SqlFindByName);
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	

	@Override
	public boolean addSkiJump(SkiJump skiJump) {
		
		try {
			AddSkiJumpPStmt.setString(1, skiJump.getName());
			AddSkiJumpPStmt.setInt(2, skiJump.getSize());
			AddSkiJumpPStmt.setDate(3, skiJump.getDoc());
			AddSkiJumpPStmt.setBoolean(4, skiJump.isHasRecord());
			AddSkiJumpPStmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}

	@Override
	public boolean deleteSkiJump(long id) {
		try {
			DeleteSkiJump.setLong(1, id);
			DeleteSkiJump.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public List<SkiJump> getAll() {
		
		List<SkiJump> skiJumps = new ArrayList<SkiJump>();
		
		try {
			ResultSet rs = getAllSkiJumps.executeQuery();
			
			while(rs.next()) {
				
				SkiJump ski = new SkiJump();
				ski.setId(rs.getLong("id"));
				ski.setName(rs.getString("name"));
				ski.setSize(rs.getInt("size"));
				ski.setDoc(rs.getDate("date"));
				ski.setHasRecord(rs.getBoolean("hasRecord"));
				skiJumps.add(ski);
				
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return skiJumps;
	}


	@Override
	public boolean addAllSkiJumps(List<SkiJump> skiJumps) {
		
		try {
			conn.setAutoCommit(false);
			
			for(int i = 0; i < skiJumps.size(); i++) {
				
				AddSkiJumpPStmt.setString(1, skiJumps.get(i).getName());
				AddSkiJumpPStmt.setInt(2, skiJumps.get(i).getSize());
				AddSkiJumpPStmt.setDate(3, skiJumps.get(i).getDoc());
				AddSkiJumpPStmt.setBoolean(4, skiJumps.get(i).isHasRecord());
				AddSkiJumpPStmt.execute();
				
				
			}
			
			conn.commit();
			
			conn.setAutoCommit(true);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Critical error!");
				e1.printStackTrace();
			}
		}
		
		
		
		return true;
	}




	@Override
	public SkiJump findByName(String name) {
		SkiJump ski = new SkiJump();
		
		try {
			findByName.setString(1, name);
			ResultSet rs = findByName.executeQuery();
			
			while(rs.next()) {
				ski.setId(rs.getLong("id"));
				ski.setName(rs.getString("name"));
				ski.setSize(rs.getInt("size"));
				ski.setDoc(rs.getDate("date"));
				ski.setHasRecord(rs.getBoolean("hasRecord"));
			}
			
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return ski;
	}

}
