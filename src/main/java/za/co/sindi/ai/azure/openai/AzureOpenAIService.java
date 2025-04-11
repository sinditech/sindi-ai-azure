/**
 * 
 */
package za.co.sindi.ai.azure.openai;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import za.co.sindi.ai.openai.OpenAIClient;
import za.co.sindi.ai.openai.OpenAIService;
import za.co.sindi.ai.openai.assistants.AssistantInput;
import za.co.sindi.ai.openai.assistants.CreateAssistantRequest;
import za.co.sindi.ai.openai.chat.ChatCompletionRequest;
import za.co.sindi.ai.openai.chat.ChatConversation;
import za.co.sindi.ai.openai.completions.CompletionInput;
import za.co.sindi.ai.openai.completions.CompletionRequest;
import za.co.sindi.ai.openai.embeddings.CreateEmbeddingRequest;
import za.co.sindi.ai.openai.embeddings.EmbeddingInput;
import za.co.sindi.ai.openai.implementation.OpenAIClientImpl;
import za.co.sindi.ai.openai.models.Assistant;
import za.co.sindi.ai.openai.models.ChatCompletion;
import za.co.sindi.ai.openai.models.Completion;
import za.co.sindi.ai.openai.models.EmbeddingList;

/**
 * @author Buhake Sindi
 * @since 15 March 2024
 */
public class AzureOpenAIService implements OpenAIService {

	private final OpenAIClient openAIClient;
	
	private final String completionsPath;
	private final String embeddingsPath;
	private final String chatCompletionsPath;
	private final String assistantsPath;
	
	/**
	 * @param resourceName
	 * @param deploymentId
	 * @param serviceVersion
	 * @param apiKey
	 */
	public AzureOpenAIService(String resourceName, String deploymentId, OpenAIServiceVersion serviceVersion, String apiKey) {
		super();
		Objects.requireNonNull(resourceName, "The Azure resource name is required.");
		Objects.requireNonNull(deploymentId, "The Azure deployment ID is required.") ;
		Objects.requireNonNull(serviceVersion, "The Azure API version is required.");
		this.openAIClient = new OpenAIClientImpl(String.format("https://%s.openai.azure.com/openai/deployments/%s", resourceName, deploymentId), Objects.requireNonNull(apiKey, "The API key is required."), null);
		
		this.completionsPath = String.format("/completions?api-version=%s", serviceVersion.getVersion());
		this.embeddingsPath = String.format("/embeddings?api-version=%s", serviceVersion.getVersion());
		this.chatCompletionsPath = String.format("/chat/completions?api-version=%s", serviceVersion.getVersion());
		this.assistantsPath = String.format("/assistants?api-version=%s", serviceVersion.getVersion());
	}
	
	public Completion createCompletion(final CompletionInput<?> completionInput) throws IOException, InterruptedException {
		CompletionRequest request = new CompletionRequest(completionsPath, completionInput);
		return openAIClient.send(request);
	}
	
	public CompletableFuture<Completion> createCompletionAsync(final CompletionInput<?> completionInput) {
		CompletionRequest request = new CompletionRequest(completionsPath, completionInput);
		return openAIClient.sendAsync(request);
	}
	
	public EmbeddingList createEmbedding(final EmbeddingInput<?> input) throws IOException, InterruptedException {
		CreateEmbeddingRequest request = new CreateEmbeddingRequest(embeddingsPath, input);
		return openAIClient.send(request);
	}
	
	public CompletableFuture<EmbeddingList> createEmbeddingAsync(final EmbeddingInput<?> input) {
		CreateEmbeddingRequest request = new CreateEmbeddingRequest(embeddingsPath, input);
		return openAIClient.sendAsync(request);
	}
	
	public ChatCompletion createChatCompletion(final ChatConversation conversation) throws IOException, InterruptedException {
		ChatCompletionRequest request = new ChatCompletionRequest(chatCompletionsPath, conversation);
		return openAIClient.send(request);
	}
	
	public CompletableFuture<ChatCompletion> createChatCompletionAsync(final ChatConversation conversation) {
		ChatCompletionRequest request = new ChatCompletionRequest(chatCompletionsPath, conversation);
		return openAIClient.sendAsync(request);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.ai.openai.OpenAIService#createAssistant(za.co.sindi.ai.openai.assistants.AssistantInput)
	 */
	@Override
	public Assistant createAssistant(AssistantInput input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		CreateAssistantRequest request = new CreateAssistantRequest(assistantsPath, input);
		return openAIClient.send(request);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.ai.openai.OpenAIService#createAssistantAsync(za.co.sindi.ai.openai.assistants.AssistantInput)
	 */
	@Override
	public CompletableFuture<Assistant> createAssistantAsync(AssistantInput input) {
		// TODO Auto-generated method stub
		CreateAssistantRequest request = new CreateAssistantRequest(assistantsPath, input);
		return openAIClient.sendAsync(request);
	}
}
