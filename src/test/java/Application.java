import com.bruno.connection.SingleConnection;
import com.bruno.dao.UsuarioDAO;
import com.bruno.model.Usuario;
import org.junit.Test;

public class Application {
    @Test
    public void testConnection() {
        SingleConnection.getConnection();
    }

    @Test
    public void testSalvar() {
        Usuario usuario = new Usuario("Astolfo3", "Astolfo3@gmail.com");
        UsuarioDAO dao = new UsuarioDAO();
        dao.salvar(usuario);
    }

    @Test
    public void testListarUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        for (Usuario a : dao.listarUsuarios()) {
            System.out.println(a);
        }
    }

    @Test
    public void testListarPorId() {
        UsuarioDAO dao = new UsuarioDAO();
        System.out.println(dao.listarPorId(2L));
    }

    @Test
    public void testAtualizarEmail() {
        UsuarioDAO dao = new UsuarioDAO();
        dao.atualizarEmailUsuario(dao.listarPorId(3L), "Astolfoatualizado@gmail.com");
    }

    @Test
    public void testDeletar() {
        UsuarioDAO dao = new UsuarioDAO();
        dao.deletarPorId(3L);
    }
}
