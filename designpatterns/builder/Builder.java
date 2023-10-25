public class Main {
	public static void main(String[] args) {
		UrlBuilder.Builder builder = new UrlBuilder.Builder();
		builder.protocol("https://").domain("localhost").port("8080");
		UrlBuilder urlBuilder = builder.build();

		System.out.println(urlBuilder.protocol);
		System.out.println(urlBuilder.domain);
		System.out.println(urlBuilder.port);
		System.out.println(urlBuilder.section);
	}
}

public class UrlBuilder {
	public static class Builder {
		private String protocol;
		private String subDomain;
		private String domain;
		private String tld;
		private String port;
		private String path;
		private String query;
		private String section;
		
		Builder protocol(String protocol) {
			this.protocol = protocol;
			return this;
		}
		
		Builder subDomain(String subDomain) {
			this.subDomain = subDomain;
			return this;
		}
		
		Builder domain(String domain) {
			this.domain = domain;
			return this;
		}
		
		Builder port(String port) {
			this.port = port;
			return this;
		}
		
		Builder tLD(String tld) {
			this.tld = tld;
			return this;
		}
		
		Builder path(String path) {
			this.path = path;
			return this;
		}
		
		Builder query(String query) {
			this.query = query;
			return this;
		}
		
		Builder section(String section) {
			this.section = section;
			return this;
		}
		
		UrlBuilder build() {
			return new UrlBuilder(this);
		}
	}

	public String protocol;
	public String subDomain;
	public String domain;
	public String tld;
	public String port;
	public String path;
	public String query;
	public String section;

	public UrlBuilder(Builder builder) {
		this.protocol  = builder.protocol;
		this.subDomain = builder.subDomain;
		this.domain    = builder.domain;
		this.tld       = builder.tld;
		this.port      = builder.port;
		this.path      = builder.path;
		this.query     = builder.query;
		this.section   = builder.section;
	}
}

