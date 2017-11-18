package com.skilldistillery.shopping.data;

import java.util.List;


public class ShoppingListDAODbImpl implements ShoppingListDAO {
	private static final String url = "jdbc:mysql://localhost:3306/shoppinglistdb";
	private String user = "shopper";
	private String pass = "shopper";
	
	
	public ShoppingListDAODbImpl() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public ShoppingList getListItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingList addItemToList(ShoppingList s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoppingList> getShoppingList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingList updateShoppingList(ShoppingList s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingList deleteItemFromList(ShoppingList s) {
		// TODO Auto-generated method stub
		return null;
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
*/
