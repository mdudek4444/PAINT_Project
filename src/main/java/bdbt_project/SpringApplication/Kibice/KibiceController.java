package bdbt_project.SpringApplication.Kibice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class KibiceController {

    @Autowired
    private KibiceDAO dao;

    @RequestMapping("/kibice")
    public String viewHomePage(Model model) {
        List<Kibice> listKibice = dao.list();
        model.addAttribute("listKibice", listKibice);
        return "kibice";
    }



    @RequestMapping("/newKibic")
    public String showNowyKibic(Model model) {
        Kibice kibice = new Kibice();
        model.addAttribute("kibice", kibice);
        return "nowy_kibic";
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
    public String delete(@PathVariable(name = "Nr_kibica") int Nr_kibica) {
        dao.delete(Nr_kibica);
        return "redirect:/kibice";
    }



}
