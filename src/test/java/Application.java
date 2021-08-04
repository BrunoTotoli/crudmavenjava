import com.bruno.connection.SingleConnection;
import org.junit.Test;

public class Application {
    @Test
    public void testConnection(){
        SingleConnection.getConnection();
    }
}
