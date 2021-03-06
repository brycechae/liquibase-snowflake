package liquibase.ext.snowflake.datatype;

import liquibase.database.Database;
import liquibase.datatype.DataTypeInfo;
import liquibase.datatype.DatabaseDataType;
import liquibase.datatype.LiquibaseDataType;
import liquibase.ext.snowflake.database.SnowflakeDatabase;

@DataTypeInfo(name="timestamp_ntz", aliases = { "java.sql.Types.DATETIME", "datetime"}, minParameters = 0, maxParameters = 0, priority = LiquibaseDataType.PRIORITY_DATABASE)
public class TimestampNTZType extends LiquibaseDataType {

    @Override
    public DatabaseDataType toDatabaseDataType(Database database) {

        if (database instanceof SnowflakeDatabase) {
            return new DatabaseDataType("TIMESTAMP_NTZ", getParameters());
        }

        return super.toDatabaseDataType(database);
    }

    @Override
    public void finishInitialization(String originalDefinition) {
        super.finishInitialization(originalDefinition);
    }

    @Override
    public boolean supports(Database database) {
        if (database instanceof SnowflakeDatabase)
            return true;
        return false;
    }

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }
}
