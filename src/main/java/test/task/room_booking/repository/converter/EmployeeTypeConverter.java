package test.task.room_booking.repository.converter;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.EnumType;
import test.task.room_booking.repository.model.type.EmployeeType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class EmployeeTypeConverter extends EnumType {
    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index,
                            SharedSessionContractImplementor session)
            throws SQLException {
        preparedStatement.setObject(index, value != null ? ((EmployeeType) value).get() : null, Types.OTHER);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws SQLException {
        String value = rs.getString(names[0]);
        return EmployeeType.getValueOf(value);
    }
}
