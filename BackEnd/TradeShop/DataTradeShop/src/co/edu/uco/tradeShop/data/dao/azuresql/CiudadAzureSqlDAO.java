package co.edu.uco.tradeShop.data.dao.azuresql;

import static co.edu.uco.crosscutting.util.text.UtilText.SPACE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.TradeShop.dto.CiudadDTO;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.dao.connection.ConnectionSQL;
import co.edu.uco.tradeShop.data.dao.CiudadDAO;

public class CiudadAzureSqlDAO extends ConnectionSQL implements CiudadDAO{

	private CiudadAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static CiudadAzureSqlDAO create(Connection connection) {
		return new CiudadAzureSqlDAO(connection);
	}
	
	@Override
	public List<CiudadDTO> find(CiudadDTO ciudad) {
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<CiudadDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT codigo, descripcion").append(SPACE);
		sb.append("FROM Ciudad").append(SPACE);

		if (!UtilObject.getUtilObject().isNull(ciudad)) {

			if (!UtilText.isEmpty(ciudad.getDescripcion())) {
				sb.append(setWhere ? "WHERE " : "AND ");
				sb.append("descripcion = ? ");
				parameters.add(UtilText.trim(ciudad.getDescripcion()));
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
					"There was a problem trying to retrieve IdTypes on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to retrieve IdTypes on Azure SQL Server", exception);
		}

		return results;
	}
	
	private List<CiudadDTO> executeQuery(PreparedStatement preparedStatement){
		
		List<CiudadDTO> results = new ArrayList<>();
		
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

	private List<CiudadDTO> assembleResults(ResultSet resultSet) {
		List<CiudadDTO> results = new ArrayList<>();

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

	private CiudadDTO assembleDTO(ResultSet resultSet) {
		CiudadDTO dto = new CiudadDTO();
		try {
			dto.setCodigo(resultSet.getInt("codigo"));
			dto.setDescripcion(resultSet.getString("descripcion"));

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
