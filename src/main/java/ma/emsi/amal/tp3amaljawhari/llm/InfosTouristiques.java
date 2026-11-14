package ma.emsi.amal.tp3amaljawhari.llm;

import java.util.List;

public record InfosTouristiques(
        String ville_ou_pays,
        List<String> endroits_a_visiter,
        String prix_moyen_repas
) {
}