package pl.kjanikowski.SkiJumpCRUD.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import pl.kjanikowski.SkiJumpCRUD.domain.SkiJump;

public class SkiJumpManagerJDBC implements SkiJumpManager {
	
	private String SqlAddSkiJump = "INSERT INTO SkiJump(name, size, date, hasRecord) VALUES (?,?,?,?)";
	private String SqlCreateTable = "CREATE TABLE SkiJump(id bigint GENERATED BY DEFAULT AS IDENTITY, name varchar(30), size int, date DATE, hasRecord BOOLEAN)";
	
	private Connection conn;
	
	
	private PreparedStatement AddSkiJumpPStmt; 
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean deleteSkiJump(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SkiJump> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
