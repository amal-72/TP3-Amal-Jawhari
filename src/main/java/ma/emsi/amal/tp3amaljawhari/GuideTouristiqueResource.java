package ma.emsi.amal.tp3amaljawhari;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import ma.emsi.amal.tp3amaljawhari.llm.LlmClient;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClient llmClient;

    /**
     * Retourne les informations touristiques de la ville ou du pays.
     *
     * @param villeOuPays nom de la ville ou du pays
     * @param nb nombre d'endroits à visiter
     * @return les informations touristiques générées par le LLM
     */
    @GET
    @Path("lieu/{ville_ou_pays}/{nb}")
    @Produces("application/json")
    public String endroitsDeVisite(
            @PathParam("ville_ou_pays") String villeOuPays,
            @PathParam("nb") int nb) {

        return llmClient.chat(
                "Donne " + nb + " endroits à visiter à " + villeOuPays
        );
    }
}
