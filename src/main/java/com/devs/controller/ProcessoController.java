package com.devs.controller;

import com.devs.dao.ProcessoDao;
import com.devs.dao.TipoProcessoDao;
import com.devs.model.Processo;
import com.devs.model.TipoProcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ProcessoController {
    @Autowired
    ProcessoDao dao;
    @Autowired
    TipoProcessoDao tpDao;

    @RequestMapping(value = "/processo")
    public String processoForm(Model model){
        List<TipoProcesso> listTipoProcesso = tpDao.list();

        model.addAttribute("command",new Processo());
        model.addAttribute("listTipoProcesso",listTipoProcesso);
        return "processo/processo";
    }

    @RequestMapping(value = "/salvarProcesso", method = RequestMethod.POST)
    public String salvarProcesso(@ModelAttribute("processo") Processo p, RedirectAttributes ra){
        if(dao.existsProcessoByNumero(p.getNumero_processo())){
            ra.addFlashAttribute("message","Já existe um cadastro com este número");
            return "processo/processoJaExiste";
        }
        dao.save(p);
        return "redirect:/viewProcesso";
    }

    @RequestMapping("/viewProcesso")
    public String viewProcesso (Model m){
        List<Processo> list=dao.getProcesso();
        m.addAttribute("list",list);
        return "processo/viewProcesso";
    }



    @RequestMapping("/viewProcessoPorNumero")
    public String viewProcessoPorNumero (@RequestParam("numero_processo") String numero_processo, Model m){
        List<Processo> list=dao.getProcessoPorNumero(numero_processo);
        List<TipoProcesso> listTipoProcesso=tpDao.getTipoProcesso();
        m.addAttribute("list",list);
        m.addAttribute("listTipoProcesso",listTipoProcesso);
        return "redirect:/viewProcesso";
    }



    @RequestMapping(value="/editProcessoSave",method = RequestMethod.POST)
    public String editProcessoSave(@ModelAttribute("processo") Processo p){
        dao.update(p);
        return "redirect:/viewProcesso";
    }


@RequestMapping(value = "/editProcesso", method = RequestMethod.GET)
    public ModelAndView editProcessoView(HttpServletRequest request, Model m){
        Integer id = Integer.parseInt(request.getParameter("id"));
        Processo tp = dao.getProcessoById(id);
        List<Processo> listTipoProcesso = dao.get(id);
        ModelAndView model = new ModelAndView("processo/processoEdit");
        model.addObject("listTipoProcesso",listTipoProcesso);
        model.addObject("command",tp);
        return model;
    }
    @RequestMapping(value="/deleteProcesso/{id}",method = RequestMethod.GET)
    public String deleteProcesso(@ModelAttribute("processo") Processo p){
        dao.delete(p);
        return "redirect:/viewProcesso";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
    }
}
