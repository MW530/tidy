package priv.mw.utils.mybatisTypeHandlers.unScanHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import priv.mw.domain.Groups;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDefaultHandler extends BaseTypeHandler<Groups> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Groups groups, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, groups.getName());
    }

    @Override
    public Groups getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Groups groups = new Groups();
        groups.setId(resultSet.getInt("id"));
        groups.setName(resultSet.getString("name"));
        groups.setPost(resultSet.getInt("post"));
        return groups;
    }

    @Override
    public Groups getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getObject(i, Groups.class);
    }

    @Override
    public Groups getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getObject(i, Groups.class);
    }
}
