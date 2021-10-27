package br.edu.uni7.tecnicasapp1.repository;

import br.edu.uni7.tecnicasapp1.model.Jornalista;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class JornalistaRepository {
    private final List<Jornalista> jornalista;

    public JornalistaRepository() {
        jornalista = new ArrayList<>();
    }

    public void create(Jornalista jornalistas) {
        jornalista.add(jornalistas);
    }

    public List<Jornalista> read() {
        return jornalista;
    }

    public void update(Integer id, Jornalista novaJornalista) {
        for (int i = 0; i < jornalista.size(); i++) {
            if (Objects.equals(jornalista.get(i).getId(), id)) {
                jornalista.remove(i);
                jornalista.add(i, novaJornalista);
                break;
            }
        }
    }

    public void delete(Integer id) {
        Jornalista toDelete = null;
        for (Jornalista jornalistas : jornalista) {
            if (Objects.equals(id, jornalistas.getId())) {
                toDelete = jornalistas;
                break;
            }
        }

        if (toDelete != null) {
            jornalista.remove(toDelete);
        }
    }

    public Jornalista findById(Integer id) {
        for (Jornalista jornalistas : jornalista) {
            if (Objects.equals(id, jornalistas.getId())) {
                return jornalistas;
            }
        }

        return null;
    }

}
