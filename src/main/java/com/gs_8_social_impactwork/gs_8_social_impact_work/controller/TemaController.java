package com.gs_8_social_impactwork.gs_8_social_impact_work.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TemaController {

    @GetMapping("/info")
    public Map<String, String> getInfo() {
        Map<String, String> body = new HashMap<>();

        body.put("tema", "Modelos de trabalho baseados em impacto social e sustentabilidade");
        body.put("membro1", "Diogo Makoto Mano");
        body.put("membro2", "Victor Espanhol Henrique Santos");
        body.put("descricao",
                "API que descreve modelos de trabalho focados em impacto social e sustentabilidade, "
                        + "mostrando como organizações podem alinhar resultados econômicos com impacto social positivo.");

        return body;
    }
}
