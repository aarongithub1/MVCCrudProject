package com.skilldistillery.shopping.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;

@Primary
@Repository
public class ShoppingListDAODbImpl implements ShoppingListDAO {
	private static final String url = "jdbc:mysql://localhost:3306/shoppinglistdb";
	private String user = "shopper";
	private String pass = "shopper";
	
	
	public ShoppingListDAODbImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}

//----------------------------------- Create -------------------------------------------//
	@Override
	public ShoppingList addItemToList(ShoppingList s) {
		String sql = "INSERT INTO item (list_item, number_of_items, item_price) "
				  + " VALUES (?, ?, ?) "; 

		Connection conn = null; 
		try {
			conn = DriverManager.getConnection(url, user, pass); 
			conn.setAutoCommit(false);
			
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
			System.out.println(s);
			
			stmt.setString(1, s.getListItem());
			stmt.setInt(2, s.getNumberOfItems());
			stmt.setDouble(3, s.getItemPrice());
			
			int uc = stmt.executeUpdate();
			System.out.println(uc + " item(s) created");
			ResultSet key = stmt.getGeneratedKeys();
			
			while(key.next()) {
				s.setId(key.getInt(1));
			}
			
			System.out.println(s.getId());
			conn.commit();
			
			stmt.close();
			conn.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null; 
		}
		return s;
	}
	
//----------------------------------- Read All Items ----------------------------------------//
	@Override
	public List<ShoppingList> getShoppingList() {
		List<ShoppingList> allItems = new ArrayList<>();
		ShoppingList item = null;
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT * FROM item";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String listItem = rs.getString(2);
				int numOfItem = rs.getInt(3);
				double price = rs.getDouble(4);
				item = new ShoppingList(id, listItem, numOfItem, price);
				allItems.add(item);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allItems;
	}
	
//----------------------------------- Read Item by ID ---------------------------------------//
	@Override
	public ShoppingList getListItemById(int id) {
		ShoppingList item = null;
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, list_item, number_of_items, item_price FROM item WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
				String listItem = rs.getString(2);
				int numOfItem = rs.getInt(3);
				double price = rs.getDouble(4);
				item = new ShoppingList(id, listItem, numOfItem, price);
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return item;
		
	}

	


//----------------------------------- Update -------------------------------------------//
	@Override
	public ShoppingList updateShoppingList(ShoppingList s) {
		String sql = "UPDATE item SET list_item = ?, number_of_items = ?, item_price = ? WHERE id = ? "; 

		Connection conn = null; 
		try {
			conn = DriverManager.getConnection(url, user, pass); 
			conn.setAutoCommit(false);
			
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
			System.out.println(s);
			
			stmt.setString(1, s.getListItem());
			stmt.setInt(2, s.getNumberOfItems());
			stmt.setDouble(3, s.getItemPrice());
			stmt.setInt(4, s.getId());
			
			int uc = stmt.executeUpdate();
			System.out.println(uc + " item(s) created");
			ResultSet key = stmt.getGeneratedKeys();
			
			while(key.next()) {
				s.setId(key.getInt(1));
			}
			
			conn.commit();
			
			stmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null; 
		}
		return s;
	}

//----------------------------------- Delete -------------------------------------------//
	@Override
	public ShoppingList deleteItemFromList(ShoppingList s) {
		String sql = "DELETE FROM item WHERE id = ?";
		
		Connection conn = null; 
		try {
			conn = DriverManager.getConnection(url, user, pass); 
			conn.setAutoCommit(false);
			
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
			stmt.setInt(1, s.getId());
			int uc = stmt.executeUpdate();
			System.out.println(uc + " item(s) deleted");
			
			conn.commit();
			
			stmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return s; 
		}
		return s;
	}

}

/*
 *package com.skilldistillery.pokemon.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class PokemonDAODbImpl implements PokemonDAO {
    private static final String url = "jdbc:mysql://localhost:3306/pokemondb";
    private String user = "pikachu";
    private String pass = "pikachu";
    
    private int getPokemonTypeIdByName(String typeName) {
        int type_id = 0;
                // SELECT id FROM pokemon_type WHERE name = ?
        // stmt.setString(1,typeName);
        return type_id;
    }

    @Override
    public Pokemon addPokemon(Pokemon p) {
        // try/catch for SQLException
        // Get connection
        // SQL string
        String sql = "INSERT INTO pokemon (id, name, type_id) VALUES (?,?,?)";
        // stmt.setInt(3, this.getPokemonTypeIdByName(p.getType());
        // PreparedStatement for sql
        // stmt.executeUpdate
        // Get generated keys
        // Set the id of the passed-in object using generated key
        // Construct new Pokemon()
        // Close everything.
        // Return original pokemon, but it now has the database-generated id.
        return p;
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        List<Pokemon> list = new ArrayList<>();
        // try/catch for SQLException
        // Get connection
        // SQL string
                // String sql = "SELECT id, name FROM pokemon";
               String sql = "SELECT p.id, p.name, t.name FROM pokemon p JOIN pokemon_type t ON p.type_id = t.id";
        // PreparedStatement for sql
        // stmt.executeQuery
        // iterate over ResultSet
        // Construct new Pokemon(), add to list
        // Close everything.
        return list;
    }

    @Override
    public Pokemon getPokemonByNumber(int n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pokemon updatePokemon(Pokemon p) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pokemon deletePokemon(Pokemon p) {
        // TODO Auto-generated method stub
        return null;
    }

}

package demo;

import java.util.Scanner;
import java.sql.*;

public class ActorAdder {

    public static void main(String[] args) {
        ActorAdder adder = new ActorAdder();
        Scanner input = new Scanner(System.in);
        adder.addActor(input);

        input.close();

    }

    private void addActor(Scanner input) {
        System.out.print("Enter your first name: ");
        String fName = input.next();
        System.out.print("Enter your last name: ");
        String lName = input.next();
        String url = "jdbc:mysql://localhost:3306/sdvid";
        String user = "student";
        String pword = "student";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pword);
            conn.setAutoCommit(false);
            String sql = "INSERT INTO actor (first_name, last_name) VALUES (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, fName);
            stmt.setString(2, lName);
            int uc = stmt.executeUpdate();
            if (uc == 1) {
                System.out.println(fName + " " + lName + " added as an actor.");
                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    int actorId = keys.getInt(1);
                    System.out.print("Enter a film ID: ");
                    int filmId = input.nextInt();
                    sql = "INSERT INTO film_actor (film_id,actor_id) VALUES (?,?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, filmId);
                    stmt.setInt(2, actorId);
                    uc = stmt.executeUpdate();
                    if (uc == 1) {
                        conn.commit();
                        System.out.println(fName + " " + lName + " added to film " + filmId);
                    }
                }
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Operation failed.  Not committing.");
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }

}

*/
