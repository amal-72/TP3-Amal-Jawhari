package ma.emsi.amal.tp3amaljawhari;

import dev.langchain4j.service.Result;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import ma.emsi.amal.tp3amaljawhari.llm.GuideTouristique;
import ma.emsi.amal.tp3amaljawhari.llm.InfosTouristiques;
import ma.emsi.amal.tp3amaljawhari.llm.InfosTouristiquesAvecUsage;
import ma.emsi.amal.tp3amaljawhari.llm.LlmClient;
import ma.emsi.amal.tp3amaljawhari.llm.TokenUsageDto;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClient llmClient;

    /**
     * Retourne les informations touristiques d'une ville ou d'un pays.
     *
     * @param villeOuPays nom de la ville ou du pays
     * @return les informations touristiques avec l'utilisation des tokens
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces("application/json")
    public Response endroitsDeVisite(
            @PathParam("ville_ou_pays") String villeOuPays) {

        return construireReponse(villeOuPays, 2);
    }

    /**
     * Retourne un nombre choisi d'endroits à visiter.
     *
     * @param villeOuPays nom de la ville ou du pays
     * @param nb nombre d'endroits à visiter
     * @return les informations touristiques avec l'utilisation des tokens
     */
    @GET
    @Path("lieu/{ville_ou_pays}/{nb}")
    @Produces("application/json")
    public Response endroitsDeVisite(
            @PathParam("ville_ou_pays") String villeOuPays,
            @PathParam("nb") int nb) {

        if (nb < 1) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Le nombre d'endroits doit être supérieur à zéro.")
                    .build();
        }

        return construireReponse(villeOuPays, nb);
    }

    private Response construireReponse(String villeOuPays, int nb) {

        Result<InfosTouristiques> resultat =
                llmClient.informationsTouristiques(
                        "Donne " + nb + " endroits à visiter à " + villeOuPays
                );

        InfosTouristiques infos = resultat.content();

        TokenUsageDto usage = new TokenUsageDto(
                resultat.tokenUsage().inputTokenCount(),
                resultat.tokenUsage().outputTokenCount(),
                resultat.tokenUsage().totalTokenCount()
        );

        InfosTouristiquesAvecUsage reponse =
                new InfosTouristiquesAvecUsage(infos, usage);

        Response.ResponseBuilder responseBuilder = Response.ok(reponse);

        responseBuilder.header("Cache-Control",
                "no-store, no-cache, must-revalidate, max-age=0");
        responseBuilder.header("Pragma", "no-cache");
        responseBuilder.header("Expires", "0");
        responseBuilder.header("Access-Control-Allow-Origin", "*");

        return responseBuilder.build();
    }
}
