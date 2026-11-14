package ma.emsi.amal.tp3amaljawhari.llm;

public record TokenUsageDto(
        Integer inputTokenCount,
        Integer outputTokenCount,
        Integer totalTokenCount
) {
}