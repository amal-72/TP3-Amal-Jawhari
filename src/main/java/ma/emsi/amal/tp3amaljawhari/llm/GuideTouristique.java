package ma.emsi.amal.tp3amaljawhari.llm;

import dev.langchain4j.service.Result;

public interface GuideTouristique {

    Result<InfosTouristiques> informationsTouristiques(String villeOuPays);

}