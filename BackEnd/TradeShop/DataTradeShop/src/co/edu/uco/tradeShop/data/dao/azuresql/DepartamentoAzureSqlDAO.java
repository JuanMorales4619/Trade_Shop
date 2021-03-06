package co.edu.uco.tradeShop.data.dao.azuresql;

import static co.edu.uco.crosscutting.util.text.UtilText.SPACE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.TradeShop.dto.DepartamentoDTO;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.dao.connection.ConnectionSQL;
import co.edu.uco.tradeShop.data.dao.DepartamentoDAO;

public class DepartamentoAzureSqlDAO extends ConnectionSQL implements DepartamentoDAO{
	
	private DepartamentoAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static DepartamentoAzureSqlDAO create(Connection connection) {
		return new DepartamentoAzureSqlDAO(connection);
	}
	
	@Override
	public List<DepartamentoDTO> find(DepartamentoDTO departamento) {
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<DepartamentoDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT codigo, descripcion").append(SPACE);
		sb.append("FROM Departamento").append(SPACE);

		if (!UtilObject.getUtilObject().isNull(departamento)) {

			if (!UtilText.isEmpty(departamento.getDescripcion())) {
				sb.append(setWhere ? "WHERE " : "AND ");
				sb.append("descripcion = ? ");
				parameters.add(UtilText.trim(departamento.getDescripcion()));
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
					"There was a problem trying to retrieve Departments on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to retrieve Departments on Azure SQL Server", exception);
		}

		return results;
	}
	
	private List<DepartamentoDTO> executeQuery(PreparedStatement preparedStatement){
		
		List<DepartamentoDTO> results = new ArrayList<>();
		
		try (ResultSet resultset = preparedStatement.executeQuery()) {
			results = assembleResults(resultset);
		}catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to execute the Query for recovery the Departments on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to execute the Query for recovery the Departments on Azure SQL Server", exception);
		}
		return results;
	}

	private List<DepartamentoDTO> assembleResults(ResultSet resultSet) {
		List<DepartamentoDTO> results = new ArrayList<>();

		try {
			while (resultSet.next()) {
				results.add(assembleDTO(resultSet));
			}
		} catch (TradeShopException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to recover the Departments on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to recover the Departments on Azure SQL Server", exception);
		}

		return results;
	}

	private DepartamentoDTO assembleDTO(ResultSet resultSet) {
		DepartamentoDTO dto = new DepartamentoDTO();
		try {
			dto.setCodigo(resultSet.getInt("codigo"));
			dto.setDescripcion(resultSet.getString("descripcion"));

		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to assemble the Departments on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to assemble the Departments on Azure SQL Server", exception);
		}

		return dto;
	}
}
