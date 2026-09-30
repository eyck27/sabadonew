package org.example.business;

import org.example.data.CursoRepository;
import java.util.List;

public class CursoService {
    private final CursoRepository repository;

    public CursoService() {
        this.repository = new CursoRepository();
    }

    public void registrar(Curso curso) {
        List<Curso> cursos = repository.listar();
        cursos.add(curso);
        repository.guardar(cursos);
    }

    public List<Curso> listar() {
        return repository.listar();
    }

    public Boolean actualizar(Curso curso) {
        List<Curso> cursos = repository.listar();
        for (Curso c : cursos) {
            if (c.getId() == curso.getId()) {
                c.setNombre(curso.getNombre());
                c.setCreditos(curso.getCreditos());
                repository.guardar(cursos);
                return true;
            }
        }
        return false;
    }

    public Boolean eliminar(int id) {
        List<Curso> cursos = repository.listar();
        boolean eliminado = cursos.removeIf(c -> c.getId() == id);
        if (eliminado) {
            repository.guardar(cursos);
        }
        return eliminado;
    }
}
