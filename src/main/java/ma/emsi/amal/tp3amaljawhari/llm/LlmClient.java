package ma.emsi.amal.tp3amaljawhari.llm;

import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;

import java.io.Serializable;

@Dependent
public class LlmClient implements Serializable {

    private static final long serialVersionUID = 1L;

    private GuideTouristique assistant;
    private ChatMemory chatMemory;

    public LlmClient() {

        String apiKey = System.getenv("GEMINI_KEY");

        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.5-flash-lite")
                .build();

        chatMemory = MessageWindowChatMemory.withMaxMessages(20);

        chatMemory.add(SystemMessage.from("""
                Tu es un guide touristique.
                Réponds toujours en français.
                Pour chaque ville ou pays demandé, donne exactement :
                - deux principaux endroits à visiter ;
                - le prix moyen d'un repas dans la devise locale.

                Retourne uniquement un objet JSON valide, sans introduction,
                sans conclusion, sans Markdown et sans commentaires.
                Respecte exactement cette structure :
                {
                  "ville_ou_pays": "nom de la ville ou du pays",
                  "endroits_a_visiter": ["endroit 1", "endroit 2"],
                  "prix_moyen_repas": "prix devise"
                }
                """));

        assistant = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .chatMemory(chatMemory)
                .build();
    }

    public String chat(String prompt) {
        return assistant.informationsTouristiques(prompt);
    }
}
