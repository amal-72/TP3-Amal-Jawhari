# Utilisation de l'intelligence artificielle (IA)

Pendant la réalisation du TP3 REST, j'ai utilisé l'intelligence artificielle ponctuellement pour m'aider à comprendre certaines difficultés techniques rencontrées.

---

## Utilisation 1 : Sérialisation JSON dans JAX-RS

### 1. Problème rencontré

Lors de mes premiers tests de l'API REST, j'ai obtenu un tableau JSON en retournant un tableau de chaînes de caractères Java. Je voulais comprendre comment cette conversion était effectuée automatiquement.

### 2. Raison de l'utilisation de l'IA

Après avoir examiné le résultat obtenu et le fonctionnement de ma ressource REST, j'ai demandé une explication pour comprendre le rôle de JAX-RS dans cette conversion.

### 3. Prompt utilisé

« Pourquoi une méthode REST qui retourne un tableau de String affiche-t-elle directement un tableau JSON dans le navigateur ? Quel est le rôle de @Produces dans cette conversion ? »

### 4. Réponse de l'IA

JAX-RS utilise des mécanismes de sérialisation pour convertir les objets Java en réponses HTTP. L'annotation `@Produces("application/json")` indique que la réponse doit être produite au format JSON. Un mécanisme adapté permet alors de convertir le tableau Java en tableau JSON.

### 5. Ce que j'ai appris

J'ai compris que la conversion en JSON peut être effectuée automatiquement par JAX-RS. Il n'est donc pas nécessaire de construire manuellement la réponse JSON. J'ai également compris l'importance de l'annotation `@Produces` pour définir le format de réponse de l'API.

---

## Utilisation 2 : Suivi de l'utilisation des tokens avec LangChain4j

### 1. Problème rencontré

Après un appel au modèle Gemini, j'ai obtenu des informations sur l'utilisation des tokens. Je ne comprenais pas précisément la différence entre les tokens d'entrée, les tokens de sortie et le nombre total.

### 2. Raison de l'utilisation de l'IA

Les noms des propriétés ne me permettaient pas de comprendre complètement leur signification. J'ai donc demandé une explication afin de pouvoir interpréter correctement les informations retournées.

### 3. Prompt utilisé

« Peux-tu m'expliquer la différence entre inputTokenCount, outputTokenCount et totalTokenCount dans LangChain4j, avec un exemple ? »

### 4. Réponse de l'IA

- `inputTokenCount` correspond au nombre de tokens envoyés au modèle.
- `outputTokenCount` correspond au nombre de tokens générés par le modèle.
- `totalTokenCount` correspond au nombre total de tokens utilisés, soit la somme des tokens d'entrée et de sortie.

### 5. Ce que j'ai appris

J'ai compris la différence entre les tokens d'entrée et de sortie ainsi que le calcul du nombre total. J'ai également appris que ces informations permettent de suivre la consommation de tokens lors des appels à un modèle de langage.

---

## Conclusion

Ces deux utilisations m'ont permis de mieux comprendre des notions rencontrées pendant le TP3. J'ai retenu qu'il est important de comprendre le fonctionnement des mécanismes utilisés et pas seulement d'obtenir un résultat. Les explications m'ont aidée à approfondir mes connaissances et à mieux interpréter les résultats de mes tests.