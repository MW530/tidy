package priv.mw.utils.mybatisTypeHandlers.scanHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import priv.mw.domain.Assets;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AssetsHandler extends BaseTypeHandler<List<Assets>> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<Assets> assets, JdbcType jdbcType) throws SQLException {
        StringBuilder sb = new StringBuilder();
        for (Assets asset : assets) {
            sb.append(asset.getId());
            sb.append(";");
        }
        sb.deleteCharAt(sb.length() - 1);
        preparedStatement.setString(i, sb.toString());
    }

    @Override
    public List<Assets> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getObject(s, List.class);
    }

    @Override
    public List<Assets> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getObject(i, List.class);
    }

    @Override
    public List<Assets> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getObject(i, List.class);
    }
}
