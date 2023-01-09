package com.devs.controller;

import com.devs.dao.TipoProcessoDao;
import com.devs.model.TipoProcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
        model.setViewName("tipo_processo/tipoProcessoView");
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editTipoProcessoView(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        TipoProcesso tp = dao.getTipoProcessoId(id);
        ModelAndView model = new ModelAndView("tipo_processo/tipoProcessoEdit");
        model.addObject("command",tp);
        return model;
    }



    @RequestMapping(value = "tipoProcesso", method = RequestMethod.GET)
    public String tipoProcessoForm(Model m){
        m.addAttribute("command", new TipoProcesso());
        return "tipo_processo/tipoProcesso";
    }

    @RequestMapping(value = "/salvarTipoProcesso", method = RequestMethod.POST)
    public String salvarTipoProcesso(@ModelAttribute("tipoProcesso")TipoProcesso tp){
        dao.save(tp);
        return "redirect:/";
    }

    @RequestMapping(value = "/editarTipoProcesso", method = RequestMethod.POST)
    public String editarTipoProcesso(@ModelAttribute("tipoProcesso") TipoProcesso tp){
        dao.update(tp);
        return "redirect:/tipoProcessoView";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deletarTipoProcesso(@ModelAttribute("tipoProcesso") TipoProcesso tp){
        dao.delete(tp);
        return "redirect:/tipoProcessoView";
    }


}
