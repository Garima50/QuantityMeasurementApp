package com.apps.quantitymeasurement.repository;

import java.util.ArrayList;
//import java.sql.Connection;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.stream.Collectors;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.enums.LengthUnit;
import com.apps.quantitymeasurement.enums.TemperatureUnit;
import com.apps.quantitymeasurement.enums.VolumeUnit;
import com.apps.quantitymeasurement.enums.WeightUnit;
import com.apps.quantitymeasurement.exception.DatabaseException;
import com.apps.quantitymeasurement.interfaces.IMeasurable;
import com.apps.quantitymeasurement.model.QuantityModel;
//import com.apps.quantitymeasurement.exception.DatabaseException;
import com.apps.quantitymeasurement.util.ConnectionPool;

public class QuantityMeasurementDatabaseRepository
        implements IQuantityMeasurementRepository {

            private static final String INSERT_QUERY = """
INSERT INTO quantity_measurements
(
    first_value,
    first_unit,
    first_measurement_type,
    second_value,
    second_unit,
    second_measurement_type,
    operation,
    result_value,
    result_unit,
    result_measurement_type,
    numeric_result,
    error_message
)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
""";

private static final String SELECT_ALL_QUERY =
        "SELECT * FROM quantity_measurements";

        private static final String SELECT_BY_OPERATION_QUERY =
        "SELECT * FROM quantity_measurements WHERE operation = ?";


       private static final String SELECT_BY_TYPE_QUERY =
        "SELECT * FROM quantity_measurements WHERE first_measurement_type = ?";

        // UC16 UPDATE
        // Query to count all measurement records
        private static final String COUNT_QUERY =
        "SELECT COUNT(*) FROM quantity_measurements";

        // UC16 UPDATE
        // Query to delete all measurement records
        private static final String DELETE_ALL_QUERY =
        "DELETE FROM quantity_measurements";

    private static QuantityMeasurementDatabaseRepository instance;

    private QuantityMeasurementDatabaseRepository() {

        initializeDatabase();
    }

    public static synchronized QuantityMeasurementDatabaseRepository getInstance() {

        if (instance == null) {
            instance = new QuantityMeasurementDatabaseRepository();
        }

        return instance;
    }

    private void initializeDatabase() {

    try (
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            InputStream inputStream =
                    getClass().getClassLoader()
                            .getResourceAsStream("db/schema.sql");
    ) {

        if (inputStream == null) {

            throw new DatabaseException(
                    "schema.sql not found."
            );
        }

        String sql = new BufferedReader(
                new InputStreamReader(inputStream)
        ).lines().collect(Collectors.joining("\n"));

        for (String query : sql.split(";")) {

            if (!query.trim().isEmpty()) {

                statement.execute(query);
            }
        }

    } catch (Exception exception) {

        throw new DatabaseException(
                "Failed to initialize database.",
                exception
        );
    }
}

        @Override
        public void save(QuantityMeasurementEntity entity) {

    try (
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(INSERT_QUERY)
    ) {

        // First Quantity
        preparedStatement.setDouble(
                1,
                entity.getThisQuantity().getValue()
        );

        preparedStatement.setString(
                2,
                entity.getThisQuantity().getUnit().toString()
        );

        preparedStatement.setString(
                3,
                entity.getThisQuantity()
                        .getUnit()
                        .getMeasurementType()
        );

        // Second Quantity
        if (entity.getThatQuantity() != null) {

            preparedStatement.setDouble(
                    4,
                    entity.getThatQuantity().getValue()
            );

            preparedStatement.setString(
                    5,
                    entity.getThatQuantity().getUnit().toString()
            );

            preparedStatement.setString(
                    6,
                    entity.getThatQuantity()
                            .getUnit()
                            .getMeasurementType()
            );

        } else {

            preparedStatement.setNull(
                    4,
                    java.sql.Types.DOUBLE
            );

            preparedStatement.setNull(
                    5,
                    java.sql.Types.VARCHAR
            );

            preparedStatement.setNull(
                    6,
                    java.sql.Types.VARCHAR
            );
        }

        // Operation
        preparedStatement.setString(
                7,
                entity.getOperation()
        );

        // Result
        if (entity.getQuantityResult() != null) {

            preparedStatement.setDouble(
                    8,
                    entity.getQuantityResult().getValue()
            );

            preparedStatement.setString(
                    9,
                    entity.getQuantityResult().getUnit().toString()
            );

            preparedStatement.setString(
                    10,
                    entity.getQuantityResult()
                            .getUnit()
                            .getMeasurementType()
            );

            preparedStatement.setBoolean(
                    11,
                    false
            );

        } else if (entity.getNumericResult() != null) {

            preparedStatement.setDouble(
                    8,
                    entity.getNumericResult()
            );

            preparedStatement.setNull(
                    9,
                    java.sql.Types.VARCHAR
            );

            preparedStatement.setNull(
                    10,
                    java.sql.Types.VARCHAR
            );

            preparedStatement.setBoolean(
                    11,
                    true
            );

        } else {

            preparedStatement.setNull(
                    8,
                    java.sql.Types.DOUBLE
            );

            preparedStatement.setNull(
                    9,
                    java.sql.Types.VARCHAR
            );

            preparedStatement.setNull(
                    10,
                    java.sql.Types.VARCHAR
            );

            preparedStatement.setBoolean(
                    11,
                    false
            );
        }

        preparedStatement.setString(
                12,
                entity.getErrorMessage()
        );

        preparedStatement.executeUpdate();

    } catch (Exception exception) {

        throw new DatabaseException(
                "Failed to save measurement.",
                exception
        );
    }

    }

    @Override
public List<QuantityMeasurementEntity> getAllMeasurements() {

    List<QuantityMeasurementEntity> measurements = new ArrayList<>();

    try (
            Connection connection = ConnectionPool.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(SELECT_ALL_QUERY);

            ResultSet resultSet =
                    preparedStatement.executeQuery()
    ) {

        while (resultSet.next()) {

            measurements.add(
                    mapResultSetToEntity(resultSet)
            );
        }

        return measurements;

    } catch (Exception exception) {

        throw new DatabaseException(
                "Failed to fetch measurements.",
                exception
        );
    }
}

    @Override
public List<QuantityMeasurementEntity> getMeasurementsByOperation(
        String operation) {

    List<QuantityMeasurementEntity> measurements =
            new ArrayList<>();

    try (

            Connection connection =
                    ConnectionPool.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            SELECT_BY_OPERATION_QUERY
                    )

    ) {

        preparedStatement.setString(1, operation);

        ResultSet resultSet =
                preparedStatement.executeQuery();

        while (resultSet.next()) {

            measurements.add(
                    mapResultSetToEntity(resultSet)
            );
        }

        resultSet.close();

        return measurements;

    } catch (Exception exception) {

        throw new DatabaseException(
                "Failed to fetch measurements by operation.",
                exception
        );
    }
}

    @Override
public List<QuantityMeasurementEntity> getMeasurementsByType(
        String measurementType) {

    List<QuantityMeasurementEntity> measurements =
            new ArrayList<>();

    try (

            Connection connection =
                    ConnectionPool.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            SELECT_BY_TYPE_QUERY
                    )

    ) {

        preparedStatement.setString(1, measurementType);

        ResultSet resultSet =
                preparedStatement.executeQuery();

        while (resultSet.next()) {

            measurements.add(
                    mapResultSetToEntity(resultSet)
            );
        }

        resultSet.close();

        return measurements;

    } catch (Exception exception) {

        throw new DatabaseException(
                "Failed to fetch measurements by type.",
                exception
        );
    }
}

// UC16 UPDATE
// Return total measurement records stored in database
    @Override
    public int getTotalCount() {

    try (

            Connection connection =
                    ConnectionPool.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(COUNT_QUERY);

            ResultSet resultSet =
                    preparedStatement.executeQuery()

    ) {

        if (resultSet.next()) {

            return resultSet.getInt(1);
        }

        return 0;

    } catch (Exception exception) {

        throw new DatabaseException(
                "Failed to get total count.",
                exception
        );
    }
}


// UC16 UPDATE
// Delete all measurement records from database
@Override
public void deleteAll() {

    try (

            Connection connection =
                    ConnectionPool.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            DELETE_ALL_QUERY
                    )

    ) {

        preparedStatement.executeUpdate();

    } catch (Exception exception) {

        throw new DatabaseException(
                "Failed to delete measurements.",
                exception
        );
    }
}

    @Override
    public String getPoolStatistics() {

    return ConnectionPool.getPoolStatistics();
}

    @Override
    public void releaseResources() {
        ConnectionPool.closePool();

    }


    private IMeasurable getUnit(
        String measurementType,
        String unitName
) {

    return switch (measurementType) {

        case "LENGTH" ->
                LengthUnit.valueOf(unitName);

        case "WEIGHT" ->
                WeightUnit.valueOf(unitName);

        case "VOLUME" ->
                VolumeUnit.valueOf(unitName);

        case "TEMPERATURE" ->
                TemperatureUnit.valueOf(unitName);

        default ->
                throw new DatabaseException(
                        "Unknown measurement type : "
                                + measurementType
                );
    };
}


private QuantityMeasurementEntity mapResultSetToEntity(
        ResultSet resultSet
)
        throws SQLException {

    QuantityModel<IMeasurable> firstQuantity =
            new QuantityModel<>(

                    resultSet.getDouble("first_value"),

                    getUnit(
                            resultSet.getString("first_measurement_type"),
                            resultSet.getString("first_unit")
                    )
            );

    QuantityModel<IMeasurable> secondQuantity =
            new QuantityModel<>(

                    resultSet.getDouble("second_value"),

                    getUnit(
                            resultSet.getString("second_measurement_type"),
                            resultSet.getString("second_unit")
                    )
            );

    String operation =
            resultSet.getString("operation");

    String errorMessage =
            resultSet.getString("error_message");

    if (errorMessage != null) {

        return new QuantityMeasurementEntity(

                firstQuantity,

                secondQuantity,

                operation,

                errorMessage,

                true
        );
    }

    String resultUnit =
            resultSet.getString("result_unit");

    if (resultUnit != null) {

        QuantityModel<IMeasurable> resultQuantity =
                new QuantityModel<>(

                        resultSet.getDouble("result_value"),

                        getUnit(
                                resultSet.getString("result_measurement_type"),
                                resultUnit
                        )
                );

        return new QuantityMeasurementEntity(

                firstQuantity,

                secondQuantity,

                operation,

                resultQuantity
        );
    }

    return new QuantityMeasurementEntity(

            firstQuantity,

            secondQuantity,

            operation,

            resultSet.getDouble("result_value")
    );
}



}