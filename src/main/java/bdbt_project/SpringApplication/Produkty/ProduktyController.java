package bdbt_project.SpringApplication.Produkty;

import bdbt_project.SpringApplication.Bilety.Bilety;
import bdbt_project.SpringApplication.Bilety.BiletyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProduktyController {

    @Autowired
    private ProduktyDAO dao;

    @RequestMapping("/produkty")
    public String viewHomePage(Model model) {
        List<Produkty> listProdukty = dao.list();
        model.addAttribute("listProdukty", listProdukty);
        return "produkty";
    }

    @RequestMapping("/newProdukt")
    public String showNowyProdukt(Model model) {
        Produkty produkty = new Produkty();
        model.addAttribute("produkty", produkty);
        return "nowy_produkt";
    }

    @RequestMapping(value = "/saveProdukt", method = RequestMethod.POST)
    public String save(@ModelAttribute("produkty") Produkty produkty) {
        dao.save(produkty);
        return "redirect:/produkty";
    }

    @RequestMapping("/editProdukt/{Nr_produktu}")
    public String showEditForm(@PathVariable(name = "Nr_produktu") int Nr_produktu, Model model) {
        Produkty produkty = dao.get(Nr_produktu);
        model.addAttribute("produkty", produkty);
        return "edytuj_produkt";
    }

    @RequestMapping(value = "/updateProdukt", method = RequestMethod.POST)
    public String update(@ModelAttribute("produkty") Produkty produkty) {
        dao.update(produkty);
        return "redirect:/produkty";
    }

    @RequestMapping("/deleteProdukt/{Nr_produktu}")
    public String delete(@PathVariable(name = "Nr_produktu") int Nr_produktu) {
        dao.delete(Nr_produktu);
        return "redirect:/produkty";
    }
}

