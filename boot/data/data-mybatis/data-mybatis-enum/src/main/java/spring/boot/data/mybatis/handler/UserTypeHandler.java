package spring.boot.data.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import spring.boot.data.mybatis.enums.UserType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTypeHandler extends BaseTypeHandler<UserType> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UserType userType, JdbcType jdbcType)
            throws SQLException {
        preparedStatement.setInt(i, userType.getType());
    }

    @Override
    public UserType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return UserType.valueOf(resultSet.getInt(s));
    }

    @Override
    public UserType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return UserType.valueOf(resultSet.getInt(i));
    }

    @Override
    public UserType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return UserType.valueOf(callableStatement.getInt(i));
    }
}
