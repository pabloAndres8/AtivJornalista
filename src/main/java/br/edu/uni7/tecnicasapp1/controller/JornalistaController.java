package br.edu.uni7.tecnicasapp1.controller;

import br.edu.uni7.tecnicasapp1.model.Jornalista;
import br.edu.uni7.tecnicasapp1.repository.JornalistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class JornalistaController {

    private final JornalistaRepository jornalistaRepository;

        @Autowired
        public JornalistaController(JornalistaRepository jornalistaRepository) {
            this.jornalistaRepository = jornalistaRepository;
        }

        @ResponseBody
        @RequestMapping(value = "jornalista/{id}", method = RequestMethod.GET)
        public Jornalista encontrarJornalista(@PathVariable Integer id) {
            return jornalistaRepository.findById(id);
        }

        @ResponseBody
        @RequestMapping(value = "jornalista", method = RequestMethod.GET)
        public List<Jornalista> listarJornalista() {
            return jornalistaRepository.read();
        }

        @ResponseBody
        @RequestMapping(value = "jornalista", method = RequestMethod.POST)
        public Jornalista criarJornalista(@RequestBody Jornalista jornalista) {
            jornalistaRepository.create(jornalista);

            return jornalista;
        }

        @ResponseBody
        @RequestMapping(value = "jornalista/{id}", method = RequestMethod.DELETE)
        public void apagarJornalista(@PathVariable Integer id) {
            jornalistaRepository.delete(id);
        }

        @ResponseBody
        @RequestMapping(value = "materia/{id}", method = RequestMethod.PUT)
        public void atualizarJornalista(@PathVariable Integer id, @RequestBody Jornalista jornalista) {
            jornalistaRepository.update(id, jornalista);
        }

}

