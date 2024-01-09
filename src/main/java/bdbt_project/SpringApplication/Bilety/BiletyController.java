package bdbt_project.SpringApplication.Bilety;

import bdbt_project.SpringApplication.Bilety.Bilety;
import bdbt_project.SpringApplication.Bilety.BiletyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BiletyController {

    @Autowired
    private BiletyDAO dao;

    @RequestMapping("/bilety")
    public String viewHomePage(Model model) {
        List<Bilety> listBilety = dao.list();
        model.addAttribute("listBilety", listBilety);
        return "bilety";
    }

    @RequestMapping("/newBilet")
    public String showNowyBilet(Model model) {
        Bilety bilety = new Bilety();
        model.addAttribute("bilety", bilety);
        return "nowy_bilet";
    }

    @RequestMapping(value = "/saveBilet", method = RequestMethod.POST)
    public String save(@ModelAttribute("bilety") @Validated Bilety bilety, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "nowy_bilet";
        } else {
            dao.save(bilety);
            return "redirect:/bilety";
        }
    }

    @RequestMapping("/editBilet/{Nr_biletu}")
    public String showEditForm(@PathVariable(name = "Nr_biletu") int Nr_biletu, Model model) {
        Bilety bilety = dao.get(Nr_biletu);
        model.addAttribute("bilety", bilety);
        return "edytuj_bilet";
    }

    @RequestMapping(value = "/updateBilet", method = RequestMethod.POST)
    public String update(@ModelAttribute("bilety") Bilety bilety) {
        dao.update(bilety);
        return "redirect:/bilety";
    }

    @RequestMapping("/deleteBilet/{Nr_biletu}")
    public String delete(@PathVariable(name = "Nr_biletu") int Nr_biletu) {
        dao.delete(Nr_biletu);
        return "redirect:/bilety";
    }
}
