package bdbt_project.SpringApplication.Pracownicy;


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
public class PracownicyController {

    @Autowired
    private PracownicyDAO dao;

    @RequestMapping("/pracownicy")
    public String viewHomePage(Model model) {
        List<Pracownicy> listPracownicy = dao.list();
        model.addAttribute("listPracownicy", listPracownicy);
        return "pracownicy";
    }

    @RequestMapping("/newPracownik")
    public String showNowyPracownik(Model model) {
        Pracownicy pracownicy = new Pracownicy();
        model.addAttribute("pracownicy", pracownicy);
        return "nowy_pracownik";
    }

    @RequestMapping(value = "/savePracownik", method = RequestMethod.POST)
    public String save(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
        dao.save(pracownicy);
        return "redirect:/pracownicy";
    }

    @RequestMapping("/editPracownik/{Nr_pracownika}")
    public String showEditForm(@PathVariable(name = "Nr_pracownika") int Nr_pracownika, Model model) {
        Pracownicy pracownicy = dao.get(Nr_pracownika);
        model.addAttribute("pracownicy", pracownicy);
        return "edytuj_pracownika";
    }

    @RequestMapping(value = "/updatePracownik", method = RequestMethod.POST)
    public String update(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
        dao.update(pracownicy);
        return "redirect:/pracownicy";
    }

    @RequestMapping("/deletePracownik/{Nr_pracownika}")
    public String delete(@PathVariable(name = "Nr_pracownika") int Nr_pracownika) {
        dao.delete(Nr_pracownika);
        return "redirect:/pracownicy";
    }

}
