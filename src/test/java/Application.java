import com.bruno.connection.SingleConnection;
import com.bruno.dao.UsuarioDAO;
import com.bruno.model.Usuario;
import org.junit.Test;

public class Application {
    @Test
    public void testConnection(){
        SingleConnection.getConnection();
    }
    @Test
    public void testSalvar (){
        Usuario usuario = new Usuario("Astolfo","Astolfo@gmail.com",3L);
        UsuarioDAO dao = new UsuarioDAO();
        dao.salvar(usuario);
    }
    @Test
    public void testListarUsuarios(){
        UsuarioDAO dao = new UsuarioDAO();
        for(Usuario a : dao.listarUsuarios()){
            System.out.println(a);
        }
    }
}
