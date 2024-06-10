package bdbt_project.SpringApplication.Kibice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class KibiceController {

    @Autowired
    private KibiceDAO dao;

    @RequestMapping("/kibice")
    public String viewHomePage(Model model, Principal principal) {
        if (principal != null && principal.getName().equals("USER")) {
            Kibice specificKibic = dao.getFirst();  // Pobierz rekord o numerze kibica 1
            model.addAttribute("listKibice", List.of(specificKibic));
        } else {
            List<Kibice> listKibice = dao.list();
            model.addAttribute("listKibice", listKibice);
        }
        return "kibice";
    }

    @RequestMapping(value = "/saveKibic", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("kibice") Kibice kibice, BindingResult bindingResult,Model model) {

        if (bindingResult.hasErrors()){
            return "nowy_kibic";
        }
        dao.save(kibice);
        return "redirect:/kibice";
    }

    @RequestMapping("/editKibic/{Nr_kibica}")
    public String showEditForm(@PathVariable(name = "Nr_kibica") int Nr_kibica, Model model) {
        Kibice kibice = dao.get(Nr_kibica);
        model.addAttribute("kibice", kibice);
        return "edytuj_kibica";
    }

    @RequestMapping(value = "/updateKibic", method = RequestMethod.POST)
    public String update(@ModelAttribute("kibice") Kibice kibice) {
        dao.update(kibice);
        return "redirect:/kibice";
    }

    @RequestMapping("/deleteKibic/{Nr_kibica}")
    public String delete(@PathVariable(name = "Nr_kibica") int Nr_kibica, Principal principal) {
        if (principal != null && principal.getName().equals("ADMIN")) {
            dao.delete(Nr_kibica);
        }
        return "redirect:/kibice";
    }
}
