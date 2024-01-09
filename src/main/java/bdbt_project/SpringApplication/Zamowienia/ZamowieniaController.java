package bdbt_project.SpringApplication.Zamowienia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ZamowieniaController {

    @Autowired
    private ZamowieniaDAO dao;

    @RequestMapping("/zamowienia")
    public String viewHomePage(Model model) {
        List<Zamowienia> listZamowienia = dao.list();
        model.addAttribute("listZamowienia", listZamowienia);
        return "zamowienia";
    }

    @RequestMapping("/newZamowienie")
    public String showNoweZamowienie(Model model) {
        Zamowienia zamowienia = new Zamowienia();
        model.addAttribute("zamowienia", zamowienia);
        return "nowe_zamowienie";
    }

    @RequestMapping(value = "/saveZamowienie", method = RequestMethod.POST)
    public String save(@ModelAttribute("zamowienia") Zamowienia zamowienia) {
        dao.save(zamowienia);
        return "redirect:/zamowienia";
    }

    @RequestMapping("/editZamowienie/{Nr_zamowienia}")
    public String showEditForm(@PathVariable(name = "Nr_zamowienia") int Nr_zamowienia, Model model) {
        Zamowienia zamowienia = dao.get(Nr_zamowienia);
        model.addAttribute("zamowienia", zamowienia);
        return "edytuj_zamowienie";
    }

    @RequestMapping(value = "/updateZamowienie", method = RequestMethod.POST)
    public String update(@ModelAttribute("zamowienia") Zamowienia zamowienia) {
        dao.update(zamowienia);
        return "redirect:/zamowienia";
    }

    @RequestMapping("/deleteZamowienie/{Nr_zamowienia}")
    public String delete(@PathVariable(name = "Nr_zamowienia") int Nr_zamowienia) {
        dao.delete(Nr_zamowienia);
        return "redirect:/zamowienia";
    }

}
