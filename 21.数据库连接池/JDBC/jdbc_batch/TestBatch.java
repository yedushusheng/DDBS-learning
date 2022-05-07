import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestBatch {
        public static void main(String[] args) throws Exception {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String password = "test";
                String user = "test";
                String url = "jdbc:mysql://9.30.17.135:12346/shuidu?connectTimeout=10000&socketTimeout=60000&zeroDateTimeBehavior=convertToNull&rewriteBatchedStatements=true";
                Connection conn = DriverManager.getConnection(url, user, password);
                conn.setAutoCommit(false);
                try {

			//String delete_sql = "delete from dzfp_test where 1";
			//PreparedStatement ps = conn.prepareStatement(delete_sql);
			// ps.execute();
			String sql="update dzfp_test set foo = 1 where bar = ?";
	
                        PreparedStatement pstat = conn.prepareStatement(sql);
        				pstat.setInt(1,99);
        				pstat.addBatch();
        				pstat.setInt(1,97);
        				pstat.addBatch();        				
        				pstat.setInt(1,1);
        				pstat.addBatch();        				
        				pstat.setInt(1,3);
        				pstat.addBatch();        				
        				pstat.setInt(1,5);
        				pstat.addBatch();        				
                        pstat.executeBatch();
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        conn.commit();
                        conn.close();
                }
        }
}
