// package com.example.chatgpt;

// import java.util.Map;

// import org.springframework.stereotype.Component;

// import dev.langchain4j.agent.tool.Tool;

// @Component
// public class AssistantTools {
// // private static final Map<String, Double> DAILY_BASE_PRICE = Map.of(
// // "economico", 150.0,
// // "suv", 280.0,
// // "premium", 420.0);

// // private static final Map<String, Double> INSURANCE_RATE = Map.of(
// // "economico", 0.05,
// // "suv", 0.08,
// // "premium", 0.12);

// // @Tool("Calcula o valor total do aluguel corporativo com base na categoria
// do
// // carro e número de dias ")
// // public String calcularCota(String category, int days) {
// // Double base = DAILY_BASE_PRICE.get(category.toLowerCase());
// // Double rate = INSURANCE_RATE.get(category.toLowerCase());

// // double total = (base * days) * (1 + rate);
// // return String.format("Cotacao: %s por %d -> R$ %.2f (inclui seguro
// %.0f%%)",
// // category, days, total, rate * 100);
// // }

// @Tool("Acende a luz")
// public String acenderLuz() {
// System.out.println("Luz acesa");
// return "Luz acesa";
// }
// }
