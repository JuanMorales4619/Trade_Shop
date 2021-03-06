package co.edu.uco.tradeShop.data.dao.azuresql;

import static co.edu.uco.crosscutting.util.text.UtilText.SPACE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.uco.TradeShop.dto.TipoIdentificacionDTO;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.dao.connection.ConnectionSQL;
import co.edu.uco.tradeShop.data.dao.TipoIdentificacionDAO;

public class TipoIdentificacionAzureSqlDAO extends ConnectionSQL implements TipoIdentificacionDAO{
	
	private TipoIdentificacionAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static TipoIdentificacionAzureSqlDAO create(Connection connection) {
		return new TipoIdentificacionAzureSqlDAO(connection);
	}
	
	@Override
	public List<TipoIdentificacionDTO> find(TipoIdentificacionDTO tipoIdentificacion) {
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<TipoIdentificacionDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT codigo, descripcion").append(SPACE);
		sb.append("FROM TipoIdentificacion").append(SPACE);

		if (!UtilObject.getUtilObject().isNull(tipoIdentificacion)) {

			if (!UtilText.isEmpty(tipoIdentificacion.getDescripcion())) {
				sb.append(setWhere ? "WHERE " : "AND ");
				sb.append("descripcion = ? ");
				parameters.add(UtilText.trim(tipoIdentificacion.getDescripcion()));
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
	
	private List<TipoIdentificacionDTO> executeQuery(PreparedStatement preparedStatement){
		
		List<TipoIdentificacionDTO> results = new ArrayList<>();
		
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

	private List<TipoIdentificacionDTO> assembleResults(ResultSet resultSet) {
		List<TipoIdentificacionDTO> results = new ArrayList<>();

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

	private TipoIdentificacionDTO assembleDTO(ResultSet resultSet) {
		TipoIdentificacionDTO dto = new TipoIdentificacionDTO();
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
