package co.edu.uco.tradeShop.data.dao.azuresql;

import static co.edu.uco.crosscutting.util.text.UtilText.SPACE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.uco.TradeShop.dto.TipoProductoDTO;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.dao.connection.ConnectionSQL;
import co.edu.uco.tradeShop.data.dao.TipoProductoDAO;

public class TipoProductoAzureSqlDAO extends ConnectionSQL implements TipoProductoDAO{
	
	private TipoProductoAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static TipoProductoAzureSqlDAO create(Connection connection) {
		return new TipoProductoAzureSqlDAO(connection);
	}
	
	@Override
	public List<TipoProductoDTO> find(TipoProductoDTO tipoProducto) {
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<TipoProductoDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT codigo, descripcion").append(SPACE);
		sb.append("FROM TipoProducto").append(SPACE);

		if (!UtilObject.getUtilObject().isNull(tipoProducto)) {

			if (!UtilText.isEmpty(tipoProducto.getDescripcion())) {
				sb.append(setWhere ? "WHERE " : "AND ");
				sb.append("descripcion = ? ");
				parameters.add(UtilText.trim(tipoProducto.getDescripcion()));
			}

		}

		sb.append("ORDER BY descripcion ASC");

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sb.toString())) {

			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}

			results = executeQuery(preparedStatement);

		}catch (TradeShopException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to retrieve kind of products on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to retrieve kind of products on Azure SQL Server", exception);
		}

		return results;
	}
	
	private List<TipoProductoDTO> executeQuery(PreparedStatement preparedStatement){
		
		List<TipoProductoDTO> results = new ArrayList<>();
		
		try (ResultSet resultset = preparedStatement.executeQuery()) {
			results = assembleResults(resultset);
		}catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to execute the Query for recovery the kind of products on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to execute the Query for recovery the kind of products on Azure SQL Server", exception);
		}
		return results;
	}

	private List<TipoProductoDTO> assembleResults(ResultSet resultSet) {
		List<TipoProductoDTO> results = new ArrayList<>();

		try {
			while (resultSet.next()) {
				results.add(assembleDTO(resultSet));
			}
		} catch (TradeShopException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to recover the kind of products on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to recover the kind of products on Azure SQL Server", exception);
		}

		return results;
	}

	private TipoProductoDTO assembleDTO(ResultSet resultSet) {
		TipoProductoDTO dto = new TipoProductoDTO();
		try {
			dto.setCodigo(resultSet.getInt("codigo"));
			dto.setDescripcion(resultSet.getString("descripcion"));

		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to assemble the kind of products on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to assemble the kind of products on Azure SQL Server", exception);
		}

		return dto;
	}
}
