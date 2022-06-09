package co.edu.uco.tradeShop.data.dao.azuresql;

import static co.edu.uco.crosscutting.util.text.UtilText.SPACE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.uco.TradeShop.dto.TipoVentaDTO;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.dao.connection.ConnectionSQL;
import co.edu.uco.tradeShop.data.dao.TipoVentaDAO;

public class TipoVentaAzureSqlDAO extends ConnectionSQL implements TipoVentaDAO{
	
	private TipoVentaAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static TipoVentaAzureSqlDAO create(Connection connection) {
		return new TipoVentaAzureSqlDAO(connection);
	}
	
	@Override
	public List<TipoVentaDTO> find(TipoVentaDTO tipoVenta) {
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<TipoVentaDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT codigo, descripcion").append(SPACE);
		sb.append("FROM TipoVenta").append(SPACE);

		if (!UtilObject.getUtilObject().isNull(tipoVenta)) {
			
			if (!UtilText.isEmpty(tipoVenta.getDescripcion())) {
				sb.append(setWhere ? "WHERE " : "AND ");
				sb.append("descripcion = ? ");
				parameters.add(UtilText.trim(tipoVenta.getDescripcion()));
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
					"There was a problem trying to retrieve type of sales on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to retrieve type of sales on Azure SQL Server", exception);
		}

		return results;
	}
	
	private List<TipoVentaDTO> executeQuery(PreparedStatement preparedStatement){
		
		List<TipoVentaDTO> results = new ArrayList<>();
		
		try (ResultSet resultset = preparedStatement.executeQuery()) {
			results = assembleResults(resultset);
		}catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to execute the Query for recovery the type of sales on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to execute the Query for recovery the type of sales on Azure SQL Server", exception);
		}
		return results;
	}

	private List<TipoVentaDTO> assembleResults(ResultSet resultSet) {
		List<TipoVentaDTO> results = new ArrayList<>();

		try {
			while (resultSet.next()) {
				results.add(assembleDTO(resultSet));
			}
		} catch (TradeShopException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to recover the type of sales on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to recover the type of sales on Azure SQL Server", exception);
		}

		return results;
	}

	private TipoVentaDTO assembleDTO(ResultSet resultSet) {
		TipoVentaDTO dto = new TipoVentaDTO();
		try {
			dto.setCodigo(resultSet.getInt("codigo"));
			dto.setDescripcion(resultSet.getString("descripcion"));

		} catch (SQLException exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"There was a problem trying to assemble the type of sales on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw TradeShopException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to assemble the type of sales on Azure SQL Server", exception);
		}

		return dto;
	}
}
