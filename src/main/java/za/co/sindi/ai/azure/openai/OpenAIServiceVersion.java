/**
 * 
 */
package za.co.sindi.ai.azure.openai;

/**
 * @author Buhake Sindi
 * @since 15 March 2024
 */
public enum OpenAIServiceVersion {

	/**
     * Enum value 2022-12-01.
     */
    V2022_12_01("2022-12-01"),

    /**
     * Enum value 2023-05-15.
     */
    V2023_05_15("2023-05-15"),

    /**
     * Enum value 2023-06-01-preview.
     */
    V2023_06_01_PREVIEW("2023-06-01-preview"),

    /**
     * Enum value 2023-07-01-preview.
     */
    V2023_07_01_PREVIEW("2023-07-01-preview"),

    /**
     * Enum value 2023-08-01-preview.
     */
    V2023_08_01_PREVIEW("2023-08-01-preview"),

    /**
     * Enum value 2023-09-01-preview.
     */
    V2023_09_01_PREVIEW("2023-09-01-preview"),

    /**
     * Enum value 2023-12-01-preview.
     */
    V2023_12_01_PREVIEW("2023-12-01-preview"),
	
	/**
     * Enum value 2024-02-15-preview.
     */
    V2024_02_15_PREVIEW("2024-02-15-preview"),
    
    /**
     * Enum value 2024-03-01-preview.
     */
    V2024_03_01_PREVIEW("2024-03-01-preview"),
    
    /**
     * Enum value 2024-02-01.
     */
    V2024_02_01("2024-02-01");

    private final String version;

	/**
	 * @param version
	 */
	private OpenAIServiceVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
    
	/**
     * Gets the latest service version supported by this client library.
     * 
     * @return The latest {@link OpenAIServiceVersion}.
     */
    public static OpenAIServiceVersion getLatest() {
        return V2024_03_01_PREVIEW;
    }
}
