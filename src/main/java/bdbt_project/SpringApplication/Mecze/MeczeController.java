package bdbt_project.SpringApplication.Mecze;


import bdbt_project.SpringApplication.Pracownicy.Pracownicy;
import bdbt_project.SpringApplication.Pracownicy.PracownicyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MeczeController {

    @Autowired
    private MeczeDAO dao;

    @RequestMapping("/mecze")
    public String viewHomePage(Model model) {
        List<Mecze> listMecze = dao.list();
        model.addAttribute("listMecze", listMecze);
        return "mecze";
    }

    @RequestMapping("/newMecz")
    public String showNowyMecz(Model model) {
        Mecze mecze = new Mecze();
        model.addAttribute("mecze", mecze);
        return "nowy_mecz";
    }

    @RequestMapping(value = "/saveMecz", method = RequestMethod.POST)
    public String save(@ModelAttribute("mecze") Mecze mecze) {
        dao.save(mecze);
        return "redirect:/mecze";
    }

    @RequestMapping("/editMecz/{Nr_meczu}")
    public String showEditForm(@PathVariable(name = "Nr_meczu") int Nr_meczu, Model model) {
        Mecze mecze = dao.get(Nr_meczu);
        model.addAttribute("mecze", mecze);
        return "edytuj_mecz";
    }

    @RequestMapping(value = "/updateMecz", method = RequestMethod.POST)
    public String update(@ModelAttribute("mecze") Mecze mecze) {
        dao.update(mecze);
        return "redirect:/mecze";
    }

    @RequestMapping("/deleteMecz/{Nr_meczu}")
    public String delete(@PathVariable(name = "Nr_meczu") int Nr_meczu) {
        dao.delete(Nr_meczu);
        return "redirect:/mecz";
    }

}
