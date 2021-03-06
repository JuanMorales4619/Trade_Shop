package co.edu.uco.tradeShop.data.dao.azuresql;

import static co.edu.uco.crosscutting.util.text.UtilText.SPACE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.uco.TradeShop.dto.ProductoDTO;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.dao.connection.ConnectionSQL;
import co.edu.uco.tradeShop.data.dao.ProductoDAO;


public class ProductoAzureSqlDAO extends ConnectionSQL implements ProductoDAO{
	
	private ProductoAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static ProductoDAO create(Connection connection) {
		return new ProductoAzureSqlDAO(connection);
	}
	
	@Override
	public void create(ProductoDTO producto) {
		String sql = "INSERT INTO producto(nombre,imagen,TipoProducto) VALUES(?,?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setString(2, producto.getImagen());
			preparedStatement.setString(3, producto.getTipoProducto());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to create the new Product on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to create the new Product on Azure SQL Server", exception);
		}
	}
	
	@Override
	public void update(ProductoDTO producto) {
		String sql = "INSERT INTO publicacion(descripcion,cantidad,precio,tipoventa,vendedor) VALUES(?,?,?,?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setString(1, producto.getImagen());
			preparedStatement.setString(1, producto.getTipoProducto());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to update the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to update the new IdType on Azure SQL Server", exception);
		}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM producto WHERE id=?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to delete the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to delete the new IdType on Azure SQL Server", exception);
		}

	}

	@Override
	public List<ProductoDTO> find(ProductoDTO producto) {
		List<Object> parameters = new ArrayList<>();
		List<ProductoDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT id, name").append(SPACE);
		sb.append("FROM IdType").append(SPACE);

		sb.append("ORDER BY name ASC");

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sb.toString())) {

			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}

			results = executeQuery(preparedStatement);

		}catch (TradeShopException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to retrieve IdTypes on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to retrieve IdTypes on Azure SQL Server", exception);
		}

		return results;
	}
	
	private List<ProductoDTO> executeQuery(PreparedStatement preparedStatement){
		
		List<ProductoDTO> results = new ArrayList<>();
		
		try (ResultSet resultset = preparedStatement.executeQuery()) {
			results = assembleResults(resultset);
		}catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to execute the Query for recovery the IdTypes on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to execute the Query for recovery the IdTypes on Azure SQL Server", exception);
		}
		return results;
	}

	private List<ProductoDTO> assembleResults(ResultSet resultSet) {
		List<ProductoDTO> results = new ArrayList<>();

		try {
			while (resultSet.next()) {
				results.add(assembleDTO(resultSet));
			}
		} catch (TradeShopException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to recover the IdTypes on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to recover the IdTypes on Azure SQL Server", exception);
		}

		return results;
	}

	private ProductoDTO assembleDTO(ResultSet resultSet) {
		ProductoDTO dto = new ProductoDTO();
		try {
			dto.setCodigo(resultSet.getInt("codigo"));

		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to assemble the IdTypes on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to assemble the IdTypes on Azure SQL Server", exception);
		}

		return dto;
	}
}
