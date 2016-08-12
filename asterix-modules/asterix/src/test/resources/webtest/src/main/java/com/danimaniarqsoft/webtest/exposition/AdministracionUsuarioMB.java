package webtest.src.main.java.com.danimaniarqsoft.webtest.exposition;

import java.util.*;
import com.danimaniarqsoft.webtest.model.Usuario;
import java.util.List;

public class AdministracionUsuarioMB {

    private Usuario usuario;

    private Usuario usuarioSelected;

    private List<Usuario> usuarioList;

    public void setUsuarioSelected(Usuario usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }

    public Usuario getUsuarioSelected() {
        return this.usuarioSelected;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Usuario> getUsuarioList() {
        return this.usuarioList;
    }
}
