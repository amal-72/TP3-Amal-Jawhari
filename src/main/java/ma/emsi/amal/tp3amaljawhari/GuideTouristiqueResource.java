package ma.emsi.amal.tp3amaljawhari;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/guide")
public class GuideTouristiqueResource {

    /**
     * Retourne le nom de la ville ou du pays.
     *
     * @param villeOuPays nom de la ville ou du pays
     * @return le nom reçu en paramètre
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces("application/json")
    public String[] endroitsDeVisite(
            @PathParam("ville_ou_pays") String villeOuPays) {

        return new String[]{villeOuPays};
    }
}