package com.devs.controller;

import com.devs.dao.TipoProcessoDao;
import com.devs.model.TipoProcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TipoProcessoController {
    @Autowired
    TipoProcessoDao dao;


    @RequestMapping(value = "/")
    public String home(){
        return "index";

    }
    @RequestMapping(value = "tipoProcessoView")
    public ModelAndView listTipoProcesso(ModelAndView model){
        List<TipoProcesso> listTipoProcesso = dao.list();
        model.addObject("listTipoProcesso",listTipoProcesso);
        model.setViewName("tipoProcessoView");
        return model;
    }

    @RequestMapping(value = "tipoProcesso", method = RequestMethod.GET)
    public String tipoProcessoForm(Model m){
    m.addAttribute("command", new TipoProcesso());
    return "tipoProcesso";
}

    @RequestMapping(value = "/salvarTipoProcesso", method = RequestMethod.POST)
    public String salvarTipoProcesso(@ModelAttribute("tipoProcesso")TipoProcesso tp){
        dao.save(tp);
        return "redirect:/";
    }
}
