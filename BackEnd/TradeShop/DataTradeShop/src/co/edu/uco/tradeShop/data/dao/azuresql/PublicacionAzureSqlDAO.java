package co.edu.uco.tradeShop.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.TradeShop.dto.PublicacionDTO;
import static co.edu.uco.crosscutting.util.text.UtilText.SPACE;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.dao.connection.ConnectionSQL;
import co.edu.uco.tradeShop.data.dao.PublicacionDAO;

public class PublicacionAzureSqlDAO extends ConnectionSQL implements PublicacionDAO{

	private PublicacionAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static PublicacionDAO create(Connection connection) {
		return new PublicacionAzureSqlDAO(connection);
	}
	
	@Override
	public void create(PublicacionDTO publicacion) {
		String sql = "INSERT INTO publicacion(descripcion,cantidad,precio,tipoventa,vendedor, producto) VALUES(?,?,?,?,?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, publicacion.getDescripcion());
			preparedStatement.setInt(1, publicacion.getCantidad());
			preparedStatement.setInt(1, publicacion.getPrecio());
			preparedStatement.setInt(1, publicacion.getTipoVenta().getCodigo());
			preparedStatement.setInt(1, publicacion.getVendedor().getCodigo());
			preparedStatement.setInt(1, publicacion.getProducto().getCodigo());


			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to create the new Publication on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to create the new Publication on Azure SQL Server", exception);
		}
	}

	@Override
	public void update(PublicacionDTO publicacion) {
		String sql = "INSERT INTO publicacion(descripcion,cantidad,precio,tipoventa,vendedor) VALUES(?,?,?,?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, publicacion.getDescripcion());
			preparedStatement.setInt(1, publicacion.getCantidad());
			preparedStatement.setInt(1, publicacion.getPrecio());
			preparedStatement.setInt(1, publicacion.getTipoVenta().getCodigo());
			preparedStatement.setInt(1, publicacion.getVendedor().getCodigo());

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
		String sql = "DELETE FROM IdType WHERE id=?";

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
	public List<PublicacionDTO> find(PublicacionDTO publicacion) {
		List<Object> parameters = new ArrayList<>();
		List<PublicacionDTO> results = new ArrayList<>();

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
	
	private List<PublicacionDTO> executeQuery(PreparedStatement preparedStatement){
		
		List<PublicacionDTO> results = new ArrayList<>();
		
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

	private List<PublicacionDTO> assembleResults(ResultSet resultSet) {
		List<PublicacionDTO> results = new ArrayList<>();

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

	private PublicacionDTO assembleDTO(ResultSet resultSet) {
		PublicacionDTO dto = new PublicacionDTO();
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
